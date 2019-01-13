
public class Engine extends Vehicle {
	
	private final int basic;

	// Constructor
	public Engine(String nameOwner, String nameModel, int totalWheels, boolean input) {
		super(nameOwner, nameModel, totalWheels, input);
		
		basic = 10;
		
		if(super.getTotalWheels() == 4) {
			this.insurancepolicyType.setOwnerDamage(50);
			this.insurancepolicyType.setOncomingDamage(80);
			this.insurancepolicyType.setClass("Comprehensive Policy");
		} else if(super.getTotalWheels() == 2) {
			this.insurancepolicyType.setOwnerDamage(0);
			this.insurancepolicyType.setOncomingDamage(50);
			this.insurancepolicyType.setClass("Third-Party Policy");

		}
		
	}
	
	// Required Getter and Setter functions
	@Override
	public Insurance getPolicy() {
		return insurancepolicyType;
	}
	
	// Settle Insurance method
	@Override
	public void settleInsurance(Vehicle other, int damage1, int damage2) {
	
	 // Calculating self damage
	 double factor = (this.insurancepolicyType.getOwnerDamage() + basic) / 100;
	 this.damage = damage1 - (factor * damage1);

	 // Calculating other's damage
	 factor = this.insurancepolicyType.getOncomingDamage() / 100;
	 double damgeOther = damage2 - (factor * damage2); 
	 other.setdamage(damgeOther);
 
	}
	
	// Overriding the toString function to print in the required format
	@Override
	public String toString() {
		return "Model Name: " + this.getNameModel() + " , Owner Name : " + this.getNameOwner() + " , Type : " + this.getTotalWheels() + " , Type of Insurance: " + this.insurancepolicyType.getClass() + " , Policy status : Is the policy Expired? " + this.insurancepolicyType.getExpiry();
	}

}
