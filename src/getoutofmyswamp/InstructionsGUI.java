package getoutofmyswamp;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.SystemColor;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InstructionsGUI extends JFrame {

	//Declare local variables
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTextArea txtrThisIsA;
	private JTextArea txtrTheOgre;
	private JTextArea txtrTheEnemies;
	private JSeparator separator;
	private JSeparator separator_1;
	private JTextArea txtrConflictEvery;
	private JTextArea txtrOgreMood;
	private JLabel lblLetsPlay;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InstructionsGUI frame = new InstructionsGUI();				//instantiate the frame
					frame.setVisible(true);										//set the frame to visible
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InstructionsGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblNewLabel());
		contentPane.add(getTxtrThisIsA());
		contentPane.add(getTxtrTheOgre());
		contentPane.add(getTxtrTheEnemies());
		contentPane.add(getSeparator());
		contentPane.add(getSeparator_1());
		contentPane.add(getTxtrConflictEvery());
		contentPane.add(getTextArea_1());
		contentPane.add(getLblLetsPlay());
		contentPane.add(getBtnNewButton());
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Welcome to the \"Get out of my swamp\" Game");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
			lblNewLabel.setBounds(74, 40, 734, 112);
		}
		return lblNewLabel;
	}
	private JTextArea getTxtrThisIsA() {
		if (txtrThisIsA == null) {
			txtrThisIsA = new JTextArea();
			txtrThisIsA.setBackground(UIManager.getColor("Button.background"));
			txtrThisIsA.setFont(new Font("Arial", Font.PLAIN, 18));
			txtrThisIsA.setLineWrap(true);
			txtrThisIsA.setText("This is a game about surviving and protecting your home. In this game, you...the Ogre...or \"Hek\" if you want, wander around your swamp. Your mission is to protect your home from various enemies that enter your swamp from the top left corner. ");
			txtrThisIsA.setBounds(102, 153, 698, 112);
		}
		return txtrThisIsA;
	}
	private JTextArea getTxtrTheOgre() {
		if (txtrTheOgre == null) {
			txtrTheOgre = new JTextArea();
			txtrTheOgre.setBackground(UIManager.getColor("Button.background"));
			txtrTheOgre.setFont(new Font("Arial", Font.PLAIN, 16));
			txtrTheOgre.setLineWrap(true);
			txtrTheOgre.setText("1.  The Ogre: Press the move button to move the Ogre from one square to another - only one square at a time. The Ogre moves randomly to neighbouring squares and is trying to find enemies in his home.");
			txtrTheOgre.setBounds(96, 281, 688, 90);
		}
		return txtrTheOgre;
	}
	private JTextArea getTxtrTheEnemies() {
		if (txtrTheEnemies == null) {
			txtrTheEnemies = new JTextArea();
			txtrTheEnemies.setText("2. The Enemies. The enemies are the Snake, the Parrot and the Donkey. There is one out of three  chances that an enemy will enter your swamp. The kind of the Enemy is random, but they all behave the same. They randomly move to a neighbouring square of their just right after you move. Chance  and time will tell if you meet one, two or more...");
			txtrTheEnemies.setLineWrap(true);
			txtrTheEnemies.setFont(new Font("Arial", Font.PLAIN, 16));
			txtrTheEnemies.setBackground(UIManager.getColor("Button.background"));
			txtrTheEnemies.setBounds(96, 371, 688, 90);
		}
		return txtrTheEnemies;
	}
	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setBounds(96, 40, 688, 10);
		}
		return separator;
	}
	private JSeparator getSeparator_1() {
		if (separator_1 == null) {
			separator_1 = new JSeparator();
			separator_1.setBounds(96, 804, 688, 10);
		}
		return separator_1;
	}
	private JTextArea getTxtrConflictEvery() {
		if (txtrConflictEvery == null) {
			txtrConflictEvery = new JTextArea();
			txtrConflictEvery.setText("3. Conflict: Every time the Ogre moves, the enemies move too. The new Ogre sqaure should be      clear, thus the Ogre kills an enemy if he finds it there. If two enemies happen to be there, unfortunatel-y, the Ogre gets killed and the game ends. It's a matter of chance, but don't worry, this game never stops, play as many times as you like.");
			txtrConflictEvery.setLineWrap(true);
			txtrConflictEvery.setFont(new Font("Arial", Font.PLAIN, 16));
			txtrConflictEvery.setBackground(UIManager.getColor("Button.background"));
			txtrConflictEvery.setBounds(96, 483, 688, 90);
		}
		return txtrConflictEvery;
	}
	private JTextArea getTextArea_1() {
		if (txtrOgreMood == null) {
			txtrOgreMood = new JTextArea();
			txtrOgreMood.setText("3. Ogre mood: Tired of two enemies killing you all the time? Playing and you're feeling that you are  surrounded by too many enemies? Simply select the Grumpy mood of the Ogre and now it takes 3    enemies to kill you. Make the game easier for you and make it last longer. Remember, the Game   always starts with the mood of the Ogre to be Passive!");
			txtrOgreMood.setLineWrap(true);
			txtrOgreMood.setFont(new Font("Arial", Font.PLAIN, 16));
			txtrOgreMood.setBackground(UIManager.getColor("Button.background"));
			txtrOgreMood.setBounds(96, 592, 688, 90);
		}
		return txtrOgreMood;
	}
	private JLabel getLblLetsPlay() {
		if (lblLetsPlay == null) {
			lblLetsPlay = new JLabel("Let's play!");
			lblLetsPlay.setHorizontalAlignment(SwingConstants.CENTER);
			lblLetsPlay.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
			lblLetsPlay.setBounds(74, 669, 734, 112);
		}
		return lblLetsPlay;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Main menu");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose(); //Destroy the JFrame object
					IntroGUI newIntro = new IntroGUI();
					newIntro.setVisible(true);
				}
			});
			btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnNewButton.setBounds(751, 809, 119, 31);
		}
		return btnNewButton;
	}
}
