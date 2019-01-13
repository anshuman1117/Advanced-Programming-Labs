/*
 * Name:	Anshuman Singh
 * Roll No:	2017025
 * Branch:	CSE
 * 	
 */


import java.util.*;


public class Lawyer {
	private int id;
	String name;
	String specialization;
	int caseNumber;
	Client currentCase;
	ArrayList<Client> cases;
	
	// Constructor
	public Lawyer(int id, String name, String specialization) {
		
		this.id = id;
		this.name = name;
		this.specialization = specialization;
		cases = new ArrayList<Client>();
		caseNumber = 0;
		currentCase = null;
	
	}
	
	// getter for the id, so that it cannot be changed anywhere
	public int getId() {
		
		return id;
	
	}
	
	// Function to display details in the format of the fifth query
	public String fiveDisplay() {
		
		return "Name of the lawyer: " + name + " | Specialization: " + specialization + " | Number of pending cases: " + caseNumber;
	
	}
	
	// Function to display details in the format of the first query
	public String oneDisplay() {
		
		return "Name of the assigned lawyer: " + name + "\n" + "Unique id of lawyer assigned: " + id;
	
	}
	
	// Function to add an instance of a client to the cases arraylist
	public void addClient(Client thiscase) {
		
		cases.add(thiscase);
		caseNumber += 1;
		
	}
	
	// Function to display all the cases pending for the lawyer
	public void showCases() {
		
		System.out.println("The pending cases are: ");
		for(int i=0; i<cases.size(); i++) {
			System.out.println(cases.get(i).twoDisplay());
		}
		
	}
	
}
