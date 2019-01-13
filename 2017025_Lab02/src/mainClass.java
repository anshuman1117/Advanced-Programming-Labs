/*
 * Anshuman Singh
 * 2017025 
 * 
 */

import java.util.*;

public class mainClass {
	static ArrayList<Artist> A = new ArrayList<Artist>();
	static ArrayList<Customer> C = new ArrayList<Customer>();
	static Subscriptions[] subs = new Subscriptions[5];
	
	// Function to find the Artist whose song ID is given
	public static int findArtist(ArrayList<Artist> A, int SID) {
		int index = -1;
		
		for(int i=0; i<A.size(); i++) {
			if(A.get(i).findSong(SID) != -1) {
				index = i;
				break;
			}
		}
		
		
		return index;
	}
	
	// Main function
	public static void main(String[] args) {
		subs[1] = new Subscriptions(0, 1, 0);
		subs[2] = new Subscriptions(100, 5, 2);
		subs[3] = new Subscriptions(500, 10, 5);
		subs[4] = new Subscriptions(1000, Integer.MAX_VALUE, Integer.MAX_VALUE);
		
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		
		int AID = 1000;
		int CID = 100;
		int SID = 0;
		
		for(int d=0; d<n; d++) {
			int q = in.nextInt();
			
			
			
			// Query 1
			if(q == 1) {
				
				String Type = in.next();
				String name = in.next();
				
				if(Type.equals("A")){
					AID += 1;
					Artist temp = new Artist(AID, name);
					A.add(temp);
					System.out.println(name + " "  +AID);
				} else if(Type.equals("C")){
					CID += 1;
					C.add(new Customer(CID, name));
					System.out.println(name + " " + CID);
				}
				
				
				
			// Query 2	
			} else if(q == 2) {
				
				int ID = in.nextInt();
				int subsc = in.nextInt();
				
				// Finding the required customer
				int index = -1;
				for(int i=0; i<C.size(); i++) {
					if(C.get(i).getID() == ID) {
						index = i;
					}
				}
				
				if(index != -1) {
					C.get(index).setSubs(subsc);
					int fees = C.get(index).getFees() + subs[subsc].getPrice();
					//System.out.println(fees);
					C.get(index).setFees(fees);
				} else {
					System.out.println("Enter valid customer ID !!!");
				}
				
				
				
			// Query 3	
			} else if(q == 3) {
				int ID = in.nextInt();
				// Find the required Artist
				int index = -1;
				for(int i=0; i<A.size(); i++) {
					if(A.get(i).getID() == ID) {
						index = i;
					}
				}
				
				if(index == -1)
					System.out.println("Enter correct id !!!");
				else {
					int n1 = in.nextInt();
					for(int i=0; i<n1; i++) {
						String songName = in.next();
						SID = SID + 1;
						Songs geet = new Songs(songName, A.get(index).getID(), SID);
						A.get(index).addSong(geet);
						
						
						System.out.print(songName + " " + SID + " ");
					
					}
					
					System.out.println();
				}
				
				
			// Query 4	
			} else if(q == 4) {
				int ID = in.nextInt();
				
				// Find the required Artist
				int index = -1;
				for(int i=0; i<A.size(); i++) {
					if(A.get(i).getID() == ID) {
						index = i;
					}
				}
				
				if(index == -1)
					System.out.println("Enter correct id !!!");
				else {
					int royalty = A.get(index).resetRoyalty();
					System.out.println(royalty);
				}
				
			
			// Query 5	
			} else if(q == 5) {
				int ID = in.nextInt();
				
				// Finding if the user is an Artist or a Customer
				// Find the required artist
				int indexA = -1;
				for(int i=0; i<A.size(); i++) {
					if(A.get(i).getID() == ID) {
						indexA = i;
					}
				}
				
				// Find the required customer
				int indexC = -1;
				for(int i=0; i<C.size(); i++) {
					if(C.get(i).getID() == ID) {
						indexC = i;
					}
				}
				
				if(indexA == -1 && indexC == -1) {
					System.out.println("Enter correct IDs !!!");
				}else {
					User current;
					if(indexA == -1 && indexC != -1) {
						current = C.get(indexC);
					} else {
						current = A.get(indexA);
					}
					
					int play = 0, dwnld = 0;
					
					
					// Entering song sequence
					int n1 = in.nextInt();
					String[] S = new String[n1];
					for(int i=0; i<n1; i++) {
						
						int sid = in.nextInt();
						String type = in.next();
						
						
						for(int i1=0; i1<A.size(); i1++) {
							if(A.get(i1).findSongName(sid) != "") {
								S[i] = A.get(i1).findSongName(sid);
							}
						}
						
						
						boolean playy = false, dwnldd = false;
						
						int tempplay = play;
						int downs = dwnld;
						if(type.equals("P")) {
							play += 1;
							playy = true;
						} else if(type.equals("D")) {
							dwnld += 1;
							dwnldd = true;
						}
						
						//Finding the Artist whose song it is
						int index = findArtist(A, sid);
						
						if(index == -1) {
							System.out.println("No such song found!!!");
							S[i] = "";
						} else if(tempplay < subs[current.subsxIndex()].getSongs() && downs < subs[current.subsxIndex()].getDownloads()){
							//Artist jiskaSongHai = A.get(index);
							current.stream(A, index, playy, dwnldd, subs);
							
						}
					
					}
					
					int A[] = new int[n1];
					for(int i=0; i<n1; i++) {
						A[i] = in.nextInt();
					}
					
					String F[] = new String[n1];
					for(int i=0; i<n1; i++) {
						F[i] = S[A[i] - 1];
					}
					
					for(int i=0; i<n1; i++) {
						System.out.print(F[i] + " ");
					}
					System.out.println();
								
			}	
				
				
				
				
			// Query 6
			} else if(q == 6) {
				int ID = in.nextInt();
				
				// Find the required customer
				int index = -1;
				for(int i=0; i<C.size(); i++) {
					if(C.get(i).getID() == ID) {
						index = i;
					}
				}
				
				if(index == -1)
					System.out.println("Enter correct id !!!");
				else {
					int subsIdx = C.get(index).getFees();
					C.get(index).setFees(0);
					System.out.println(subsIdx);
				}
			
				
			// Query 7
			} else if(q == 7) {
				
				int ID = in.nextInt();
				//Find function
				// Find the required artist
				int indexA = -1;
				for(int i=0; i<A.size(); i++) {
					if(A.get(i).getID() == ID) {
						indexA = i;
					}
				}
				
				// Find the required customer
				int indexC = -1;
				for(int i=0; i<C.size(); i++) {
					if(C.get(i).getID() == ID) {
						indexC = i;
					}
				}
				
				//Displaying details
				if(indexA == -1 && indexC == -1) {
					System.out.println("Enter correct IDs !!!");
				}else {
					User current;
					if(indexA == -1 && indexC != -1) {
						current = C.get(indexC);
					} else {
						current = A.get(indexA);
					}
					current.details();
				}
				
			}
		}
		
		in.close();

	}
}












