import java.util.*;
public class Customer {
	
	private Cart customerCart;
	private int funds;
	private int Cartsize;
	private dataBase D;
	
	public Customer(dataBase D) {
		customerCart = new Cart();
		Cartsize = 0;
		funds = 0;
		this.D = D;
	}
	
	// Adding a product to the cart
	public void addProduct(String name, int quantity) throws InvalidProductException {
		Product Srchd = D.search(name);
		
		Product e = new Product(Srchd.getName(), quantity, Srchd.getPrice(), Srchd.getPath());
		
		customerCart.addProduct(e);
		Cartsize += 1;
	}
	
	public void updateFunds(int amount) {
		funds += amount;
	}
	
	
	
	// Checkout function
	public void checkout() throws NoSellException, InvalidProductException{
		for(int i=0; i<customerCart.getCart().size(); i++) {
			Product temp = this.customerCart.getProduct(i);
			funds = D.Sale(temp, temp.getQuantity(), this.funds); 
			customerCart.remove(i);
			Cartsize -= 1;
		}
	}

	@Override
	public String toString() {
		return "Customer cart size : " + Cartsize + " /n Customer funds remaining: " + funds;
	}

	
}
