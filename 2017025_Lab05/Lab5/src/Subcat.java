import java.util.*;

public class Subcat {
	
	private ArrayList<Product> P;
	private String path;
	private String name;
	
	
	public Subcat(String name, String path) {
		this.name = name;
		this.path = path;
		P = new  ArrayList<Product>();
	}
	
	// Add new product function
	public void addProduct(Product e) {
		P.add(e);	
	}
	
	// Remove function
	public boolean removeProduct(String path, String name) {
		boolean flag = false;
		for(int i=0; i<P.size(); i++) {
			if(P.get(i).getName().equals(name)) {
				P.remove(i);
				flag =true;
			}
		}
		return flag;
	}
	
	// Search function
	public Product searchPro(String name) {
		Product ans = null;
		for(int i=0; i<P.size(); i++) {
			if(P.get(i).getName() == name) {
				ans = P.get(i);
			}
		}	
		return ans;
	}

	public ArrayList<Product> getP() {
		return P;
	}

	public void setP(ArrayList<Product> p) {
		P = p;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
}
