
public class NonEngine extends Vehicle {
	
	// Constructor
	public NonEngine(String nameOwner, String nameModel, int totalWheels) {
		super(nameOwner, nameModel, totalWheels, false);

		this.insurancepolicyType.setOwnerDamage(0);
		this.insurancepolicyType.setOncomingDamage(0);
		
	}
	
	// Required getter and setter functions
	public Insurance getPolicy() {
		return this.insurancepolicyType;
	}
	
	// Overridden settleInsurance method
	@Override
	public void settleInsurance(Vehicle other, int damage1, int damage2) {
	
		// Calculating self damage
		 double factor = (this.insurancepolicyType.getOwnerDamage()) / 100;
		 this.damage = damage1 - (factor * damage1);
		 
		 // Calculating other's damage
		 factor = this.insurancepolicyType.getOwnerDamage() / 100;
		 double damgeOther = damage2 - (factor * damage2); 
		 other.setdamage(damgeOther);
		
	}
	
	// Overriding the toString function to print in the required format
	@Override
	public String toString() {
		return "Model Name: " + this.getNameModel() + " , Owner Name : " + this.getNameOwner() + " , Type : " + this.getTotalWheels() + " , Type of Insurance: " + this.insurancepolicyType.getClass() + " , Policy status : NA, it is Non-Engine type!";
	}

}
