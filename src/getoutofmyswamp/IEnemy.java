package getoutofmyswamp;

import javax.swing.ImageIcon;

public abstract interface IEnemy {
	
	/*
	 * This is the IEnemy Interface. This Interface will be implemented by enemy classes
	 * 
	 * giving the ability to extend the application to have more than the 3 enemies that
	 * 
	 * are currently implemented. The methods below need to be implemented by all
	 * 
	 * classes that implement this Interface
	 */
	
	public void enterSwamp(Grid theGrid);							//method to enter the swamp
	
	public void move(Grid theGrid);									//metdod to move
	
	public void removeEnemy(Grid theGrid);							//method to remove IEnemy object
	
	public int getRowPosition(Grid theGrid);						//method to get the row position of the IEnemy object
	
	public int getColPosition(Grid theGrid);						//method to get the column position of the IEnemy object
	
	public void getUpdate(Grid theGrid);							//method to get the update from the Observable object/Ogre

	public String getType();										//method to get the IEnemy object type (Snake, Parrot, Donkey)
	
	public ImageIcon getIcon();										//method to get the IEnemy object icon (Snake, Parrot, Donkey)

}
