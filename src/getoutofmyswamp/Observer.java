package getoutofmyswamp;

public interface Observer {
	
	/*
	 * This is the Observer Interface. It will be implemented by every IEnemy
	 * and every IEnemy will implement the method below
	 */

	public void getUpdate(Grid theGrid);
}
