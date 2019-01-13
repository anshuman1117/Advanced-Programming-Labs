
public class Songs {
	private String name;
	private int uid;
	private int artistID;
	
	// Constructor
	public Songs(String name, int uid, int id) {
		this.name = name;
		this.uid = id;
		this.artistID = uid;
		
	}
	
	// Getter and Setter functions
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	
	public int getartistID() {
		return artistID;
	}
	
	
}
