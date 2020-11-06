package shopping;

public class ItemToPurchase {
	private String itemName;
	private String itemDescription;
	private int itemPrice;
	private int	itemQuantity;
	
	public ItemToPurchase() {
		this("none", 0, 0, "none");
	}
	
	public ItemToPurchase(String itemName) {
		this(itemName, 0, 0, "none");
	}
	
	public ItemToPurchase(String itemName, int itemQuantity) {
		this(itemName, itemQuantity, 0, "none");
	}
	
	public ItemToPurchase(String itemName, int itemQuantity, int itemPrice) {
		this(itemName, itemQuantity, itemPrice, "none");
	}
	
	public ItemToPurchase(String itemName, int itemQuantity, int itemPrice, String itemDescription) {
		this.itemName = itemName;
		this.itemQuantity = itemQuantity;
		this.itemPrice = itemPrice;
		this.itemDescription = itemDescription;
	}
	
	public void setName(String newItemName) {
		itemName = newItemName;
	}
	
	public String getName() {
		return itemName;
	}
	
	public void setPrice(int newItemPrice) {
		itemPrice = newItemPrice;
	}
	
	public int getPrice() {
		return itemPrice;
	}
	
	public void setQuantity(int newItemQuantity) {
		itemQuantity = newItemQuantity;
	}
	
	public int getQuantity() {
		return itemQuantity;
	}
	
	public void setDescription(String newItemDescription) {
		itemDescription = newItemDescription;
	}
		
	public String getDescription() {
		return itemDescription;
	}
	
	public void printItemCost() {
		System.out.println(new StringBuilder(getName()).append(" ")
													   .append(itemQuantity)
													   .append(" @ $")
													   .append(itemPrice)
													   .append(" = $")
													   .append(itemPrice * itemQuantity).toString());
	}
	
	public void printItemDescription() {
		System.out.println(new StringBuilder(getName()).append(": ")
													   .append(itemDescription).toString());
	}
}