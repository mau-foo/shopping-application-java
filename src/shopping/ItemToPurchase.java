package shopping;

public class ItemToPurchase {
	// Shopping item variables (private)
	private String itemName;
	private String itemDescription;
	private double itemPrice;
	private int	   itemQuantity;
	
	// Default constructor
	public ItemToPurchase() {  
		itemName 	 	= "none";
		itemDescription = "none";
		itemPrice 	 	= 0.0;
		itemQuantity 	= 0;
	}
	
	// Parameterized constructor
	public ItemToPurchase(String name, String description, double price, int quantity) {
		itemName  		= name;
		itemDescription = description;
		itemPrice 		= price;
		itemQuantity	= quantity;
	}
	
	// Getter and setter methods for variables
	public String getName() {
		return itemName;
	}
	
	public void setName(String newName) {
		itemName = newName;
	}
	
	public double getPrice() {
		return itemPrice;
	}
	
	public void setPrice(double newPrice) {
		itemPrice = newPrice;
	}
	
	public int getQuantity() {
		return itemQuantity;
	}
	
	public void setQuantity(int newQuantity) {
		itemQuantity = newQuantity;
	}
	
	public String getDescription() {
		return itemDescription;
	}
	
	public void setDescription(String newDescription) {
		itemDescription = newDescription;
	}
	
	// Display total cost of an item
	public void printItemCost() {
		System.out.println(new StringBuilder(getName()).append(" ").append(getQuantity()).append(" @ $").append(getPrice()).append(" = $").append(getPrice() * getQuantity()).toString());
	}
	
	// Display an item's description
	public void printItemDescription() {
		System.out.println(new StringBuilder(getName()).append(": ").append(getDescription()).toString());
	}	
}