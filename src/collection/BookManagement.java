package collection;

import java.util.ArrayList;
import java.util.Scanner;

public class BookManagement{
	public int action_Update;
	ArrayList<Book> book_List = new ArrayList<>();
	Scanner keyboard = new Scanner(System.in);

	// Enters Book's information
	public void inputBook(Book input_Book) {
		System.out.print("Enter Id: ");
		String id = keyboard.nextLine();

		System.out.print("Enter Name: ");
		String name = keyboard.nextLine();
		input_Book.setName(name);
		input_Book.setId(id);

		System.out.print("Enter Price: ");
		int price = Integer.parseInt(keyboard.nextLine().trim());
		input_Book.setPrice(price);
	}

	public String outputBook(Book out_Book) {
		return "[ID = " + out_Book.getId() + ", Name = " + out_Book.getName() + ", Price = " + out_Book.getPrice()
				+ "]";
	}

	// Add Book's information into book list
	public void addBook() {
		Book add_Book = new Book();
		inputBook(add_Book);
		book_List.add(add_Book);
	}

	// Display all of book in the book list
	public void displayAllOfBook() {
		int book_Numerical = 0;
		if (!book_List.isEmpty()) {
			for (Book out_Book : book_List) {
				System.out.println("Book " + ++book_Numerical + ": " + outputBook(out_Book));
			}
		} else {
			System.out.println("Not found book. Please add book!");
			addBook();
		}

		System.out.println("Total Book in list: " + book_List.size());
	}

	// Find book by ID
	public void findBookById(String id) {
		int count_ID = 0;
		int book_Numerical_Id = 0;
		for (Book book_Find_Id : book_List) {
			if (book_Find_Id.getId().equalsIgnoreCase(id)) {
				for (Book book_ID : book_List) {
					if (book_ID.getId().equalsIgnoreCase(id)) {
						System.out.println("Book " + ++book_Numerical_Id + ": " + outputBook(book_ID));
						count_ID++;
					}
				}
				break;
			}
		}
		System.out.println("Total book has ID " + id + " is: " + book_Numerical_Id);

		if (count_ID == 0) {
			System.out.println("Not found book id. Pease try again!");
			System.out.print("Enter ID need find: ");
			String id_Again = keyboard.nextLine();
			findBookById(id_Again);
		}
	}

	// Find book by Name
	public void findBookByName(String name) {
		int count_Name = 0;
		int book_Numerical_Name = 0;
		for (Book book_Find_Name : book_List) {
			if (book_Find_Name.getName().equalsIgnoreCase(name)) {
				for (Book book_Name : book_List) {
					if (book_Name.getName().equalsIgnoreCase(name)) {
						System.out.println("Book " + ++book_Numerical_Name + ": " + outputBook(book_Name));
						count_Name++;
					}
				}
				break;
			}
		}
		System.out.println("Total book has ID " + name + " is: " + book_Numerical_Name);

		if (count_Name == 0) {
			System.out.println("Not found book name. Pease try again!");
			System.out.print("Enter Name need find: ");
			String name_Again = keyboard.nextLine();
			findBookById(name_Again);
		}
	}

	// Edit book by ID
	public void editBookById(String id) {
		BookHelper object_Book_Helper = new BookHelper();
		int count_Edit_ID = 0;
		for (Book book_Edit_Id : book_List) {
			if (book_Edit_Id.getId().equalsIgnoreCase(id)) {
				for (Book book_Id : book_List) {
					if (book_Id.getId().equalsIgnoreCase(id)) {
						object_Book_Helper.option_Update(book_Id);
						count_Edit_ID++;
						System.out.println("******Book information after edit*******");
						System.out.println(outputBook(book_Id));
					}
				}
				break;
			}
		}

		if (count_Edit_ID == 0) {
			System.out.println("Not found book id. Pease try again!");
			System.out.print("Enter ID need edit: ");
			String id_Edit_Again = keyboard.nextLine();
			editBookById(id_Edit_Again);
		}
	}

	// Edit book by Name
	public void editBookByName(String name) {
		BookHelper object_Book_Helper = new BookHelper();
		int count_Edit_Name = 0;
		for (Book book_Edit_Name : book_List) {
			if (book_Edit_Name.getName().equalsIgnoreCase(name)) {
				for (Book book_Name : book_List) {
					if (book_Name.getName().equalsIgnoreCase(name)) {
						object_Book_Helper.option_Update(book_Name);
						count_Edit_Name++;
						System.out.println("******Book information after edit*******");
						System.out.println(outputBook(book_Edit_Name));
						break;
					}
				}
				break;
			}
		}

		if (count_Edit_Name == 0) {
			System.out.println("Not found book id. Pease try again!");
			System.out.print("Enter ID need edit: ");
			String name_Edit_Again = keyboard.nextLine();
			findBookById(name_Edit_Again);
		}
	}

	// Remove book by ID
	public void removeBookById(String id) {
		int count_Remove_ID = 0;
		/*
		 * book_List.forEach((book_Id) -> { if (book_Id.getId().equalsIgnoreCase(id))
		 * book_List.remove(book_Id); return; });
		 */
		for (Book book_Remove_Id : book_List) {
			if (book_Remove_Id.getId().equalsIgnoreCase(id)) {
				for (Book book_Id : book_List) {
					if (book_Id.getId().equalsIgnoreCase(id)) {
						count_Remove_ID++;
					}
				}

				book_List.remove(book_Remove_Id);
			}
		}
		System.out.println("******Book information after remove*******");
		displayAllOfBook();

		if (count_Remove_ID == 0) {
			System.out.println("Not found book id. Pease try again!");
			System.out.print("Enter ID need remove: ");
			String id_Remove_Again = keyboard.nextLine();
			removeBookById(id_Remove_Again);
		}
	}

	// Remove book by Name
	public void removeBookByName(String name) {
		int count_Remove_Name = 0;
		book_List.forEach((book_Name) -> {
			if (book_Name.getName().equalsIgnoreCase(name))
				book_List.remove(book_Name);
			return;
		});
		/*
		 * for (Book book_Remove_Name : book_List) { if
		 * (book_Remove_Name.getName().equalsIgnoreCase(name)) { for (Book book_Name :
		 * book_List) { if (book_Name.getName().equalsIgnoreCase(name)) {
		 * book_List.remove(book_Name); count_Remove_Name++; } } } }
		 */
		System.out.println("******Book information after remove*******");
		displayAllOfBook();

		if (count_Remove_Name == 0) {
			System.out.println("Not found book Name. Pease try again!");
			System.out.print("Enter Name need remove: ");
			String name_Remove_Again = keyboard.nextLine();
			removeBookById(name_Remove_Again);
		}
	}

	// Display Book has maximum Price
	public void displayBookMaxPrice() {
		/*Book max = book_List.get(0);
		for (int i = 1; i <= book_List.size() - 1; i++) {
			if (max.getPrice() < book_List.get(i).getPrice()) {
				max = book_List.get(i);
				System.out.println(outputBook(max));
			}
		}*/
		
		//THIS 2 WAY: Using Lamda Expression
		book_List.sort((a,b) -> a.getPrice() - b.getPrice());
		System.out.println(outputBook(book_List.get(book_List.size() - 1)));
		 
		book_List.sort((a,b) -> b.getPrice() - a.getPrice());
		System.out.println(outputBook(book_List.get(book_List.size() - 1)));
	}
}