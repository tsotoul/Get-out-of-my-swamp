package getoutofmyswamp;

import java.io.Serializable;
import java.util.Random;

public class GamePlay implements Serializable{
	
	//Declare local variables
	static int gridSize = 4;				//set the gridSize 
	Grid theGrid;
	Ogre hek;
	int killingAmount;
	IEnemy enemy;
	
	//Constructor
	public GamePlay() {
		
		theGrid = new Grid(gridSize);		//Create the Grid
		hek = new Ogre();					//Create the Ogre

		killingAmount = hek.performMood();	//Get the Ogre mood (default to Passive - returning 1)

		hek.enterSwamp(theGrid);			//Ogre enters the swamp
	}
	
	//nextMove method to be called with the -MOVE- button from the GUI
	public boolean nextMove() {
			
		hek.move(theGrid);							//Move the Ogre - this will trigger the enemies to move (Observer Pattern)
			
		int chance = randomNumberGenerator();
		if(chance == 0) {
			enemy = getEnemy();						//Create a random type enemy
			enemy.enterSwamp(theGrid);				//Enemy enters the swamp at 1,1
			hek.addNewEnemy(enemy);					//Enemy is added in myEnemies list of the Ogre (to get the updates)
		}
		boolean gameOver = hek.checkSquare(theGrid, killingAmount);		//game is over if true;
		return gameOver;
	}
	
	
	//Method to return a random number in the range (0-2)
	public int randomNumberGenerator() {
		Random randNum = new Random();
		return randNum.nextInt(3);
	}
	
	//getEnemy method to return randomly a new enemy type in the runtime- Polymorphism
	private static IEnemy getEnemy() {
		Random rand = new Random();
		int randomNumber = rand.nextInt(3);
		
		if(randomNumber == 0) {
			return new Snake();
		}
		else if (randomNumber == 1) {
			return new Parrot();
		}
		else {
			return new Donkey();
		}
	}

	
	//////////////////////////////////////////Getters and Setters///////////////////////////////////////////////
	
	public void setKillingAmount(int killingAmount) {
		this.killingAmount = killingAmount;
	}
	
	
}
