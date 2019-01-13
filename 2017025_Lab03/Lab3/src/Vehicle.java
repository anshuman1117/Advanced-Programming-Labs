
public class Vehicle {
	protected String nameOwner;
	protected String nameModel;
	protected int totalWheels;
	protected Insurance insurancepolicyType;
	protected double damage;
	
	// Constructor method 
	public Vehicle(String nameOwner, String nameModel, int totalWheels, boolean input) {

		this.nameOwner = nameOwner;
		this.nameModel = nameModel;
		this.totalWheels = totalWheels;
		this.insurancepolicyType = new Insurance(10,0,input);
	}
	
	// Default 10 percent settle method
	public void settleInsurance(Vehicle other, int damage1, int damage2) {
		// Calculating self damage
		 double factor = (this.insurancepolicyType.getOwnerDamage()) / 100;
		 this.damage = this.damage - (factor * this.damage);
		 
		 // Calculating other's damage
		 factor = this.insurancepolicyType.getOwnerDamage() / 100;
		 double damgeOther = other.getdamage() + (factor * other.getdamage()); 
		 other.setdamage(damgeOther);
	}
	
	// Setter and Getter methods
	public Insurance getPolicy() {
		return insurancepolicyType;
	}
	
	public double getdamage() {
		return this.damage;
	}
	
	public void setdamage(double x) {
		this.damage = x;
	}

	protected String getNameOwner() {
		return nameOwner;
	}

	protected void setNameOwner(String nameOwner) {
		this.nameOwner = nameOwner;
	}

	protected String getNameModel() {
		return nameModel;
	}

	protected void setNameModel(String nameModel) {
		this.nameModel = nameModel;
	}

	protected int getTotalWheels() {
		return totalWheels;
	}

	protected void setTotalWheels(int totalWheels) {
		this.totalWheels = totalWheels;
	}

	
	
}
