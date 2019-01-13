import java.util.*;

public class mainClass {
	
	private static int total = 1000;
	private static Random rand = new Random();
	
	// Internal print function
	public static void Print(Vehicle V1, Vehicle V2, int damage1, int damage2) {
		
		// Damages
		System.out.println("Damages awarded to Vehicle 1 :" + damage1);
		System.out.println("Damages awarded to Vehicle 2 :" + damage2);
		
		// Settlement details
		System.out.println("Settlement details :");
		System.out.println("	Vehicle1 damage after settlement:  " + V1.getdamage());
		System.out.println("	Vehicle2 damage after settlement:  " + V2.getdamage());
		
		
	}
	
	// The collision function
	public static void Collision(Vehicle V1, Vehicle V2) {
		
			// Assigning damage to the vehicles
			int damage = rand.nextInt(500) + 1;
			int damage2 = total - damage;

			// Printing the first line about the car
			System.out.println("Vehicle 1 : Model - " + V1.getNameModel() + " Owner - " + V1.getNameOwner() + " ,collided with Vehicle 2: Model - " + V2.getNameModel() + " Owner - " + V2.getNameOwner());
		
			// Checking if car has valid policy
			if(V1.getPolicy().getExpiry())
				System.out.println("Policy is expired in this car!!");
			else {
				// Calling the settlement method
				V1.settleInsurance(V2, damage, damage2);
				
				// Printing the details after settlement
				Print(V1, V2, damage, damage2);
			}
			
			// Generating blank lines for clarity in the output
			System.out.println();
			System.out.println();
			
	}
	
	public static void main(String[] A) {
		
		// Initialization of the Vehicles
		Vehicle V[] = new Vehicle[5];
		
		// Generating the initial table
		V[0] = new Engine("A", "C1", 4, false);
		System.out.println(V[0]);
		
		V[1] = new Engine("B", "C2", 4, true);
		System.out.println(V[1]);
		
		V[2] = new Engine("C", "C3", 2, false);
		System.out.println(V[2]);
		
		V[3] = new Engine("D", "C4", 2, true);
		System.out.println(V[3]);
		
		V[4] = new NonEngine("E", "C5", 4);
		System.out.println(V[4]);
		
		// Simulation begins
		System.out.println();
		System.out.println();
		
		System.out.println("Simulation begins :");
		
		System.out.println();
		System.out.println();

		
		// Simulation loop
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				if(i != j) {
					Collision(V[i], V[j]);
				}
			}
		}
		
		s
		
	}
}
