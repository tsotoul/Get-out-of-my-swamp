package getoutofmyswamp;

import java.io.Serializable;

public class Grumpy implements IMood, Serializable{
	
	/*
	 * Class that implements the IMood interface and returns an integer 
	 * representing how many enemies an Ogre can kill in a Square, any enemy 
	 * number higher that this, gets the Ogre killed
	 */

	@Override
	public int mood() {
		return 2;
	}

}
