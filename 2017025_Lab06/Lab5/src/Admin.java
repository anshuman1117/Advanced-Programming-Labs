import java.io.Serializable;
import java.util.*;


public class Admin implements Serializable{

	
	private static final long serialVersionUID = 6618890069612345586L;
	
	private dataBase D;
	
	public Admin(dataBase D) {
		this.D = D;
	}
	
	// Insert function for the database
	public void insert(String location, String name, int qty, int price) throws ProductExistsException {
		String[] loc = location.split(">", 0);

		ArrayList<String> Path = new ArrayList<String>();
		
		for(int i=0; i<loc.length; i++) {
			Path.add(loc[i]);
		}
		
		Path.add(name);
		
		
		Product newEntry = new Product(name, qty, price);

		newEntry.setPath(location + ">" + name);
		
		D.insert(newEntry, Path);
		
	}

	// Delete function for database
	public void delete(String location, String name) throws InvalidPathException{
		String[] loc = location.split(">", 0);
		
		ArrayList<String> Path = new ArrayList<String>();
		
		for(int i=0; i<loc.length; i++) {
			Path.add(loc[i]);
		}
		
		if(name.equals("NA") == false) {
			Path.add(name);
		}
		
		D.delete(Path);
		
	}
	
	// Search function
	public void search(String name) throws InvalidProductException{
		Product P = D.search(name);
		
		System.out.println("Path of the product: ");
		System.out.println(P.getPath());
		
		System.out.println("Details of the product: ");
		System.out.println(P);
		
	}
	
	// Modify function
	public void modify(String name, int qty, int price) throws InvalidProductException{
		
		D.modify(name, qty, price);
		
		
	}
}











