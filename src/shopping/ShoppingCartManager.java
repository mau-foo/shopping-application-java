package shopping;

import java.util.Scanner;

public class ShoppingCartManager {
	public static ShoppingCart getShoppingCart(Scanner userInput) {
		String shopperName;
		String todayDate;
		ShoppingCart shoppingCart;
		
		System.out.println("Enter Customer's Name:");
		shopperName = userInput.nextLine();
		System.out.println("Enter Today's Date:\n");
		todayDate = userInput.nextLine();
		System.out.println("Customer Name: " + shopperName + "\nToday's Date: " + todayDate);
		shoppingCart = new ShoppingCart(shopperName, todayDate);
		
		return shoppingCart;
	}
	
	public static void printMenu(ShoppingCart shoppingCart, Scanner userInput) {
		String shoppingMenu = "\nMENU\n" + 
					  		  "a - Add item to cart\n" +
					  		  "d - Remove item from cart\n" +
					  		  "c - Change item quantity\n" +
					  		  "i - Output items' descriptions\n" +
					  		  "o - Output shopping cart\n" +
					  		  "q - Quit\n";
		char selectedOption = 'a';
		String cartItemName;
		String cartItemDescription;
		int cartItemPrice;
		int	cartItemQuantity;
		ItemToPurchase shoppingCartItem;
		
		System.out.println(shoppingMenu);
		while (selectedOption != 'q') {
			System.out.println("Choose an option:");
			selectedOption = userInput.next().charAt(0);
			if (userInput.hasNextLine()) {
				userInput.nextLine();
			}
			
			switch (selectedOption) {
				case 'q':
					break;
				case 'a':
					System.out.println("ADD ITEM TO CART");
					System.out.println("Enter the item name:");
					cartItemName = userInput.nextLine();
					System.out.println("Enter the item description:");
					cartItemDescription = userInput.nextLine();
					System.out.println("Enter the item price:");
					cartItemPrice = Integer.parseInt(userInput.nextLine());
					System.out.println("Enter the item quantity:");
					cartItemQuantity = Integer.parseInt(userInput.nextLine());

					shoppingCart.addItem(new ItemToPurchase(cartItemName, cartItemDescription, cartItemPrice, cartItemQuantity));
					System.out.println(shoppingMenu);
					break;
				case 'd':
					System.out.println("REMOVE ITEM FROM CART");
					System.out.println("Enter name of item to remove:");
					cartItemName = userInput.nextLine();
					shoppingCart.removeItem(cartItemName);
					System.out.println(shoppingMenu);
					break;
				case 'c':
					System.out.println("CHANGE ITEM QUANTITY");
					System.out.println("Enter the item name:");
					cartItemName = userInput.nextLine();
					System.out.println("Enter the new quantity:");
					cartItemQuantity = Integer.parseInt(userInput.nextLine());
					
					shoppingCartItem = new ItemToPurchase(cartItemName, cartItemQuantity);
					shoppingCart.modifyItem(shoppingCartItem);
					System.out.println(shoppingMenu);
					break;
				case 'i':
					System.out.println("OUTPUT ITEMS' DESCRIPTIONS");
					shoppingCart.printDescriptions();
					System.out.println(shoppingMenu);
					break;
				case 'o':
					System.out.println("OUTPUT SHOPPING CART");
					shoppingCart.printTotal();
					System.out.println(shoppingMenu);
					break;
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		ShoppingCart shoppingCart;
		shoppingCart = getShoppingCart(userInput);
		printMenu(shoppingCart, userInput);
		
		userInput.close();
	}
}