import java.util.*;

public class Cart {
	
	private ArrayList<Product> C;
	
	public Cart() {
		C = new ArrayList<Product>();
	}
	
	public void addProduct(Product pro) {
		C.add(pro);
	}
	
	public Product getProduct(int index) {
		return C.get(index);
	}
	
	public void remove(int index) {
		C.remove(index);
	}

	public ArrayList<Product> getCart() {
		return C;
	}

	public void setC(ArrayList<Product> c) {
		C = c;
	}
}
