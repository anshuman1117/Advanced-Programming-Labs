
public class Insurance {
	private double ownerDamage;
	private double oncomingDamage;
	private boolean isExpired;
	private String policyClass;
	
	// Constructor Method
	public Insurance(double ownerdamage, double oncomingdamage, boolean isExpired) {
		this.ownerDamage = ownerdamage;
		this.oncomingDamage = oncomingdamage;
		this.isExpired = isExpired;
		this.policyClass = "Default";
	}

	// Getter and Setter Methods
	public void setClass(String input) {
		policyClass = input;
	}

	public double getOwnerDamage() {
		return ownerDamage;
	}

	public void setOwnerDamage(int ownerDamage) {
		this.ownerDamage = ownerDamage;
	}

	public double getOncomingDamage() {
		return oncomingDamage;
	}

	public void setOncomingDamage(int oncomingDamage) {
		this.oncomingDamage = oncomingDamage;
	}
	
	public void setExpiry(boolean input) {
		this.isExpired = input;
	}
	
	public boolean getExpiry() {
		return isExpired;
	}
	
}
