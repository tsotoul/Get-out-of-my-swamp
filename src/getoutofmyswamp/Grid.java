package getoutofmyswamp;

import java.io.Serializable;
import java.util.ArrayList;

public class Grid implements Serializable{
	
	//Variables and collections
	private int number;
	private int size;
	ArrayList <Row> theGrid = new ArrayList <Row> ();
	
	//Constructor (create a collection of 'size' rows in the Grid)
	public Grid(int size) {
		Row tempRow;
		for (int loop = 1;loop<=size;loop++) {
			tempRow = new Row(loop, size);
			this.theGrid.add(tempRow);
		}
	}//end constructor

	
	/////////////////////////////////////Getters and setters///////////////////////////////////////
	
	public int getNumber () {
		return this.number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	//end getters and setters
}
