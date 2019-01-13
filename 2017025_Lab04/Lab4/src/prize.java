
public class prize implements Cloneable{
	
	protected String name;
	protected int weight;
	
	// Constructor
	public prize(String name, int weight) {
		super();
		this.name = name;
		this.weight = weight;
	}
	
	// Equals function
	@Override		
	public boolean equals(Object	o1)	{	
	 if(o1	!=	null	&&	getClass()	==	o1.getClass())	{	
	 	prize	o	=	(prize)	o1;	//type	casting	
	 	return	(name == o.getName()	&&	weight == o.getWeight());	
	} else {	
	 	return	false;	
	 	}	
	}
	
	// Cloning function
	@Override
	public prize clone() {
		 try {
			 prize copy = (prize) super.clone();
			 return copy;
		 } catch (CloneNotSupportedException e) {
			 // this will never happen
			 return null;
		 }
	}
	
	// Getter and Setter functions
	protected String getName() {
		return name;
	}
	protected void setName(String name) {
		this.name = name;
	}
	protected int getWeight() {
		return weight;
	}
	protected void setWeight(int weight) {
		this.weight = weight;
	}
	
	public double updateValue(double value) {
		return value;
	}
	
	
}
