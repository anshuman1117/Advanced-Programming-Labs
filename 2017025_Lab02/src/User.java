import java.util.*;

public interface User {

	public void details();
	
	public void stream(ArrayList<Artist> A, int index, boolean play, boolean dwnld, Subscriptions[] S);
	
	public int subsxIndex();
}
