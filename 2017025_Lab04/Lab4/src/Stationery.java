
public class Stationery extends prize implements Cloneable {
	
	// Constructor
	public Stationery(String name, int weight) {
		super(name, weight);

		
	}
	
	// Update value function
	@Override
	public double updateValue(double points) {
		double value = ((110/100)*points) + 5;
		return value;
	}
	
	// Clone method
	@Override
	public Stationery clone() {
		 Stationery p = (Stationery) super.clone();
		 return p;
	} 

	// Equals function
	@Override		
	public	boolean	equals(Object	o1)	{	
	 if(o1	!=	null	&&	getClass()	==	o1.getClass())	{	
	 	Stationery	o	=	(Stationery)	o1;	//type	casting	
	 	return	(name == o.getName()	&&	weight == o.getWeight());	
	} else {	
	 	return	false;	
	 	}	
	}	

}
