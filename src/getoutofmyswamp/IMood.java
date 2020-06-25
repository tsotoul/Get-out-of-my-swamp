package getoutofmyswamp;

public interface IMood {
	
	/*
	 * This is the IMood Interface. This Interface will be implemented by the Ogre class
	 * 
	 * giving the ability to extend the application to have more than the one moods.
	 * 
	 * The method below need to be implemented by the Ogre and this Interface will be implemented by two
	 * 
	 * classes, Passive and Grumpy, each returning a killingAmount integer defining how many enemies
	 * 
	 * the Ogre can kill in a Square
	 */
	
	public int mood();

}
