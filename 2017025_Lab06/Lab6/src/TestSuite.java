import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
	insertTest.class,
	deleteTest.class,
	searchTest.class,
	outofstockTest.class,
	outoffundsTest.class,
	deserialTest.class,
	serializeTest.class
})


public class TestSuite {}
