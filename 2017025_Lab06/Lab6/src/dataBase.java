import java.util.*;
import java.io.*;

public class dataBase implements Serializable{
	
	

	private static final long serialVersionUID = 8106834011147838860L;
	
	private ArrayList<Category> topC;
	private int revenue;
	
	public dataBase() {
		topC = new ArrayList<Category>();
		revenue = 0;
	}
	
	// Insert function
	public void insert(Product P, ArrayList<String> Path) throws ProductExistsException {
	
		boolean flag = false;
		String catName = Path.get(0);
		
		for(int i=0; i<topC.size(); i++) {
			if(topC.get(i).getName().equals(catName)) {

				topC.get(i).addintoSub(P, Path);
				flag = true;
			}
		}
		
		if(flag == false) {
			topC.add(new Category(catName));
			
			for(int i=0; i<topC.size(); i++) {
				if(topC.get(i).getName().equals(catName)) {

					topC.get(i).addintoSub(P, Path);
					break;
				}
			}
		}
		
		
		
	}
	
	// Deletion function
	public void delete(ArrayList<String> Path) throws InvalidPathException{
		boolean flag = false;
		String subName = Path.get(0);
		
		if(Path.size() < 2) {
			for(int i=0; i<topC.size(); i++) {
				if(topC.get(i).getName().equals(subName)) {
					topC.remove(i);
					flag = true;
				}
			}
		} else if(Path.size() == 2) {
			for(int i=0; i<topC.size(); i++) {
				if(topC.get(i).getName().equals(subName)) {
					flag = topC.get(i).deletefromSub(false, Path);
				}
			}
		} else if(Path.size() > 2) {
			for(int i=0; i<topC.size(); i++) {
				if(topC.get(i).getName().equals(subName)) {
					flag = topC.get(i).deletefromSub(true, Path);
				}
			}
		}
		
		if(flag == false) {
			throw new InvalidPathException("The path to the product was not found !!! ");
		}
	}
	
	
	// Search function
	public Product search(String Name) throws InvalidProductException{
		Product P = null;
		for(int i=0; i<topC.size(); i++) {
			P = topC.get(i).searchInside(Name);
		}
		
		if(P == null) {
			throw new InvalidProductException("Product not found !!!");
		} else {
			return P;
		}
	}
	
	// Modify function
	public void modify(String name, int quantity, int price) throws InvalidProductException{

		Product P5 = this.search(name);
		P5.setPrice(price);
		P5.setQuantity(quantity);

	}
	
	// Sale Function
	public int Sale(Product P, int quantity, int funds) throws NoSellException, InvalidProductException{
		String name = P.getName();
		
		Product P1 = this.search(name);
		
		if(P1.getQuantity() < quantity) {
			throw new NoSellException("Quantity is less than ordered !!!");
		} else {
			int updated = P1.getQuantity() - quantity;
			P1.setQuantity(updated);
		}
		
		if(P1.getPrice()*quantity > funds) {
			throw new NoSellException("Funds remaining are lesser than the Product Ordered !!!");
		} else {
			int update = funds - quantity * P1.getPrice();
			this.revenue += P1.getPrice()*quantity;
			funds = update;
		}
		
		return funds;
	}
	
	
	
	// Revenue function
	public void Revenue() {
		
		System.out.println("Total Revenue generated:  Rs " + this.revenue);
	
	}
	
	
	
	
}





























