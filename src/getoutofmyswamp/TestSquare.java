package getoutofmyswamp;

import javax.swing.ImageIcon;

import junit.framework.TestCase;

public class TestSquare extends TestCase {

	//addOgre() method test
	public void testAddOgre() {
		Square testSquare = new Square(1);
		Ogre testOgre = new Ogre();
		
		testSquare.addOgre(testOgre);
		Ogre actual = testSquare.getOgre();
		Ogre expected = testOgre;
		
		assertTrue(actual == expected);
	}

	//addEnemy() method test
	public void testAddEnemy() {
		Square testSquare = new Square(1);
		IEnemy testEnemy = new Snake();
		
		testSquare.addEnemy(testEnemy);
		boolean actual = testSquare.getTheEnemyList().contains(testEnemy);
		boolean expected = true;
		
		assertTrue(actual == expected);
	}

	//removeOgre() method test
	public void testRemoveOgre() {
		Square testSquare = new Square(1);
		Ogre testOgre = new Ogre();
		testSquare.addOgre(testOgre);
		
		testSquare.removeOgre(testOgre);
		boolean actual = testSquare.getHasEnemy();
		boolean expected = false;
		
		assertTrue(actual == expected);
	}

	//removeEnemy() method test
	public void testRemoveEnemy() {
		Square testSquare = new Square(1);
		IEnemy testEnemy = new Snake();
		
		testSquare.addEnemy(testEnemy);
		testSquare.removeEnemy(testEnemy);
		
		boolean actual = testSquare.getTheEnemyList().contains(testEnemy);
		boolean expected = false;
		
		assertTrue(actual == expected);
	}

	//removeAllEnemies() method test
	public void testRemoveAllEnemies() {
		Square testSquare = new Square(1);
		IEnemy testEnemy = new Snake();
		testSquare.addEnemy(testEnemy);
		IEnemy testEnemy2 = new Parrot();
		testSquare.addEnemy(testEnemy2);
		
		testSquare.removeAllEnemies();
		int actual = 0;
		int expected = testSquare.getTheEnemyList().size();
		
		assertTrue(actual == expected);
	}

	//toString() method test
	public void testToString() {
		Square testSquare = new Square(1);
		Ogre testOgre = new Ogre();
		testSquare.addOgre(testOgre);
		
		String actual = "";
		String expected = testSquare.toString();
		
		testSquare.removeOgre(testOgre);
		IEnemy testEnemy = new Snake();
		testSquare.addEnemy(testEnemy);
		
		assertTrue(actual == expected);
		assertEquals(true, testSquare.toString().equals("1"));
	}

	//toIcon() method test
	public void testToIcon() {
		Square testSquare = new Square(1);
		Ogre testOgre = new Ogre();
		testSquare.addOgre(testOgre);
		
		ImageIcon testIcon = new ImageIcon("ogre_small.gif");
		testOgre.setOgreIcon(testIcon);
		
		ImageIcon actual = testSquare.toIcon();
		ImageIcon expected = testIcon;
		
		assertTrue(actual == expected);
	}

	//getNumber() method test
	public void testGetNumber() {
		int number = 1;
		Square testSquare = new Square(number);
		
		int actual = testSquare.getNumber();
		int expected = number;
		
		assertTrue(actual == expected);	
	}

}
