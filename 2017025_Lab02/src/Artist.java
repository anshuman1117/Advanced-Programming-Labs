import java.util.*;


public class Artist implements User{
	private int uid;
	private String name;
	private ArrayList<Songs> songs;
	private int subsIndex;
	private int royalty;
	
	
	
	// Constructor 
	public Artist(int uid, String name) {
		
		this.uid = uid;
		this.name = name;
		this.songs = new ArrayList<Songs>();
		this.subsIndex = 4;
		this.royalty = 0;
	}
	
	
	
	// Other functionality enhancing methods
	public void addSong(Songs geet) {
		songs.add(geet);
	}
	
	public void updateRoyalty(int amount) {
		royalty += amount;
	}
	
	public int resetRoyalty() {
		int temp = royalty;
		royalty = 0;
		return temp;
	}
	
	public int findSong(int ID) {
		int index = -1;
		for(int i=0; i<songs.size(); i++) {
			if(songs.get(i).getUid() == ID) {
				index = i;
				break;
			}	
		}
		
		return index;
	}
	
	public String findSongName(int ID) {
		
		for(int i=0; i<songs.size(); i++) {
			if(songs.get(i).getUid() == ID)
				return songs.get(i).getName();
		}
		return "";
	}
	
	
	
	// Interface methods
	@Override
	public void details() {
		System.out.print(name + " " + uid + ": ");
		
		if(songs.size() > 0) {
			System.out.print(songs.get(0).getName());
			for(int i=1; i<songs.size(); i++) {
				System.out.print(", " + songs.get(i).getName());
			}
		} else {
			System.out.println("No songs !!!");
		}
	}          
	
	@Override 
	public void stream(ArrayList<Artist> A, int index, boolean play, boolean dwnld, Subscriptions[] S) {
		
		// Updating royalty if someone else's song
		if(A.get(index).getID() != this.uid) {
			if(play == true) {
				A.get(index).updateRoyalty(5);
			} else if(dwnld = true) {
				A.get(index).updateRoyalty(20);
			}
		}
				
		
	}
	
	@Override
	public int subsxIndex() {
		return this.getSubsIndex();
	}
	
	
	
	// Getter and Setter methods
	public int getID() {
		return uid;
	}
	public void setID(int uid) {
		this.uid = uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getSubsIndex() {
		return subsIndex;
	}

	public void setSubsIndex(int subsIndex) {
		this.subsIndex = subsIndex;
	}
	
	
	
}


