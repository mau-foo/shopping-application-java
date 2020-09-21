package shopping;

import java.util.ArrayList;
import java.util.Scanner;

public class ShoppingCart {
	// Shopping cart variables (private)
	private String customerName;
	private String currentDate;
	private static final String MODIFY_MENU = "\nMENU\n\na - Modify price\nb - Modify quantity\nc - Modify description\n\nPlease enter your choice: ";
	
	// Shopping cart variables (public)
	ArrayList<ItemToPurchase> cartItems = new ArrayList<ItemToPurchase>(); // initialize array for shopping cart items
	
	// Default constructor
	public ShoppingCart() {
		customerName = "none";
		currentDate  = "January 1, 2016";
	}
	
	// Parameterized constructor
	public ShoppingCart(String name, String date) {
		customerName = name;
		currentDate  = date;
	}
	
	// Getter methods for variables
	public String getCustomerName() {
		return customerName;
	}
	
	public String getDate() {
		return currentDate;
	}
	
	// Add item to shopping cart
	public void addItem(Scanner inputReader) {
		String productName = "";
		String productDesc = "";
		double productPrice    = 0.0;
		int    productQuantity = 0;
		
		System.out.println("Enter the item name:");
		productName = inputReader.nextLine();
		System.out.println("Enter the item description:");
		productDesc = inputReader.nextLine();
		System.out.println("Enter the item price:");
		productPrice = inputReader.nextDouble();
		inputReader.nextLine(); // Consume leftover new line
		System.out.println("Enter the item quantity:");
		productQuantity = inputReader.nextInt();
		inputReader.nextLine(); // Consume leftover new line
		
		cartItems.add(new ItemToPurchase(productName, productDesc, productPrice, productQuantity));
	}
	
	// Remove item from shopping cart
	public void removeItem(Scanner inputReader) {
		boolean doesExist = false;
		String itemName   = "";
		
		System.out.println("Enter name of item to remove:");
		itemName = inputReader.nextLine();
		
		for (ItemToPurchase item : cartItems) {
			if (item.getName().equalsIgnoreCase(itemName)) { // Search item by name
				cartItems.remove(item);
				doesExist = true;
				break;
			}
		}
		
		if (doesExist) {
			return;			
		} else {
			System.out.println("Item not found in cart. Nothing removed.");
		}
	}
	
	// Modify an item's details
	public void modifyItem(Scanner inputReader) {
		boolean doesExist = false;
		char modifyChoice = 'a';
		String itemName   = "";
		
		System.out.println("Please provide the name of item you would like to modify.");
		itemName = inputReader.nextLine();
		
		for (ItemToPurchase item: cartItems) {
			if (item.getName().equalsIgnoreCase(itemName)) { // Search item by name
				System.out.println(MODIFY_MENU);
				modifyChoice = inputReader.next().charAt(0);
				inputReader.nextLine(); 					 // Consume leftover new line
				
				switch (modifyChoice) {
					case 'a':
						System.out.println("Please provide a new price.");
						item.setPrice(inputReader.nextDouble());
						inputReader.nextLine(); 					 // Consume leftover new line
						break;
					case 'b':
						System.out.println("Please provide a new quantity.");
						item.setQuantity(inputReader.nextInt());
						inputReader.nextLine(); 					 // Consume leftover new line
						break;
					case 'c':
						System.out.println("Please provide a new description.");
						item.setDescription(inputReader.nextLine());
						break;
					default:
						System.out.println("Invalid Choice.\n");
						break;
				}
				doesExist = true;
				break;
			}
		}
		
		if (doesExist) {
			return;			
		} else {
			System.out.println("Item not found in cart. Nothing modified.");
		}
	}
	
	// Find total quantity of items in the shopping cart
	public int getNumItemsInCart() {
		if (cartItems.isEmpty()) {
			return 0;
		} else {
			int totalQuantity = 0;
			
			for (ItemToPurchase item : cartItems) {
				totalQuantity += item.getQuantity();
			}
			return totalQuantity;
		}
	}
	
	// Find total cost of shopping cart
	public double getCostOfCart() {
		if (cartItems.isEmpty()) {
			return 0.0;
		} else {
			double cartTotalCost = 0.0;
			
			for (ItemToPurchase item : cartItems) {
				cartTotalCost += (item.getPrice() * item.getQuantity());
			}
			return cartTotalCost;
		}
	}
	
	// Display shopping cart owner
	public void printCartOwner() {
		System.out.println(new StringBuilder(getCustomerName()).append("'s Shopping Cart - ").append(getDate()));
	}
	
	// Display the contents of the shopping cart
	public void printTotal() {
		printCartOwner();
		System.out.println("Number of Items: " + getNumItemsInCart() + "\n");
		
		if (cartItems.isEmpty()) {
			System.out.println("SHOPPING CART IS EMPTY\n");
			System.out.println("Total: $" + getCostOfCart());
		} else {
			for (ItemToPurchase item : cartItems) {
				item.printItemCost();
			}
			System.out.println("Total: $" + getCostOfCart());
		}
	}
	
	// Display descriptions for all items in the shopping cart
	public void printDescriptions() {
		if (cartItems.isEmpty()) {
			System.out.println("SHOPPING CART IS EMPTY\n");
		} else {
			printCartOwner();
			System.out.println("\nItem Descriptions: ");
			
			for (ItemToPurchase item : cartItems) {
				item.printItemDescription();
			}
		}
	}
}