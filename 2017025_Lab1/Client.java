/*
 * Name:	Anshuman Singh
 * Roll No:	2017025
 * Branch:	CSE
 * 	
 */


public class Client {
	private int id;
	private final int priority;
	String name;
	String caseType;
	
	// Constructor for the Client class
	public Client(int id, int priority, String name, String caseType) {
		
		this.id = id;
		this.priority = priority;
		this.name = name;
		this.caseType = caseType;
	}

	// getter function for the final type id
	public int getId() {
		return id;
	}
	
	// getter function for the final type priority
	public int getPriority() {
		return priority;
	}

	// Overridden toString function 
	@Override
	public String toString() {
		
		return "Client [id=" + id + ", priority=" + priority + ", name=" + name + ", caseType=" + caseType + "]";
	
	}
	
	// Function to display details in the format specified in the second query
	public String twoDisplay() {
		
		return "Name of the client: " + name + "\n" + " Category of legal dispute: " + caseType + "\n" + " Unique id: " + id;
	
	}
	
	
}
