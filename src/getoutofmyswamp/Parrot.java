package getoutofmyswamp;

import java.io.Serializable;
import java.util.Random;

import javax.swing.ImageIcon;

public class Parrot implements IEnemy, Observer, Serializable {
	
	//Declare variables
	private String type;
	private ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("parrot.png"));
	private int rowPosition;
	private int colPosition;
	
	//Constructor
	public Parrot() {
		setType("Parrot");
	}

	///////////////////////////////////////// Methods from IEnemy Interface/////////////////////////////////////////////
	
	//enterSwamp method for the parrot to enter the Grid in 1,1 Square
	@Override
	public void enterSwamp(Grid theGrid) {
		for ( Row tempRow : theGrid.theGrid) {
			for (Square s : tempRow.theRow) {
				if(s.getNumber() == 1 && tempRow.getNumber() == 1) {			//ensure the 1,1 insert position
					s.addEnemy(this);
					break;
				}
			}
			
		}
	}

	//move method for the parrot to move in a neighbouring Square in the Grid
	@Override
	public void move(Grid theGrid) {
		int row = getRowPosition(theGrid);						//get the current row position
		int col = getColPosition(theGrid);						//get the current column position
		int testRow = 0;
		int testCol = 0;
		
		if(row == 1 && col == 1) {								//if the current position is 1,1 adjust the random generator (no 0)
			Random r = new Random();
			testRow = r.nextInt(row+1) + (1);
			testCol = r.nextInt(col+1) + (1);
		} else {
			Random r = new Random();							//if the current position is NOT 1,1 randomly select a neighbouring position
			testRow = r.nextInt(row+1) + (row - 1);
			testCol = r.nextInt(col+1) + (col - 1);
		}
		
		//using recursion to make sure that the parrot does not go out of the Grid or remains in the same position
		if(testRow < 1 || testRow > GamePlay.gridSize || testCol < 1 || testCol > GamePlay.gridSize || (testRow == row && testCol == col)){
			move(theGrid);
		} else {
			row = testRow; 
			col = testCol;
			
			removeEnemy(theGrid);								//remove the parrot from its current position before moving
			
			for ( Row tempRow : theGrid.theGrid) {
				for (Square s : tempRow.theRow) {
					if(s.getNumber() == col && tempRow.getNumber() == row) {
						s.addEnemy(this);
					}
				}
			}
		}
	}
	
	///////////////////////////////////////// Methods from Observer Interface/////////////////////////////////////////////
	
	//getUpdate method to be executed when called from the Observable object	
	@Override
	public void getUpdate(Grid theGrid) {
		this.move(theGrid);
		
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	//removeEnemy method to remove this parrot from the Square
	@Override
	//Remove this enemy from the square
	public void removeEnemy(Grid theGrid) {
		for(Row tempRow : theGrid.theGrid) {
			for(Square s : tempRow.theRow) {
				if(s.getTheEnemyList().contains(this)) {
					s.getTheEnemyList().remove(this);
				}
			}
		}
	}
	
	///////////////////////////////////////////Getters and Setters///////////////////////////////////////////////////////
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	//getRowPosition method to get the current row position of the parrot
	public int getRowPosition(Grid theGrid) {
		int row = 0;
		for(Row tempRow : theGrid.theGrid) {
			for(Square s : tempRow.theRow) {
				if(s.getTheEnemyList().contains(this)) {
					rowPosition = tempRow.getNumber();
					break;
				}
			}
		}
		//System.out.println(rowPosition);
		return rowPosition;
	}

	public void setRowPosition(int rowPosition) {
		this.rowPosition = rowPosition;
	}

	//getColPosition method to get the current column position of the parrot
	public int getColPosition(Grid theGrid) {
		for(Row tempRow : theGrid.theGrid) {
			for(Square s : tempRow.theRow) {
				if(s.getTheEnemyList().contains(this)) {
					colPosition = s.getNumber();
					break;
				}
			}
		}
		//System.out.println(colPosition);
		return colPosition;
	}

	public void setColPosition(int colPosition) {
		this.colPosition = colPosition;
	}
	
	public ImageIcon getIcon() {
		return icon;
	}

}
