import java.util.*;


public class mainClass {

	static prize[][] Board = new prize[10][10];
	static prize[] Preset = new prize[9];
	static Random rand = new Random();
	static Random rand1 = new Random();
	static Random rand2 = new Random();

	
	// Function to create random prize ArrayList to guess
	public static ArrayList<prize> randomize(prize[] Preset){
		
		ArrayList<prize> list = new ArrayList<prize>();
        
		for (int i=0; i<9; i++) {
            list.add(Preset[i]);
        }
        Collections.shuffle(list);
        
		ArrayList<prize> Final = new ArrayList<prize>();
 
        for(int i=0; i<5; i++) {
        	Final.add(list.get(i));
        }
        
        return Final;
		
	}
	
	// Function to fill the 50% of the board with random prizes
	public static void allocatePrizes(prize[][] Board, prize[] Preset) {
	
		int count = 0;
	
		while(count < 50) {
			
			int x =  rand.nextInt(10);
			int y = rand1.nextInt(10);
			
			if(Board[x][y] == null) {
				int index = rand2.nextInt(9);
				Board[x][y] = Preset[index];
				count += 1;
			} 
		}
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// Initializing the preset array of all prizes  
		Preset[0] = new softToy("Dog", 50);
		Preset[1] = new softToy("Cat", 40);
		Preset[2] = new softToy("Rabbit", 20);
		
		Preset[3] = new candyBars("Kit-Kat", 10);
		Preset[4] = new candyBars("Sinckers", 5);
		Preset[5] = new candyBars("Five-Star", 7);

		Preset[6] = new Stationery("Pen", 2);
		Preset[7] = new Stationery("Pencil", 1);
		Preset[8] = new Stationery("Eraser", 5);
		
		// Allocating and setting up the board
		allocatePrizes(Board, Preset);
		
		int t = sc.nextInt();
		Player P[] = new Player[t];
		
		
		for(int d=0; d<t; d++) {
			String name = sc.next();
			P[d] = new Player(name, randomize(Preset));
		}
		
		for(int i=0; i<t; i++) {
			System.out.println("Simulation begins for: " + P[i].getNamePlayer());
			
			for(int j=0; j<10; j++) {
				System.out.println("Enter the coordinates :");
				int x = sc.nextInt();
				int y = sc.nextInt();
				
				if(Board[x][y] == null) {
					
					System.out.println("Sorry, no prize here !!!");
					System.out.println(P[i].getPoints() + " points");
					
				} else {
					System.out.println("Guess the prize :");
					int guess = sc.nextInt();
					prize expected = P[i].getGuess(guess);
					//prize expected = Preset[guess];
					
					if(Board[x][y].equals(expected)) {
						
						// Clone part
						P[i].addPrize(Board[x][y].clone());
						
						// Points update
						double value = Board[x][y].updateValue(P[i].getPoints());
						P[i].setPoints(value);
						
						// Printing output part
						System.out.println("You won " + Board[x][y].getName());
						System.out.println(P[i].getPoints() + " points");
					
					} else if(!Board[x][y].equals(expected)) {
						double pointsUpdate = P[i].getPoints() - Math.abs(expected.getWeight() - Board[x][y].getWeight());
						P[i].setPoints(pointsUpdate);
						
						//Printing part
						System.out.println("Sorry, you guessed wrong, it was " + Board[x][y].getName());
						System.out.println(P[i].getPoints() + " points");
					}
				}
			}
			// Printing Player's summary
			System.out.println("Summary of Player " + i+1);
			System.out.println(P[i]); 
			
		}

		sc.close();
	}

}



























