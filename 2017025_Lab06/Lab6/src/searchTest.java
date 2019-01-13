import org.junit.Test;
import static org.junit.Assert.*;

public class searchTest {
	
	dataBase D = new dataBase();
	Admin A = new Admin(D);


	@Test
	public void searchtest() {
		try {
		
			A.search("Lumiaa");
			
			fail("Expected error did not occur !!! ");
			
		} catch (InvalidProductException e) {
			//if execution reaches here, 
	        //it indicates this exception was occurred.
	        //so we need not handle it.
		}
	}
	
	
}



/* REFERENCE: 
 * 
 * https://stackoverflow.com/questions/156503/how-do-you-assert-that-a-certain-exception-is-thrown-in-junit-4-tests
 * 
 */

