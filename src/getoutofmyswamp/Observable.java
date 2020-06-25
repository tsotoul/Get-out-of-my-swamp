package getoutofmyswamp;

public interface Observable {
	
	/*
	 * This is the Observable Interface. It will be implemented by the Ogre
	 * and will implement the methods below
	 */
	
	public void addNewEnemy(IEnemy e);					//method to add new IEnemy objects
	public void removeEnemy(IEnemy e);					//method to remove IEnemy objects
	public void sendUpdate(Grid theGrid);				//method to send Update / call the getUpdate() method of every IEnemy object

}
