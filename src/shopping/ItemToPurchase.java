package shopping;

public class ItemToPurchase {
	private String itemName;
	private String itemDescription;
	private int itemPrice;
	private int	itemQuantity;
	

	public ItemToPurchase() {
		itemName = "none";
		itemDescription = "none";
		itemPrice = 0;
		itemQuantity = 0;
	}
	
	public ItemToPurchase(String itemName, int itemQuantity) {
		this(itemName, "none", 0, itemQuantity);
	}
	
	public ItemToPurchase(String itemName, String itemDescription, int itemPrice, int itemQuantity) {
		this.itemName = itemName;
		this.itemDescription = itemDescription;
		this.itemPrice = itemPrice;
		this.itemQuantity = itemQuantity;
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