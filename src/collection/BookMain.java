package collection;

import java.util.Scanner;

public class BookMain {
	Scanner keyboard = new Scanner(System.in);

	public void option() {
		BookManagement book_Management = new BookManagement();
		String menu = "";

		while (true) {
			System.out.println("===========MENU===========");
			System.out.println("1. Display all of book    ");
			System.out.println("2. Add book               ");
			System.out.println("3. Find book by ID        ");
			System.out.println("4. Find book by Name      ");
			System.out.println("5. Edit book by ID        ");
			System.out.println("6. Edit book by Name      ");
			System.out.println("7. Remove book by ID      ");
			System.out.println("8. Exit                   ");
			System.out.println("==========================");
			System.out.print("Enter your option: ");
			menu = keyboard.nextLine();
			switch (menu) {
			case "1":
				book_Management.displayAllOfBook();
				break;

			case "2":
				book_Management.addBook();
				break;

			case "3":
				System.out.print("Enter ID need find: ");
				String id_Find = keyboard.nextLine();
				book_Management.findBookById(id_Find);
				break;

			case "4":
				System.out.print("Enter Name need find: ");
				String name_Find = keyboard.nextLine();
				book_Management.findBookByName(name_Find);
				break;

			case "5":
				System.out.print("Enter ID need edit: ");
				String id_Edit = keyboard.nextLine();
				book_Management.editBookById(id_Edit);
				break;

			case "6":
				System.out.print("Enter Name need edit: ");
				String name_Edit = keyboard.nextLine();
				book_Management.editBookByName(name_Edit);
				break;

			case "7":
				System.out.print("Enter ID need Remove: ");
				String id_Remove = keyboard.nextLine();
				book_Management.removeBookById(id_Remove);
				break;

			case "8":
				System.out.println("Good bye!");
				break;
			}
		}
	}

	public static void main(String[] args) {
		BookMain book_Main = new BookMain();
		book_Main.option();
	}
}
