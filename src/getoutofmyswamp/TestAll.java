package getoutofmyswamp;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class TestAll extends TestCase {

	public static Test suite() {
		TestSuite suite = new TestSuite(TestAll.class.getName());
		//$JUnit-BEGIN$
		suite.addTestSuite(TestOgre.class);
		suite.addTestSuite(TestSnake.class);
		suite.addTestSuite(TestSquare.class);
		//$JUnit-END$
		return suite;
	}

}
