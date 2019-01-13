/*
 * REFERENCES: 
 * 
 * https://www.developer.com/java/data/working-with-serialization-in-java.html
 * 
 * https://www.geeksforgeeks.org/serialization-in-java/
 * 
 * https://www.tutorialspoint.com/java/java_serialization.htm
 * 
 */
		
/*
 * Anshuman Singh
 * 2017025
 * 
 */




import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.*;
import java.io.*;

public class mainClass {
	
	private static ArrayList<Customer> Custo = new ArrayList<Customer>();
	private static int IDSystem = 100;
	
	public static ArrayList<Customer> getCusto() {
		return Custo;
	}
	
	public static void programQueries() {
		System.out.println("What do you want to simulate? ");
		System.out.println();
		System.out.println("1. Administrator.");
		System.out.println("2. Customer.");
		System.out.println("3. Exit, Terminate the Application.");
		System.out.println();
		System.out.println("Input choice : ");
	}
	
	
	public static void adminQueries() {
		System.out.println("Which query you want to make? ");
		System.out.println("    a. Insert Product/Category");
		System.out.println("    b. Delete Product/Category ");
		System.out.println("    c. Search Product");
		System.out.println("    d. Modify Product");
		System.out.println("    e. Exit as Administrator");
	}
	
	public static void customerQueries() {
		System.out.println("Which query you want to make as a Customer? ");
		System.out.println("    a. Add funds ");
		System.out.println("    b. Add Product to cart ");
		System.out.println("    c. Checkout the cart");
		System.out.println("    d. Exit as Customer");
	}
	
	public static Customer checkCustomer(String UID) {
		
		boolean internalFlag = false;
		Customer returnValue = null;
		
		for(int i=0; i<Custo.size(); i++) {
			if(Custo.get(i).getName().equals(UID)) {
				returnValue = Custo.get(i);
				internalFlag = true;
			}
		}
	
		if(internalFlag == true){
			return returnValue;	
		} else {
			return null;
		}
		
	}
	
	// Serializable
	public	static	void serialize(dataBase D) throws	IOException	{
			
		ObjectOutputStream out	=	null;
			
		try {
			out = new ObjectOutputStream(new FileOutputStream("out.txt"));
			out.writeObject(D);
		} finally {
			out.close();
		}
			
	}
	
	// Deserializeable
	public	static	dataBase deserialize() throws 	IOException,	ClassNotFoundException{
		ObjectInputStream	in	=	null;
		try {
			in = new ObjectInputStream(new FileInputStream("out.txt"));
			dataBase D = (dataBase) in.readObject();
			return D;
		} finally {
			in.close();
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		dataBase D = null;
		
		try {
			D = deserialize();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			D = new dataBase();
		} catch (IOException e) {
			// Do nothing
			e.printStackTrace();
		}
		
		Admin A = new Admin(D);
		
		while(true) {
						
			programQueries();
			
			int choice = sc.nextInt();
			
			if(choice == 3) {
				
				D.Revenue();
				try {
					serialize(D);
				} catch (IOException e) {
					e.printStackTrace();
				}
				System.out.println("Program terminated successfully !!!");
				break;
				
			} else if(choice == 1) {
								
				while(true) {

					adminQueries();
					
					String input = sc.next();
					
					if(input.equals("a")) {
						System.out.println("Enter the location of the product : ");
						String inputLocation = sc.next();
						
						System.out.println("Enter the name of the product : ");
						String inputName = sc.next();
						
						System.out.println("Enter the quantity of the item :");
						int qty = sc.nextInt();
						
						System.out.println("Enter the price of the item: ");
						int price = sc.nextInt();
						
						try {
							A.insert(inputLocation, inputName, qty, price);
						} catch (ProductExistsException e) {
							System.out.println(e.getMessage());
						}
						
					} else if(input.equals("b")) {
						System.out.println("Enter the location of the product :");
						String inputLocation = sc.next();
						System.out.println("Enter the name of the product : (Enter NA, if no products to be deleted, only categories)");
						String inputName = sc.next();
						System.out.println(inputName);
						
						try {
							A.delete(inputLocation, inputName);
						} catch (InvalidPathException e) {
							System.out.println(e.getMessage());
						}
						
					} else if(input.equals("c")) {
						System.out.println("Enter the product name to search: ");
						
						String proname = sc.next();
						
						try {
							A.search(proname);
						} catch(InvalidProductException e) {
							System.out.println(e.getMessage());
						}
						
					} else if(input.equals("d")) {
						System.out.println("Enter the properties to be modified: ");
						System.out.println("Enter the name of the product: ");
						String name = sc.next();
						
						System.out.println("Enter the price to be modified :");
						int price = sc.nextInt();
						
						System.out.println("Enter the quantity to be modified: ");
						int qty = sc.nextInt();
						
						try {
							D.modify(name, qty, price);
						} catch (InvalidProductException e) {
							System.out.println(e.getMessage());
						}
								
					} else if(input.equals("e")) {
						
						System.out.println("Successfully exited Admin mode !!!");
						System.out.println();
						System.out.println();
						break;
					}
				}
			
		} else if(choice == 2) {
			
			Customer C;
			
			System.out.println("Enter your Name, customer :");
			String nameCustomer = sc.next();
			
			if(checkCustomer(nameCustomer) == null) {
				int UID = IDSystem + 1;
				C = new Customer(D, UID, nameCustomer);
				Custo.add(C);
				System.out.println("Welcome new customer, " + nameCustomer);
			} else {
				C = checkCustomer(nameCustomer);
				System.out.println("Welcome recurring customer, " + nameCustomer);
			}
			
			while(true) {
				
				customerQueries();
				
				String input = sc.next();
				
				if(input.equals("a")) {
					System.out.println("Enter the amount of funds you want to add: ");
					
					int amnt = sc.nextInt();
					
					C.updateFunds(amnt);
					
				} else if(input.equals("b")) {
					System.out.println("Enter the name of the product to add to cart :");
					String namePro = sc.next();
					
					System.out.println("Enter the quantity you want to buy :");
					int qty = sc.nextInt();	
					
					try {
						
						C.addProduct(namePro, qty);
						
					} catch (InvalidProductException e) {
						
						System.out.println(e.getMessage());
						
					} catch (InsufficientQtyException f) {
						
						System.out.println(f.getMessage());
					}
					
				} else if(input.equals("c")) {
					
					System.out.println("Checking out cart !!!");
					System.out.println();
					
					try {
						C.checkout();
					
					} catch(NoSellException e) {
						
						System.out.println(e.getMessage());
						
					} catch (InvalidProductException e) {
						
						System.out.println(e.getMessage());
						
					} catch (InsufficientFundsException h) {
						
						System.out.println(h.getMessage());
						
					} 
					System.out.println();
					System.out.println("Checking out process completed successfully !!!");
					
					
				} else if(input.equals("d")) {
					
					System.out.println();
					System.out.println("Details of the customer : ");
					System.out.println(C);
					System.out.println();
					
					System.out.println("Successfully exited as a customer !!!");
					System.out.println();
					System.out.println();
					
					
					
					break;
					
				}
				
			}
		}
		

	}

}
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
