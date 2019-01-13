
public class softToy extends prize implements Cloneable {

	
	public softToy(String name, int weight) {
		super(name, weight);
	}
	
	// Equals function
	@Override		
	public	boolean	equals(Object	o1)	{	
	 if(o1	!=	null	&&	getClass()	==	o1.getClass())	{	
	 	softToy	o	=	(softToy)	o1;	//type	casting	
	 	return	(name == o.getName()	&&	weight == o.getWeight());	
	} else {	
	 	return	false;	
	 	}	
	}	
	
	// Clone method
	@Override
	public softToy clone() {
		 softToy p = (softToy) super.clone();
		 return p;
	} 
		
	// Update value function
	@Override
	public double updateValue(double points) {
		double value = 2*points + 10;
		return value;
	}
	

}
