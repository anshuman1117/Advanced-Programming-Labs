import java.io.Serializable;
import java.util.*;
public class Customer implements Serializable{

	private static final long serialVersionUID = 8547219232373715101L;
	
	private final int UID;
	private Cart customerCart;
	private int funds;
	private int Cartsize;
	private dataBase D;
	private final String name;
	
	public Customer(dataBase D, int UID, String name) {
		customerCart = new Cart();
		Cartsize = 0;
		funds = 0;
		this.D = D;
		this.UID = UID;
		this.name = name;
	}
	
	public int getUID() {
		return UID;
	}
	
	public String getName() {
		return name;
	}
	
	// Adding a product to the cart
	public void addProduct(String name, int quantity) throws InvalidProductException , InsufficientQtyException{
		Product Srchd = D.search(name);
		
		Product e = new Product(Srchd.getName(), quantity, Srchd.getPrice(), Srchd.getPath());
		
		if(Srchd.getQuantity() == 0) {
			
			throw new InsufficientQtyException("Desired prioduct is out of stock !!! ");
			
		} else {
			
			customerCart.addMaal(e);
			Cartsize += 1;
		}

	}
	
	// Update functions by the given amount
	public void updateFunds(int amount) {
		this.funds += amount;
		System.out.println("Funds: " + this.funds);
	}
	

	// Checkout function
	public void checkout() throws NoSellException, InvalidProductException, InsufficientFundsException{
		
		if(this.funds != 0) {
			for(int i=0; i<this.Cartsize; i++) {
							
				Product temp = this.customerCart.getMaal(i);
				this.funds = D.Sale(temp, temp.getQuantity(), this.funds); 
				Cartsize -= 1;
				
			}
			
			customerCart = new Cart();
		} else {
			throw new InsufficientFundsException("No funds are remaining !!! ");
		}
	}

	@Override
	public String toString() {
		return "Customer cart size : " + this.Cartsize + " Customer funds remaining: " + this.funds;
	}

	// Utility function to be used inside the Test Suite
	public String allProduct() {
		String ans = "";
		
		for(int i=0; i<customerCart.sizer(); i++) {
			String temp = customerCart.getCart().get(i).getName();
			ans += temp;
		}
		
		return ans;
	}

}
