package getoutofmyswamp;

import java.io.Serializable;
import java.util.ArrayList;

public class Row implements Serializable {
	
	//Variables and collections
	private int number;
	private int size;
	ArrayList <Square> theRow = new ArrayList <Square> ();
	
	
	//Constructor (create a collection of 'size' Squares for a row)
	public Row(int number, int size) {
		Square tempSquare;
		setNumber(number);
		for (int loop = 1; loop <= size;loop++) {
			tempSquare = new Square(loop);
			this.theRow.add(tempSquare);						
		}
	}
	
	
	///////////////////////////////////////Getters and Setters//////////////////////////////////////////
	public int getNumber () {
		return this.number;
	}
	
	public void setNumber(int number) {
		this.number = number;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	//end getters and setters

}
