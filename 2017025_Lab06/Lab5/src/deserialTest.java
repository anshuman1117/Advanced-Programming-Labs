import org.junit.Test;
import static org.junit.Assert.*;
import java.io.IOException;

public class deserialTest {
	dataBase D = new dataBase();
	Admin A = new Admin(D);
	Customer C = new Customer(D, 199, "ZBD");
	
	String location = "Mobile>Smart";
	String name = "N5";
	int qty = 10;
	int price = 1999;
	
	@Test
	public void customertest() {
		try {
			
			// Serializing first
			A.insert(location, name, qty, price);
			
			C.addProduct(name, 5);
			
			mainClass.getCusto().add(C);
			
			String check1 = C.allProduct();
			
			mainClass.serialize(D);
			
			// Deserializing now
			mainClass.deserialize();
			
			Customer C1 = mainClass.checkCustomer("ZBD");
			
			String check2 = C1.allProduct();
			
			assertEquals(check1, check2);
	
			
		}  catch (ProductExistsException e) {
			
			fail("Unexpected error 1 !!! ");
			
		}  catch (InvalidProductException e) {
			
			fail("Unexpected error 2 !!! ");
			
		}  catch (ClassNotFoundException e) {
			fail("Unexpected error 3 !!! ");
	
		}  catch (IOException e) {
			fail("Unexpected error 4 !!! ");
	
		}  catch (InsufficientQtyException e) {
			fail("Unexpected error 5 !!! ");

		}
	}
	
	
	
	
}
