package getoutofmyswamp;

import java.awt.Image;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Square implements Serializable{
	
	//Variables and Collections
	private boolean hasOgre;
	private boolean hasEnemy;
	private Ogre theOgre;
	private ArrayList<IEnemy> theEnemyList = new ArrayList<IEnemy>();
	private int number;
	
	//Constructor
	public Square(int number) {
		setNumber(number);
		setHasOgre(false);
		setHasEnemy(false);
	}//end Constructor
	
	//addOgre method
	public void addOgre(Ogre o) {
		this.theOgre = o;					
		setHasOgre(true);					
	}
	
	//addEnemy method to add an IEnemy object to theEnemyList of Square
	public void addEnemy(IEnemy e) {
		this.theEnemyList.add(e);
		setHasEnemy(true);
	}
	
	//removeOgre method to remove the Ogre from the Square
	public void removeOgre(Ogre o) {
		this.theOgre = null;
		setHasOgre(false);
	}
	
	//removeEnemy method to remove a IEnemy object from theEnemyList of the Square
	public void removeEnemy(IEnemy e) {
		this.theEnemyList.remove(e);
	}
	
	//removeAllEnemies method to remove all enemies from theEnemyList of the Square
	public void removeAllEnemies() {
		this.theEnemyList.removeAll(theEnemyList);
	}
	
	
	//The toString method to return an empty string or the number of the IEnemies in a Square
	public String toString() {
		String output = "";
		if(this.theOgre == null && this.theEnemyList.size() == 0) {
			output = "";
		}else if (this.theOgre != null){
			output = "";
		}
		else if(this.theEnemyList.size() != 0) {
				output = "" + this.theEnemyList.size();
		}
		return output;
	}
	
	//toIcon method to return null or an ImageIcon of the Square if at least one IEnemy exists in the Square
	public ImageIcon toIcon() {
		ImageIcon output = null;
		if(this.theOgre == null && this.theEnemyList.size() == 0) { 		//check if the Square has an Ogre AND an Enemy
			output = null;
		}else if (this.theOgre != null){									//check if the Square has an Ogre
			output = this.theOgre.getOgreIcon();
		}
		else if(this.theEnemyList.size() != 0) {							//check if the Square has at least an Enemy
			for(IEnemy e : this.theEnemyList) {
				output = e.getIcon();										//return the ImageIcon of the IEnemy
			}
		}
		return output;
	}
	
	////////////////////////////////////////////Getters and setters/////////////////////////////////////////////////
	public int getNumber() {
		return this.number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
	public Ogre getOgre() {
		return this.theOgre;
	}
	
	public boolean getHasOgre() {
		return hasOgre;
	}

	public void setHasOgre(boolean hasOgre) {
		this.hasOgre = hasOgre;
	}

	public boolean getHasEnemy() {
		return hasEnemy;
	}

	public void setHasEnemy(boolean hasEnemy) {
		this.hasEnemy = hasEnemy;
	}

	public ArrayList<IEnemy> getTheEnemyList() {
		return theEnemyList;
	}
	//end getters and setters
}
