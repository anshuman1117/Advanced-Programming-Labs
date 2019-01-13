import java.io.Serializable;
import java.util.*;

public class Subcat implements Serializable{
	
	
	private static final long serialVersionUID = -5311219431309613731L;
	
	private ArrayList<Product> P;
	private String path;
	private String name;
	
	
	public Subcat(String name, String path) {
		this.name = name;
		this.path = path;
		P = new ArrayList<Product>();
	}
	
	// Add new product function
	public void addProduct(Product e) throws ProductExistsException{
		
		
		int flag = 0;

		for(int i=0; i<P.size(); i++) {
			if(P.get(i).getName().equals(e.getName())) {
				flag = 1;
			}
		}
		
		
		if(flag == 0) {
			P.add(e);
		}

		if(flag > 0){

			throw new ProductExistsException("Product already exists in this sub-category !!! ");
		}  	
		

	}
	
	// Remove function
	public boolean removeProduct(String name) {
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
	public Product searchPro(String nname) {
		Product ans = null;
		for(int i=0; i<P.size(); i++) {
			if(P.get(i).getName().equals(nname)) {
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
