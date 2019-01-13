import org.junit.Test;
import static org.junit.Assert.*;

public class outoffundsTest {
	
	dataBase D = new dataBase();
	Admin A = new Admin(D);
	Customer C = new Customer(D, 1001, "ABC");
	


	@Test
	public void fundstest() {
		try {
			A.insert("mobile>latest", "R6", 99, 1444);
			
			C.addProduct("R6", 33);
			
			C.checkout();
			
			fail("Expected error did not occur !!! ");
			
		} catch(InvalidProductException e) {
			
			fail("Product was invalid !!! ");
		
		} catch(ProductExistsException e) {
			
			fail("Product is non-existant !!! ");
			
		} catch(InsufficientQtyException e) {
			
			fail("Product is less in quantity !!! ");
			
		} catch(NoSellException e) {
			
			fail("unexpected outcome !!! ");
			
		}  catch (InsufficientFundsException e) {
			//if execution reaches here, 
	        //it indicates this exception occurred.
	        //so we need not handle it.
		} 
	}
}


/* REFERENCE: 
 * 
 * https://stackoverflow.com/questions/156503/how-do-you-assert-that-a-certain-exception-is-thrown-in-junit-4-tests
 * 
*/



