import java.util.*;
public class Player{
	
	private final String namePlayer;
	private ArrayList<prize> Spec;
	private ArrayList<prize> Won;
	private double points;
	
	// Constructor
	public Player(String namePlayer, ArrayList<prize> spec) {
		this.namePlayer = namePlayer;
		this.Spec = spec;
		this.Won = new ArrayList<prize>();
		this.points = 0;
	}
	
	// Function to add elements to the ArrayList Won
	public void addPrize(prize P) {
		Won.add(P);
	}
	
	// Function to return a guessed prize
	public prize getGuess(int index) {
		return this.Spec.get(index);
	}
	
	// Function to update the value of the points
	public void updatePoints(int value) {
		points += value;
	}
	
	//Overriding toString function t print summaries
	@Override
	public String toString() {
		
		String s = "";
		for(int i=0; i<this.Won.size(); i++) {
			s += (Won.get(i).getName()) + " ";
		}
		
		return "You have won : " + s + " " + this.points;

	}
	
	// Getters and Setter functions
	public ArrayList<prize> getSpec() {
		return Spec;
	}


	public void setSpec(ArrayList<prize> spec) {
		Spec = spec;
	}


	public ArrayList<prize> getWon() {
		return Won;
	}


	public void setWon(ArrayList<prize> won) {
		Won = won;
	}


	public double getPoints() {
		return points;
	}


	public void setPoints(double points) {
		this.points = points;
	}


	public String getNamePlayer() {
		return namePlayer;
	}
	
	
	
}
