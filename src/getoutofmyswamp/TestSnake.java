package getoutofmyswamp;

import junit.framework.TestCase;

public class TestSnake extends TestCase {
	
	/*
	 * Only the Snake methods were tested as the other enemies 
	 * (Parrot and Donkey) implement exactly the same methods
	 */

	//enterSwamp() method test
	public void testEnterSwamp() {
		Grid testGrid = new Grid(5);
		IEnemy testEnemy = new Snake();
		
		testEnemy.enterSwamp(testGrid);
		
		int actualRow = testEnemy.getRowPosition(testGrid);
		int actualCol = testEnemy.getColPosition(testGrid);
		
		int expectedRow = 1;
		int expectedCol = 1;
		
		assertTrue(actualRow == expectedRow);
		assertTrue(actualCol == expectedCol);
	}

	//move() method test
	public void testMove() {
		int gridSize = 5;
		Grid testGrid = new Grid(gridSize);
		IEnemy testEnemy = new Snake();
		
		testEnemy.enterSwamp(testGrid);
		int rowBefore = testEnemy.getRowPosition(testGrid);
		int colBefore = testEnemy.getColPosition(testGrid);
		
		testEnemy.move(testGrid);
		int rowAfter = testEnemy.getRowPosition(testGrid);
		int colAfter = testEnemy.getColPosition(testGrid);
		
		boolean rowActual = rowAfter >= 1 && rowAfter <= gridSize && (rowAfter!= rowBefore || colAfter != colBefore);
		boolean rowExpected = true;
		
		boolean colActual = colAfter >= 1 && colAfter <= gridSize && (colAfter != colBefore || rowAfter != rowBefore);
		boolean colExpected = true;
		
		assertTrue(rowActual == rowExpected && colActual == colExpected);
	}

	//getUpdate() method test
	public void testGetUpdate() {
		int gridSize = 5;
		Grid testGrid = new Grid(gridSize);
		IEnemy testEnemy = new Snake();
		testEnemy.enterSwamp(testGrid);
		
		int rowBefore = testEnemy.getRowPosition(testGrid);
		int colBefore = testEnemy.getColPosition(testGrid);
		
		testEnemy.getUpdate(testGrid);
		
		int rowAfter = testEnemy.getRowPosition(testGrid);
		int colAfter = testEnemy.getColPosition(testGrid);
		
		assertTrue(rowBefore != rowAfter || colBefore != colAfter);
	}

	//removeEnemy() method test
	public void testRemoveEnemy() {
		Grid testGrid = new Grid(5);
		IEnemy testEnemy = new Snake();
		testEnemy.enterSwamp(testGrid);
		
		testEnemy.removeEnemy(testGrid);
		boolean actual = testGrid.theGrid.contains(testEnemy);
		boolean expected = false;
		
		assertTrue(actual == expected);
	}

	//getType() method test
	public void testGetType() {
		IEnemy testEnemy = new Snake();
		
		String actual = testEnemy.getType();
		String expected = "Snake";
		
		assertTrue(actual == expected);
	}

	//getRowPosition() method test
	public void testGetRowPosition() {
		Grid testGrid = new Grid(5);
		IEnemy testEnemy = new Snake();
		
		testEnemy.enterSwamp(testGrid);
		int actualRow = testEnemy.getRowPosition(testGrid);
		int expectedRow = 1;
		
		assertTrue(actualRow == expectedRow);
	}

	//getColPosition() method test
	public void testGetColPosition() {
		Grid testGrid = new Grid(5);
		IEnemy testEnemy = new Snake();
		
		testEnemy.enterSwamp(testGrid);
		int actualCol = testEnemy.getColPosition(testGrid);
		int expectedCol = 1;
		
		assertTrue(actualCol == expectedCol);
	}

}
