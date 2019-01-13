/*
 * Name:	Anshuman Singh
 * Roll No:	2017025
 * Branch:	CSE
 * 	
 */
		

import java.util.*;

public class Main {
	static Lawyer[] L;
	
	// Function to register a client to a lawyer
	public static Lawyer[] Register(Lawyer[] L, Client C) {
		int max = Integer.MAX_VALUE; int index = -1;
		for(int i=0; i<L.length; i++) {
			if ((L[i].specialization).equals(C.caseType)) {
				if(max > L[i].caseNumber) {
					max = L[i].caseNumber;
					index = i;
				}
			}
		}
		
		// Checking for invalid input
		if(index == -1)
			System.out.println("Wrong case type entered!");
		
		// Adding the new client to the array
		if(index != -1) {
			L[index].addClient(C);
			Collections.sort((L[index].cases), new Comparator<Client>() {
			    @Override
			    public int compare(Client o1, Client o2) {
			    	return o1.getPriority() - o2.getPriority();
			    }
			});
			
			System.out.println(L[index].oneDisplay());
		}
		return L;
	}
	
	// Function to display the current client and then remove him
	public static void Remove(Lawyer L[], int id) {
		int index = -1;
		for(int i=0; i<L.length; i++) {
			if((L[i].getId()) == id) {
				index = i;
			}
		}
		
		if(index == -1)
			System.out.println("Enter correct lawyer id! ");
		else {
			if(L[index].cases.size() != 0) {
				L[index].currentCase = L[index].cases.get(0); 
				System.out.println(L[index].cases.get(0).twoDisplay());
				L[index].cases.remove(0);
				L[index].caseNumber -= 1;
			} else {
				L[index].currentCase = null;
				System.out.println("No cases to show !!!");
			}
		}
	}
	
	// Function to display the current client being handled
	public static void Current(Lawyer L[], int id) {
		int index = -1;
		for(int i=0; i<L.length; i++) {
			if((L[i].getId()) == id) {
				index = i;
			}
		}
		
		if(index == -1)
			System.out.println("Enter correct lawyer id! ");
		else {	
			if(L[index].currentCase != null)
				System.out.println(L[index].currentCase.twoDisplay());
			else 
				System.out.println("No current cases !!!");
		}
	}
	
	// Function to display all the pending cases of a lawyer
	public static void Pending(Lawyer L[], int id) {
		int index = -1;
		for(int i=0; i<L.length; i++) {
			if((L[i].getId()) == id) {
				index = i;
			}
		}
		
		if(index == -1)
			System.out.println("Enter correct lawyer id! ");
		else {
			if(L[index].cases.size() != 0)
				L[index].showCases();
			else 
				System.out.println("No Pending cases !!!");
		}
	}
	
	// Function to remove the client by id
	public static void removeClient(Lawyer[] L, int cid) {
		
		boolean flag = false;
		for(int i=0; i<L.length; i++) {
			
			if(L[i].currentCase != null && L[i].currentCase.getId() == cid) {
				flag = true;
				L[i].currentCase = null;
			}
			
			for(int j=0; j<L[i].cases.size(); j++) {
				if(L[i].cases.get(j).getId() == cid) {
					L[i].cases.remove(j);
					L[i].caseNumber -= 1;
					flag = true;
				} 
			}
		}
		
		if(flag == false)
			System.out.println("Enter the correct client id please  !!!");
		
	}

	public static void main(String[] B) {
		Scanner in = new Scanner(System.in);
		
		// Initial values for lawyerID and clientID
		int lawyerID = 1000;
		int clientID = 100;
		
		
		// Lawyer entry loop
		int n = in.nextInt();
		L = new Lawyer[n];
		
		for (int i=0; i<n; i++) {
			
			String name = in.next();
			String specz = in.next();
			
			if(specz.equalsIgnoreCase("housing") || specz.equalsIgnoreCase("finance") || specz.equalsIgnoreCase("defamation") || specz.equalsIgnoreCase("family")) {

				int id = lawyerID + 1;
				lawyerID += 1;
				
				Lawyer temp = new Lawyer(id, name, specz);
				L[i] = temp;
				
			} else {
				
				System.out.println("Enter correct specialization !!!");
				
			}
		}
		
		// Query loop
		int q = in.nextInt();
		for(int i=0; i<q; i++) {
			int choice = in.nextInt();
			
			if (choice == 0){
				
				String name = in.next();
				String specz = in.next();
				
				int id = lawyerID + 1;
				lawyerID += 1;
				
				if(specz.equalsIgnoreCase("housing") || specz.equalsIgnoreCase("finance") || specz.equalsIgnoreCase("defamation") || specz.equalsIgnoreCase("family")) {
					Lawyer temp = new Lawyer(id, name, specz);
					
					// Resizing the array
					n += 1;
					L = Arrays.copyOf(L, n);
					L[n - 1] = temp;
					
				} else {
					
					System.out.println("Enter correct specialization !!!");
				
				}
		
			} else if(choice == 1) {
				
				String name = in.next();
				
				String category = in.next();
				int priority = in.nextInt();
				
				int ID = clientID + 1;
				clientID += 1;
				
				Client thisclient = new Client(ID, priority, name, category);
				
				if(priority > 5 && priority < 1)
					System.out.println("Enter correct priorities in the range [1,5] !!!");
				else
					L = Register(L,thisclient);
					
			} else if (choice == 2) {
				
				int lawyerId = in.nextInt();
				Remove(L,lawyerId);
			
			}else if (choice == 3) {
			
				int lawyerid = in.nextInt();
				Current(L,lawyerid);
			
			} else if(choice == 4) {
				
				int lawyerid = in.nextInt();
				Pending(L,lawyerid);
		
			} else if(choice == 5) {
				
				System.out.println("The details of all lawyers are: ");
				for(int j=0; j<L.length; j++) {
					System.out.println(L[j].fiveDisplay());
				}
				
				if(L.length == 0)
					System.out.println("No lawyers in this firm!!! Strange ?");
				
			} else if(choice == 6) {
				
				int clientId = in.nextInt();
				removeClient(L,clientId);
			
			}
				
		}

	}
	
}

