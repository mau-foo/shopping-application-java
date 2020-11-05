package shopping;

import java.util.ArrayList;

public class ShoppingCart {
	private String customerName;
	private String currentDate;
	ArrayList<ItemToPurchase> cartItems;
	

	public ShoppingCart() {
		this.customerName = "none";
		this.currentDate = "January 1, 2016";
		cartItems = new ArrayList<ItemToPurchase>();
	}
	
	public ShoppingCart(String customerName, String currentDate) {
		this.customerName = customerName;
		this.currentDate = currentDate;
		cartItems = new ArrayList<ItemToPurchase>();
	}
	
	public String getCustomerName() {
		return customerName;
	}
	
	public String getDate() {
		return currentDate;
	}
		
	public void addItem(ItemToPurchase shoppingItem) {		
		cartItems.add(shoppingItem);
	}
	
	public void removeItem(String shoppingItemName) {
		int totalItemsBefore = cartItems.size();
		
		if (!cartItems.isEmpty()) {
			for (int i = 0; i < cartItems.size(); i++) {
				if (cartItems.get(i).getName().equalsIgnoreCase(shoppingItemName)) {
					cartItems.remove(i);
				}
			}
			if (totalItemsBefore == cartItems.size()) {
				System.out.println("Item not found in cart. Nothing removed.");
			}
		}
	}
	
	public void modifyItem(ItemToPurchase shoppingItem) {
		boolean hasBeenModified = false;
		
		if (!cartItems.isEmpty()) {
			for (ItemToPurchase cartitem: cartItems) {
				if (cartitem.getName().equalsIgnoreCase(shoppingItem.getName())) {
					if (shoppingItem.getQuantity() != 0) {
						cartitem.setQuantity(shoppingItem.getQuantity());
						hasBeenModified = true;
					}
				}
			}
			if (!hasBeenModified) {
				System.out.println("Item not found in cart. Nothing modified.");
			}
		}
	}
	
	public int getNumItemsInCart() {
		int totalQuantity = 0;
		
		if (!cartItems.isEmpty()) {
			for (ItemToPurchase cartItem : cartItems) {
				totalQuantity += cartItem.getQuantity();
			}
		}
		return totalQuantity;
	}
	
	public int getCostOfCart() {
		int totalCost = 0;
		
		if (!cartItems.isEmpty()) {
			for (ItemToPurchase cartItem : cartItems) {
				totalCost += (cartItem.getPrice() * cartItem.getQuantity());
			}
		} 
		return totalCost;
	}

	public void printTotal() {
		System.out.println(getCustomerName() + "'s Shopping Cart - " + getDate());
		System.out.println("Number of Items: " + getNumItemsInCart() + "\n");
		if (cartItems.isEmpty()) {
			System.out.println("SHOPPING CART IS EMPTY\n\n" + "Total: $" + getCostOfCart());
		} else {
			for (ItemToPurchase cartItem : cartItems) {
				cartItem.printItemCost();
			}
			System.out.println("\nTotal: $" + getCostOfCart());
		}
	}
	
	public void printDescriptions() {
		if (cartItems.isEmpty()) {
			System.out.println("SHOPPING CART IS EMPTY\n");
		} else {
			System.out.println(getCustomerName() + "'s Shopping Cart - " + getDate() + "\n\nItem Descriptions");
			for (ItemToPurchase item : cartItems) {
				item.printItemDescription();
			}
		}
	}
}