package collection;

import java.util.ArrayList;
import java.util.Scanner;

public class BookManagement {
	public String action = "";
	ArrayList<Book> book_List = new ArrayList<>();
	Scanner keyboard = new Scanner(System.in);

	// Enters Book's information
	public void inputBook(Book input_Book) {
		
		if (action != "u") {
			System.out.print("Enter Id: ");
			String id = keyboard.nextLine();
			input_Book.setId(id);
		}
		
		System.out.print("Enter Name: ");
		String name = keyboard.nextLine();
		input_Book.setName(name);
	}

	public String outputBook(Book out_Book) {
		return "[ID = " + out_Book.getId() + ", Name = " + out_Book.getName() + "]";
	}

	// Add Book's information into book list
	public void addBook() {
		Book add_Book = new Book();
		action = "a";
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
	
	public void inputUpdateBookById(Book update_Book_Id) {
		System.out.print("Enter Name: ");
		String name_Update = keyboard.nextLine();
		update_Book_Id.setName(name_Update);
	}

	// Edit book by ID
	public void editBookById(String id) {
		int count_Edit_ID = 0;
		for (Book book_Edit_Id : book_List) {
			if (book_Edit_Id.getId().equalsIgnoreCase(id)) {
				for (Book book_Id : book_List) {
					if (book_Id.getId().equalsIgnoreCase(id)) {
						action = "u";
						inputBook(book_Id);
						count_Edit_ID++;
						System.out.println("******Book information after edit*******");
						System.out.println(outputBook(book_Edit_Id));
						
					}
				}
				break;
			}
		}

		if (count_Edit_ID == 0) {
			System.out.println("Not found book id. Pease try again!");
			System.out.print("Enter ID need edit: ");
			String id_Edit_Again = keyboard.nextLine();
			findBookById(id_Edit_Again);
		}
	}

}