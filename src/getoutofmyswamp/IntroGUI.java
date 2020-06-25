package getoutofmyswamp;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IntroGUI extends JFrame {

	//Declare local variables
	private JPanel contentPane;
	private JLabel lblSoftwareDevelopment;
	private JLabel lblgetOutOf;
	private JLabel lblNewLabel;
	private JButton btnNewButton;
	private ImageIcon image = new ImageIcon(getClass().getClassLoader().getResource("ogre.gif"));   //the ogre image
	static GamePlay currentGame;
	SaveLoad saveLoad = new SaveLoad();
	private JButton btnInstructions;
	private JLabel label;
	private JButton button_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IntroGUI frame = new IntroGUI();					//instantiate the new frame
					frame.setVisible(true);								//make the fram visible
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public IntroGUI() {
		setTitle("Intro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblSoftwareDevelopment());
		contentPane.add(getLblgetOutOf());
		contentPane.add(getLblNewLabel());
		contentPane.add(getBtnNewButton());
		contentPane.add(getBtnInstructions());
		contentPane.add(getLabel());
		contentPane.add(getButton_1());
	}
	
	//////////////////////////////////////////////// Labels ///////////////////////////////////////////////////////////////
	
	private JLabel getLblSoftwareDevelopment() {
		if (lblSoftwareDevelopment == null) {
			lblSoftwareDevelopment = new JLabel("Software Development 2 Coursework (SET11103)");
			lblSoftwareDevelopment.setFont(new Font("Arial", Font.BOLD, 16));
			lblSoftwareDevelopment.setHorizontalAlignment(SwingConstants.CENTER);
			lblSoftwareDevelopment.setBounds(139, 13, 621, 16);
		}
		return lblSoftwareDevelopment;
	}
	private JLabel getLblgetOutOf() {
		if (lblgetOutOf == null) {
			lblgetOutOf = new JLabel("\"Get out of my swamp\"");
			lblgetOutOf.setFont(new Font("Arial", Font.BOLD, 30));
			lblgetOutOf.setHorizontalAlignment(SwingConstants.CENTER);
			lblgetOutOf.setBounds(250, 42, 398, 36);
		}
		return lblgetOutOf;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("That's one mean looking coursework!");
			lblNewLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(279, 103, 340, 16);
		}
		return lblNewLabel;
	}
	
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("Ogre");
			label.setBounds(310, 132, 283, 466);
			label.setIcon(image);
		}
		return label;
	}
	
	//////////////////////////////////////////////// Buttons ///////////////////////////////////////////////////////////////
	
	//Enter Game button to create a new Game GUI instance
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Enter Game");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					IntroGUI.this.dispose();						//close the current window
					Game newGame = new Game();						//create another GUI object
					newGame.setVisible(true);						//set the new window/class to visible		
				}
			});
			btnNewButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
			btnNewButton.setBounds(64, 687, 201, 36);
		}
		return btnNewButton;
	}
	
	//Instructions button to create a new InstructionsGUI object
	private JButton getBtnInstructions() {
		if (btnInstructions == null) {
			btnInstructions = new JButton("Instructions");
			btnInstructions.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();																//close the current window
					InstructionsGUI newInstructions = new InstructionsGUI();				//Create a new InstructionsGUI object
					newInstructions.setVisible(true);										//set the new window/class to visible
				}
			});
			btnInstructions.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
			btnInstructions.setBounds(330, 687, 218, 36);
		}
		return btnInstructions;
	}

	//Exit button to terminate the application
	private JButton getButton_1() {
		if (button_1 == null) {
			button_1 = new JButton("Exit");
			button_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
			});
			button_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
			button_1.setBounds(613, 687, 218, 36);
		}
		return button_1;
	}
}
