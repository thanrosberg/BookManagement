package collection;

import java.util.Scanner;

public class BookMain {
	Scanner keyboard = new Scanner(System.in);

	public void option() {
		BookManagement book_Management = new BookManagement();
		String menu = "";

		while (true) {
			System.out.println("===============================MENU================================");
			System.out.println("1. Display all of book      9. Find book by max_Price ");
			System.out.println("2. Add book                 10. Find book by min_Price ");
			System.out.println("3. Find book by ID          11. Sort book by ID from A - Z ");
			System.out.println("4. Find book by Name        12. Sort book by ID from Z - A ");
			System.out.println("5. Edit book by ID          13. Sort book by Name from A - Z ");
			System.out.println("6. Edit book by Name        14. Sort book by Name from Z - A ");
			System.out.println("7. Remove book by ID        15. Sort book by Price from Low - High ");
			System.out.println("8. Remove book by Name      16. Sort book by Price from High - Low ");
			System.out.println("0. Exit ");
			System.out.println("===================================================================");
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
				System.out.print("Enter Name need Remove: ");
				String name_Remove = keyboard.nextLine();
				book_Management.removeBookByName(name_Remove);
				break;

			case "9":
				book_Management.displayBookMaxPrice();
				break;
				
			case "10":
				book_Management.displayBookMinPrice();
				break;
				
			case "11":
				book_Management.sortBookIdAtoZ();
				break;

			case "12":
				book_Management.sortBookIdZtoA();
				break;
				
			case "13":
				book_Management.sortBookNameAtoZ();
				break;

			case "14":
				book_Management.sortBookNameZtoA();
				break;
				
			case "15":
				book_Management.sortBookPriceLowToHigh();
				break;

			case "16":
				book_Management.sortBookPriceHighToLow();
				break;
				
			case "0":
				System.out.println("Good bye!");
				return;
			}
		}
	}

	public static void main(String[] args) {
		BookMain book_Main = new BookMain();
		book_Main.option();
	}
}
