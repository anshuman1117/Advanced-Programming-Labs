import org.junit.Test;
import static org.junit.Assert.*;

public class outofstockTest {
	
	dataBase D = new dataBase();
	Admin A = new Admin(D);
	Customer C = new Customer(D, 1001, "ABC");
	


	@Test
	public void stocktest() {
		try {
			A.insert("mobile>latest", "R6", 0, 1444);
			
			C.addProduct("R6", 33);
			
			fail("Expected error did not occur !!! ");
			
		} catch(InvalidProductException e) {
			
			fail("Product was invalid !!! ");
		
		} catch(ProductExistsException e) {
			
			fail("Product is non-existant !!! ");
			
		}catch (InsufficientQtyException e) {
			//if execution reaches here, 
	        //it indicates that this exception occurred.
	        //so we need not handle it.
		} 
	}
	
}


/* REFERENCE: 
 * 
 * https://stackoverflow.com/questions/156503/how-do-you-assert-that-a-certain-exception-is-thrown-in-junit-4-tests
 * 
*/