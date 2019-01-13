import java.util.ArrayList;

public class Customer implements User{
	private int uid;
	private String name;
	private int subsIndex;
	private int fees;
	private boolean flag = false;
	
	
	// Constructor
	public Customer(int uid, String name) {
		
		this.uid = uid;
		this.name = name;
		fees = 0;
	}
	
	
	// Interface methods
	@Override
	public void details() {
		System.out.println(name + " " + uid + " " + subsIndex);
	}
	
	@Override 
	public void stream(ArrayList<Artist> A, int index, boolean play, boolean dwnld, Subscriptions[] S) {
		
		// Updating royalty values
		if(play == true) {
			A.get(index).updateRoyalty(5);
		} else if(dwnld == true) {
			A.get(index).updateRoyalty(20);
		}
		
		// Updating fee value
		if(this.flag == false) {
			this.setFees(S[this.subsIndex].getPrice());
			this.flag = true;
		}
		
	
		
		
	}
	
	@Override
	public int subsxIndex() {
		return this.getSubsIndex();
	}
	
	
	//Getter and Setter methods
	public void setSubs(int index) {
		this.subsIndex = index;
	}	
	
	public int getSubsIndex() {
		return subsIndex;
	}
	
	public int getID() {
		return uid;
	}
	
	public void setID(int uid) {
		this.uid = uid;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public int getFees() {
		return fees;
	}

	public void setFees(int fees) {
		this.fees = fees;
	}

	
}
