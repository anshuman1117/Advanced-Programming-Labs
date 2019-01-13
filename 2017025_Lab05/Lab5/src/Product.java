
public class Product {

	private String name;
	private int quantity;
	private int price;
	private String path;
	
	//Constructor
	public Product(String name, int quantity, int price) {
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		path = "";
	}
	
	public Product(String name, int quantity, int price, String path) {
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.path = path;
	}
	
	
	
	// Getter and Setter functions
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public void updatePath(String newP) {
		path = newP + " > " + this.name;
	}
	
	public String getPath() {
		return path;
	}
	

}
