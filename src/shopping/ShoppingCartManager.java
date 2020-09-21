package shopping;

import java.util.Scanner;

public class ShoppingCartManager {
	// Menu for managing items in shopping cart
	public static void printMenu(ShoppingCart cart, Scanner input) {
		String menu = "\nMENU\na - Add item to cart\nd - Remove item from cart\nc - Change item's details\ni - Output item's descriptions\no - Output shopping cart\nq - Quit\n";
		char option = 'q';
		
		System.out.println(menu);
		do {
			System.out.println("Choose an option: ");
			option = input.next().charAt(0);
			input.nextLine(); // Consume leftover new line
			switch (option) {
				case 'q':
					break;
				case 'a':
					System.out.println("ADD ITEM TO CART");
					cart.addItem(input);
					break;
				case 'd':
					System.out.println("REMOVE ITEM FROM CART");
					cart.removeItem(input);
					break;
				case 'c':
					System.out.println("CHANGE ITEM DETAILS");
					cart.modifyItem(input);
					break;
				case 'i':
					System.out.println("OUTPUT ITEMS' DESCRIPTIONS");
					cart.printDescriptions();
					break;
				case 'o':
					System.out.println("OUTPUT SHOPPING CART");
					cart.printTotal();
					break;
			}
		} while (option != 'q');
	}
	
	public static void main(String[] args) {
		// Main variables
		String userName;
		String todayDate;
		ShoppingCart userCart;
		
		Scanner scnr = new Scanner(System.in); // Scanner to read user input
		
		// Provide name of shopper and shopping date
		System.out.println("Enter Customer's Name:");
		userName = scnr.nextLine();
		System.out.println("Enter Today's Date:");
		todayDate = scnr.nextLine();
		
		userCart = new ShoppingCart(userName, todayDate); // create shopping cart object
		
		printMenu(userCart, scnr);
		
		scnr.close(); // close scanner
	}
}