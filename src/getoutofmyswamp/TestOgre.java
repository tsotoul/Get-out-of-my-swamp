package getoutofmyswamp;

import junit.framework.TestCase;

public class TestOgre extends TestCase {

	//enterSwamp() method test
	public void testEnterSwamp() {
		int gridSize = 5;
		Grid testGrid = new Grid(gridSize);
		Ogre testOgre = new Ogre();
		
		testOgre.enterSwamp(testGrid);
		
		int row = testOgre.getRowPosition(testGrid);
		int col = testOgre.getColPosition(testGrid);
		
		boolean actual = (row > 1 || col > 1) && row <= gridSize;
	}

	//move() method test
	public void testMove() {
		int gridSize = 5;
		Grid testGrid = new Grid(gridSize);
		Ogre testOgre = new Ogre();
		
		testOgre.enterSwamp(testGrid);
		int rowBefore = testOgre.getRowPosition(testGrid);
		int colBefore = testOgre.getColPosition(testGrid);
		
		testOgre.move(testGrid);
		int rowAfter = testOgre.getRowPosition(testGrid);
		int colAfter = testOgre.getColPosition(testGrid);
		
		boolean rowActual = rowAfter >= 1 && rowAfter <= gridSize && (rowAfter!= rowBefore || colAfter != colBefore);
		boolean rowExpected = true;
		
		boolean colActual = colAfter >= 1 && colAfter <= gridSize && (colAfter != colBefore || rowAfter != rowBefore);
		boolean colExpected = true;
		
		assertTrue(rowActual == rowExpected && colActual == colExpected);
	}

	//clearOgre() method test
	public void testClearOgre() {
		int gridSize = 5;
		Grid testGrid = new Grid(gridSize);
		Ogre testOgre = new Ogre();
		
		testOgre.enterSwamp(testGrid);
		
		testOgre.clearOgre(testGrid);
		
		boolean actual = testGrid.theGrid.contains(testOgre);
		boolean expected = false;
		
		assertTrue(actual == expected);
	}

	//addNewEnemy() method test
	public void testAddNewEnemy() {
		Ogre testOgre = new Ogre();
		IEnemy snake = new Snake();
		
		testOgre.addNewEnemy(snake);
		
		boolean actual = testOgre.getMyEnemies().contains(snake);
		boolean expected = true;
		
		assertTrue(actual == expected);
	}

	//removeEnemy() method test
	public void testRemoveEnemy() {
		Ogre testOgre = new Ogre();
		IEnemy snake = new Snake();
		
		testOgre.addNewEnemy(snake);
		testOgre.removeEnemy(snake);
		
		boolean actual = testOgre.getMyEnemies().contains(snake);
		boolean expected = false;
		
		assertTrue(actual == expected);
	}

	//sendUpdate() method test
	public void testSendUpdate() {
		int gridSize = 5;
		Grid testGrid = new Grid(gridSize);
		Ogre testOgre = new Ogre();
		IEnemy snake = new Snake();
		
		testOgre.addNewEnemy(snake);
		snake.enterSwamp(testGrid);
		
		testOgre.sendUpdate(testGrid);
		
		int rowActual = snake.getRowPosition(testGrid);
		int colActual = snake.getColPosition(testGrid);
		
		int RowColExpected = 1;
		
		assertTrue(rowActual != RowColExpected || colActual != RowColExpected);
	}

	//performMood() method test
	public void testPerformMood() {
		Ogre testOgre = new Ogre();
		
		int actual = testOgre.performMood();
		int expected = 1;
		
		assertTrue(actual == expected);
	}

	//checkSquare() method test
	public void testCheckSquare() {
		int gridSize = 5;
		Grid testGrid = new Grid(gridSize);
		Ogre testOgre = new Ogre();
		IEnemy snake = new Snake();
		
		testOgre.addNewEnemy(snake);
		testOgre.enterSwamp(testGrid);
		snake.enterSwamp(testGrid);
		
		boolean actual = testOgre.checkSquare(testGrid, 1);
		boolean expected = false;
		
		assertTrue(actual == expected);
	}

	//countDonkeys() method test (the countSnakes() and countParrots() methods are exactly the same)
	public void testCountDonkeys() {
		Ogre testOgre = new Ogre();
		int donkeysToCreate = 3;
		IEnemy testDonkey1 = new Donkey();
		IEnemy testDonkey2 = new Donkey();
		IEnemy testDonkey3 = new Donkey();
		
		testOgre.addNewEnemy(testDonkey1);
		testOgre.addNewEnemy(testDonkey2);
		testOgre.addNewEnemy(testDonkey3);
		
		int actual = testOgre.countDonkeys();
		int expected = donkeysToCreate;
		
		assertTrue(actual == expected);	
	}

	//getName() method test
	public void testGetName() {
		String name = "Hek";
		Ogre testOgre = new Ogre();
		
		String actual = testOgre.getName();
		String expected = name;
		
		assertTrue(actual == expected);
	}

}
