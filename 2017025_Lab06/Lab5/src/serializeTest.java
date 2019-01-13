import org.junit.Test;
import static org.junit.Assert.*;

import java.io.IOException;

public class serializeTest {
	
	dataBase D = new dataBase();
	Admin A = new Admin(D);
	
	String location = "Mobile>Smart";
	String name = "N5";
	int qty = 10;
	int price = 1999;
	
	@Test
	public void databasetest() {
		try {
			A.insert(location, name, qty, price);
			
			mainClass.serialize(D);
			
			mainClass.deserialize();
			
			A.search(name);

			
		} catch (ProductExistsException e) {
			
			fail("Expected error did not occur 1 !!! ");
			
		}  catch (InvalidProductException e) {
			
			fail("Expected error did not occur 2 !!! ");
			
		}  catch (ClassNotFoundException e) {
			fail("Expected error did not occur 3 !!! ");

		} catch (IOException e) {
			fail("Expected error did not occur 4 !!! ");

		} 
	}
	
}
