import java.util.*;
public class mainClass {
	
	public static void programQueries() {
		System.out.println("What do you want to simulate? ");
		System.out.println("1. Administrator");
		System.out.println("2. Customer");
		System.out.println();
		System.out.println("To exit the program, press 3.");
		System.out.println();
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
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			dataBase D = new dataBase();
			
			programQueries();
			
			int choice = sc.nextInt();
			
			if(choice == 3) {
				
				D.Revenue();
				
				System.out.println("Program terminated successfully !!!");
				break;
			} else if(choice == 1) {
				
				while(true) {
					
					Admin A = new Admin(D);
					
					adminQueries();
					
					String input = sc.next();
					
					if(input.equals("a")) {
						System.out.println("Enter the location of the product : \r");
						String inputLocation = sc.next();
						System.out.println(inputLocation);
						
						System.out.println("Enter the name of the product : \r");
						String inputName = sc.next();
						
						System.out.println("Enter the quantity of the item : \r");
						int qty = sc.nextInt();
						
						System.out.println("Enter the price of the item: \r");
						int price = sc.nextInt();
						
						A.insert(inputLocation, inputName,  qty, price);
						
					} else if(input.equals("b")) {
						System.out.println("Enter the location of the product :");
						String inputLocation = sc.next();
						System.out.println("Enter the name of the product : ");
						String inputName = sc.next();
						
						try {
							A.delete(inputLocation, inputName);
						} catch (InvalidPathException e) {
							System.out.println(e.getMessage());
						}
						
					} else if(input.equals("c")) {
						System.out.println("Enter the program name to search: ");
						
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
			while(true) {
				
				Customer C = new Customer(D);
				
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
					}
					
				} else if(input.equals("c")) {
					
					System.out.println("Checking out cart !!!");
					
					try {
						C.checkout();
					
					} catch(NoSellException e) {
						
						System.out.println(e.getMessage());
						
					} catch (InvalidProductException e) {
						
						System.out.println(e.getMessage());
						
					}
					
					System.out.println("Checked out successfully !!!");
					
					
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
