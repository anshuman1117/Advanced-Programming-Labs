import java.io.Serializable;
import java.util.*;

public class Cart implements Serializable{
	
	
	private static final long serialVersionUID = -655809800111175966L;
	
	private ArrayList<Product> C;
	
	// Constructor 
	public Cart() {
		C = new ArrayList<Product>();
	}
	
	// Getters and Setters Functions
	public void addMaal(Product pro) {
		C.add(pro);
	}
	
	public int sizer() {
		return C.size();
	}
	
	public Product getMaal(int index) {
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
