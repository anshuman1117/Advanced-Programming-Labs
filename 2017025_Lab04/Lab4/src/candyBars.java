
public class candyBars extends prize implements Cloneable {

	// Constructor
	public candyBars(String name, int weight) {
		super(name, weight);

	}
	
	// Update value function
	@Override
	public double updateValue(double points) {
		double value = points + 20;
		return value;
	}
	
	// Clone method
	@Override
	public candyBars clone() {
		 candyBars p = (candyBars) super.clone();
		 return p;
	} 
	
	// Equals function
	@Override		
	public	boolean	equals(Object	o1)	{	
 	if(o1	!=	null	&&	getClass()	==	o1.getClass())	{	
 		candyBars	o	=	(candyBars)	o1;	//type	casting	
 		return	(name == o.getName()	&&	weight == o.getWeight());	
	}else {	
 		return	false;	
 		}	
 	}	
	
	

}
