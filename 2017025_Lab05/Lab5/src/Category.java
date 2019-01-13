import java.util.*;


public class Category {

	private String name;
	private ArrayList<Subcat> Sub;
	
	public Category(String name) {
		this.name = name;
		Sub = new ArrayList<Subcat>(1);
		Sub.add(new Subcat("null", name));
	}
	
	public String getName() {
		return this.name;
	}
	
	// Addition function
	public void addintoSub(Product P, ArrayList<String> Path) {
		
		if(Path.size() == 2) {
			Sub.get(0).addProduct(P);
			this.name = Path.get(0);
		} else {
			
			boolean flag = false;
			String reqSub = Path.get(1);
			for(int i=1; i<Sub.size(); i++) {
				if(Sub.get(i).getName().equals(reqSub)) {
					P.updatePath(name + " > " + Sub.get(i).getName());
					Sub.get(i).addProduct(P);
					flag = true;
				}
			}
			
			if(flag == false) {
				Subcat newSub = new Subcat(reqSub , name + " > " + reqSub);
				Sub.add(newSub);	
			}
		}
	}
	
	
	// Search Function
	public Product searchInside(String name) {
		boolean flag = false;
		Product P = null;
		
		for(int i=0; i<Sub.size(); i++) {
			P = Sub.get(i).searchPro(name);
			if(P != null) {
				flag = true;
				break;
			}
				
		}
		
		return P;
	}
	
	// Delete function
	public boolean deletefromSub(boolean flag, ArrayList<String> Path) {
		
		boolean internal = false;
		
		if(flag == false) {
			String reqName = Path.get(1);
			for(int i=0; i<Sub.size(); i++) {
				if(Sub.get(i).getName().equals(reqName)) {
					Sub.remove(i);
					internal = true;
				}
			}
			
		} else if(flag == true) {
			
			String reqName = Path.get(1);
			String proName = Path.get(2);
			
			for(int i=0; i<Sub.size(); i++) {
				if(Sub.get(i).getName().equals(reqName)) {
					internal = Sub.get(i).removeProduct(Sub.get(i).getPath(), proName);;
				}
			}
			
		}
		
		return internal;
	}
	
		

	
	
	
}















