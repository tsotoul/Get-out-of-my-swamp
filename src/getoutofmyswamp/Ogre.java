package getoutofmyswamp;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Ogre implements EnterSwamp, Move, Observable, Serializable{
	
	//Declare local variables
	private String name;
	private ImageIcon ogreIcon = new ImageIcon(getClass().getClassLoader().getResource("ogre_small.gif"));
	private int rowPosition;
	private int colPosition;
	private ArrayList<IEnemy> myEnemies = new ArrayList<IEnemy>();
	protected IMood Ogremood;
	
	
	//Constructor
	public Ogre() {
		this.name = "Hek";					//Give a name by default
		setOgremood(new Passive());			//Set the Mood to Passive by default
	}
	
	//////////////////////////////Methods from EnterSwamp Interface //////////////////////////////////////////
	
	//enterSwamp method for the Ogre to enter the Grid 
	@Override
	public void enterSwamp(Grid theGrid) {
		Random r = new Random();
		int row = r.nextInt(GamePlay.gridSize) + 1;			//Create a random number in the range (0-4)
		int col = r.nextInt(GamePlay.gridSize) + 1;			//Create a random number in the range (0-4)
		for ( Row tempRow : theGrid.theGrid) {
			for (Square s : tempRow.theRow) {
				if(s.getNumber() == col && tempRow.getNumber() == row) {
					if(s.getNumber() == 1 && tempRow.getNumber() == 1) {  	//Make sure Ogre does not enter in position 1,1
						enterSwamp(theGrid);								//using recursion to ensure it does not enter in 1,1
					}else {
						s.addOgre(this);
						break;
					}
				}
			}
		}
	}
	
	//////////////////////////////Methods from Move Interface //////////////////////////////////////////
	
	@Override
	public void move(Grid theGrid) {

		int row = getRowPosition(theGrid);						//Get the current row position of the Ogre
		int col = getColPosition(theGrid);						//Get the current column position of the Ogre
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

		//using recursion to make sure that the Ogre does not go out of the Grid or remains in the same position
		if(testRow < 1 || testRow > GamePlay.gridSize || testCol < 1 || testCol > GamePlay.gridSize || (testRow == row && testCol == col)) {
			move(theGrid);
		} else {
			row = testRow; 
			col = testCol;
			
			clearOgre(theGrid);									//remove the Ogre from its current position before moving
			
			for ( Row tempRow : theGrid.theGrid) {
				for (Square s : tempRow.theRow) {
					if(s.getNumber() == col && tempRow.getNumber() == row) {
						s.addOgre(this);						//add the Ogre to the random neighbouring position
					}
				}
			}
			this.sendUpdate(theGrid);							//Send the update to all the Enemies
		}
	}
	
	//clearOgre method to remove the Ogre from the current Square - to be used in move() method
	public void clearOgre(Grid theGrid) {
		for(Row tempRow : theGrid.theGrid) {
			for(Square s : tempRow.theRow) {
				s.removeOgre(this);
			}
		}
	}
	
	
	////////////////////////////// Methods from Observable Interface //////////////////////////////////////////
	
	//addNewEmeny method to add an IEnemy to the Ogre list of enemies in order to send the update
	@Override
	public void addNewEnemy(IEnemy e) {
		this.myEnemies.add(e);
		
	}
	
	//removeEnemy method to remove an IEnemy of the Ogre list of enemies
	@Override
	public void removeEnemy(IEnemy e) {
		this.myEnemies.remove(e);
		
	}

	//sendUpdate method to call the getUpdate() of each IEnemy object in the myEnemies list
	@Override
	public void sendUpdate(Grid theGrid) {
		for(IEnemy e : this.myEnemies) {
			e.getUpdate(theGrid);
		}
	}

	///////////////////////////////////////Methods from Mood Interface //////////////////////////////////////////
	
	//performMood method to return a number (killingAmount) representing the Mood of the Ogre (1 - Passive, 2 - Grumpy)
	public int performMood() {
		return this.Ogremood.mood();
	}
	
	
	//////////////////////////////Method to check the enemies of the square //////////////////////////////////////////
	
	//checkSquare method to check the Square that has the Ogre 
	public boolean checkSquare(Grid theGrid, int killingAmount) {
	
		for(Row tempRow : theGrid.theGrid) {
			for(Square s : tempRow.theRow) {
				if(s.getHasOgre()) {							//if the Square has the Ogre
					if(s.getTheEnemyList().size() <= killingAmount && s.getTheEnemyList().size() > 0) {  //if the number of the enemies is less than the KillingAmount 
						String enemy = "";
						for(IEnemy e : s.getTheEnemyList()) {
							enemy = e.getType().toString();
							this.removeEnemy(e);
						}
						String output = "Ogre killed a " +  enemy + " in row: " + tempRow.getNumber() + " and col: " + s.getNumber();
						JOptionPane.showMessageDialog(null, output);
						s.removeAllEnemies();
						return false;
					}
					else if (s.getTheEnemyList().size() >= killingAmount + 1) {							//if the number of the enemies is equal or more than the KillingAmount + 1 
						String output = "GAME IS OVER\nOgre was killed in row: " + tempRow.getNumber() + " and col: " + s.getNumber() + " by the following enemies:";
						for(IEnemy e : s.getTheEnemyList()){
							output = output + "\n" + e.getType().toString();
						}
						JOptionPane.showMessageDialog(null, output);
						return true;
					}
				}
			}
		}
		return false;
	}
	
	//////////////////////////////Methods to count the enemies of the game by category (to be used in GUI) //////////////////////////////////////////
	
	//countDonkeys to count the donkeys in the square
	public int countDonkeys() {
		int count = 0;
		for(IEnemy e : this.myEnemies) {
			if(e.getType().toString() == "Donkey") {
				count++;
			}
		}
		return count;
	}
	
	//countSnakes to count the donkeys in the square
	public int countSnakes() {
		int count = 0;
		for(IEnemy e : this.myEnemies) {
			if(e.getType().toString() == "Snake") {
				count++;
			}
		}
		return count;
	}
	
	//countParrots to count the donkeys in the square
	public int countParrots() {
		int count = 0;
		for(IEnemy e : this.myEnemies) {
			if(e.getType().toString() == "Parrot") {
				count++;
			}
		}
		return count;
	}
	
	//////////////////////////////////////////// Getters and Setters////////////////////////////////////////////////////////////
	
	public String getName() {
		return name;
	}

	//getRowPosition method to get the current row position of the Ogre
	public int getRowPosition(Grid theGrid) {
		int rowPosition = 0;
		for(Row tempRow : theGrid.theGrid) {
			for(Square s : tempRow.theRow) {
				if(s.getOgre() == this) {
					rowPosition = tempRow.getNumber();
					break;
				}
			}
		}
		return rowPosition;
	}

	public void setRowPosition(int rowPosition) {
		this.rowPosition = rowPosition;
	}
	
	//getColPosition method to get the current column position of the Ogre
	public int getColPosition(Grid theGrid) {
		for(Row tempRow : theGrid.theGrid) {
			for(Square s : tempRow.theRow) {
				if(s.getOgre() == this) {
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


	public IMood getOgremood() {
		return Ogremood;
	}


	public void setOgremood(IMood ogremood) {
		Ogremood = ogremood;
	}


	public ImageIcon getOgreIcon() {
		return ogreIcon;
	}


	public void setOgreIcon(ImageIcon ogreIcon) {
		this.ogreIcon = ogreIcon;
	}


	public ArrayList<IEnemy> getMyEnemies() {
		return myEnemies;
	}
}
