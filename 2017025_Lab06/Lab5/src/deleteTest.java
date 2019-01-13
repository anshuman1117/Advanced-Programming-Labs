import org.junit.Test;
import static org.junit.Assert.*;

public class deleteTest {
	

	dataBase D = new dataBase();
	Admin A = new Admin(D);


	@Test
	public void deletetest() {
		try {
		
			A.delete("mobile>smartphone", "Lumia");
			
			fail("Expected error did not occur !!! ");
			
		} catch (InvalidPathException e) {
			//if execution reaches here, 
	        //it indicates this exception had occurred.
	        //so we need not handle it.
		}
	}
	
}



/* REFERENCE: 
 * 
 * https://stackoverflow.com/questions/156503/how-do-you-assert-that-a-certain-exception-is-thrown-in-junit-4-tests
 * 
 */








