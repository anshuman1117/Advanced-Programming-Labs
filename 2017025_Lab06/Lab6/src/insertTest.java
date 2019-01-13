import org.junit.Test;
import static org.junit.Assert.*;

public class insertTest {
	

	dataBase D = new dataBase();
	Admin A = new Admin(D);
	
	String inputLocation = "Mobile>Smart";
	String inputName = "N5";
	int qty = 10;
	int price = 1999;

	
	@Test
	public void insettest() {
		try {
		
			A.insert(inputLocation, inputName,  qty, price);
			A.insert(inputLocation, inputName, qty, price);	
			fail("Expected error did not occur !!! ");
			
		} catch (ProductExistsException e) {
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







