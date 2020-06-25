package getoutofmyswamp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.swing.JOptionPane;

public class SaveLoad {
	
	private static final String fileName = "data.bin";
	
	//Method to save the current status of the game
	public static void saveGame(Serializable object) {
		try {
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(fileName));
			os.writeObject(object);
			os.close();
			JOptionPane.showMessageDialog(null, "The game status was saved successfully");
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "The game was NOT saved, file not found", "Warning", 2);
			e.printStackTrace();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "The game was NOT saved", "Warning", 2);
			e.printStackTrace();
		}// end try
	}//end saveGame
			
	//Method to load a current game previously saved (returns a GamePlay type object)
	public static GamePlay loadGame() {
		try {
			ObjectInputStream is = new ObjectInputStream(new FileInputStream(fileName));
			GamePlay loaded = (GamePlay) is.readObject();
			is.close();
			JOptionPane.showMessageDialog(null, "The game was loaded successfully");
			return loaded;
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "The game was NOT loaded, file not found", "Warning", 2);
			e.printStackTrace();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "The game was NOT loaded", "Warning", 2);
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "The game was NOT loaded", "Warning", 2);
			e.printStackTrace();
		}//end try
		return null;	//returns null if there is no game to load
	}//end loadGame

}
