package getoutofmyswamp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.border.LineBorder;
import java.awt.Component;
import javax.swing.JSplitPane;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;

public class Game extends JFrame {

	//Declare local variables
	private JPanel contentPane;
	SaveLoad saveLoad = new SaveLoad();						//Create an Instance of the SaveLoad class
	private GamePlay guiGame = new GamePlay();				//Create an Instance of the GamePlay
		
	//Declare all the components
	private JPanel panel;
	private JButton btnMove;
	private JButton btnSaveExit;
	private JButton btnMainMenu;
	private JButton btnNewGame;
	private JButton btnLoadGame;
	private JButton btnNewButton;
	private JButton btnResume;
	private JButton btnStop;
	private JRadioButton Passive;
	private JRadioButton Grumpy;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel label_1;
	private JLabel label_2;
	private ImageIcon donkey = new ImageIcon(getClass().getClassLoader().getResource("donkey.png"));	//the donkey ImageIcon
	private ImageIcon snake = new ImageIcon(getClass().getClassLoader().getResource("snake.png"));		//the snake ImageIcon
	private ImageIcon parrot = new ImageIcon(getClass().getClassLoader().getResource("parrot.png"));	//the parrot ImageIcon
	private ImageIcon move = new ImageIcon(getClass().getClassLoader().getResource("move.png"));		//the move ImageIcon
	private JLabel lblNewLabel_2;
	private JLabel lblParrot;
	private JLabel lblDonkey;
	private JLabel lblEnemies;
	private JLabel lblNewLabel_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Game frame = new Game();				//instantiate the frame
					frame.setVisible(true);					//make the frame visible

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	/**
	 * Create the frame.
	 */
	public Game() {
		setTitle("Get Out Of My Swamp");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 900);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getPanel());
		contentPane.add(getBtnMove());
		contentPane.add(getBtnMainMenu());
		contentPane.add(getBtnNewGame());
		contentPane.add(getBtnLoadGame());
		contentPane.add(getBtnNewButton());
		contentPane.add(getBtnSaveExit());
		contentPane.add(getBtnResume());
		contentPane.add(getBtnStop());
		contentPane.add(getPassive());
		contentPane.add(getGrumpy());
		contentPane.add(getLblNewLabel());
		contentPane.add(getLblNewLabel_1());
		contentPane.add(getLabel_1());
		contentPane.add(getLabel_2());
		contentPane.add(getLblNewLabel_2());
		contentPane.add(getLblParrot());
		contentPane.add(getLblDonkey());
		contentPane.add(getLblEnemies());
		contentPane.add(getLblNewLabel_3());

	}
	//Create an empty panel to host the grid
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBounds(12, 69, 650, 650);
			panel.setLayout(new GridLayout(guiGame.gridSize, guiGame.gridSize, 0, 0));
		}
		return panel;
	}
	
	//Display the grid
	private void display() {
		for ( Row tempRow : guiGame.theGrid.theGrid) {
			for (Square tempSquare : tempRow.theRow) {
				String output = tempSquare.toString();
				Icon icon = (Icon) tempSquare.toIcon();
				final JLabel label = new JLabel(output);
				label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
				label.setHorizontalAlignment(JLabel.CENTER);
				label.setFont(new Font("Arial", Font.BOLD, 22));
				label.setIcon(icon);
			    panel.add(label);
			}
		}
	}
	
	//Move button for the Ogre to move	
	private JButton getBtnMove() {
		if (btnMove == null) {
			btnMove = new JButton("Move");
			btnMove.setFont(new Font("Arial", Font.BOLD, 21));
			btnMove.setForeground(Color.WHITE);
			btnMove.setBackground(Color.RED);
			btnMove.setIcon(move);
			btnMove.setVisible(false);
			btnMove.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					boolean gameOver = guiGame.nextMove();
					if(gameOver) {									//the game is over is Ogre has lost
						dispose();
						IntroGUI newIntro = new IntroGUI();			//instantiate a new IntroGUI if the game is over
						newIntro.setVisible(true);					//set the IntroGUI to visible
					} 
					else {
						//Update all the panels and the labels
						panel.removeAll();
						display();
						panel.validate();
						panel.repaint();
						lblNewLabel_1.setText("" + guiGame.hek.countDonkeys());			//count the donkeys
						label_1.setText("" + guiGame.hek.countSnakes());				//count the snakes
						label_2.setText("" + guiGame.hek.countParrots());				//count the parrots
						int enemiesSum = guiGame.hek.countParrots() + guiGame.hek.countSnakes() + guiGame.hek.countDonkeys();     //local variable 'enemiesSum' to count all the enemies
						lblNewLabel_3.setText("" + enemiesSum);								//count all the enemies
					}
				}
			});
			btnMove.setBounds(709, 293, 119, 98);
		}
		return btnMove;
	}
	
	//Button to save the current game (no game EXIT or STOP)
	private JButton getBtnSaveExit() {
		if (btnSaveExit == null) {
			btnSaveExit = new JButton("Save");
			btnSaveExit.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnSaveExit.setBounds(709, 69, 119, 31);
			btnSaveExit.setVisible(false);
			btnSaveExit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					saveLoad.saveGame(guiGame);
				}
			});
		}
		return btnSaveExit;
	}
	
	//Button to return to the main menu - includes saving of current game
	private JButton getBtnMainMenu() {
		if (btnMainMenu == null) {
			btnMainMenu = new JButton("Main Menu");
			btnMainMenu.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnMainMenu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					saveLoad.saveGame(guiGame);
					dispose(); 											//Destroy the JFrame object
					IntroGUI newIntro = new IntroGUI();					//instantiate a new IntroGUI object
					newIntro.setVisible(true);							//set the IntroGUI to visible
				}
			});
			btnMainMenu.setBounds(751, 809, 119, 31);
		}
		return btnMainMenu;
	}
	
	//Button to start a new game and show the rest of the buttons
	private JButton getBtnNewGame() {
		if (btnNewGame == null) {
			btnNewGame = new JButton("New Game");
			btnNewGame.setFont(new Font("Arial", Font.BOLD, 16));
			btnNewGame.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					guiGame = new GamePlay();							//instantiate a new GamePlay object
					//Update the panel and show all the necessary components
					display();
					panel.validate();
					panel.repaint();
					btnNewGame.setVisible(false);
					btnLoadGame.setVisible(false);
					btnMove.setVisible(true);
					btnNewButton.setVisible(true);
					btnSaveExit.setVisible(true);
					btnStop.setVisible(true);
					lblNewLabel.setVisible(true);
					Passive.setVisible(true);
					Grumpy.setVisible(true);
					lblNewLabel_2.setVisible(true);
					lblParrot.setVisible(true);
					lblDonkey.setVisible(true);
					lblNewLabel_1.setVisible(true);
					label_1.setVisible(true);
					label_2.setVisible(true);
					lblEnemies.setVisible(true);
					lblNewLabel_3.setVisible(true);
				}
			});
			btnNewGame.setBounds(145, 13, 140, 31);
		}
		return btnNewGame;
	}
	
	//Button to load the saved game
	private JButton getBtnLoadGame() {
		if (btnLoadGame == null) {
			btnLoadGame = new JButton("Load Game");
			btnLoadGame.setFont(new Font("Arial", Font.BOLD, 16));
			btnLoadGame.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					guiGame = saveLoad.loadGame();						//load a saved GamePlay object
					//Update the panel and show all the necessary components
					display();
					panel.validate();
					panel.repaint();
					btnNewGame.setVisible(false);
					btnLoadGame.setVisible(false);
					btnMove.setVisible(true);
					btnNewButton.setVisible(true);
					btnSaveExit.setVisible(true);
					btnStop.setVisible(true);
					lblNewLabel.setVisible(true);
					Passive.setVisible(true);
					Grumpy.setVisible(true);
					lblNewLabel_1.setText("" + guiGame.hek.countDonkeys());
					label_1.setText("" + guiGame.hek.countSnakes());
					label_2.setText("" + guiGame.hek.countParrots());
					lblNewLabel_1.setVisible(true);
					label_1.setVisible(true);
					label_2.setVisible(true);
					lblNewLabel_2.setVisible(true);
					lblParrot.setVisible(true);
					lblDonkey.setVisible(true);
					lblEnemies.setVisible(true);
					lblNewLabel_3.setVisible(true);
				}
			});
			btnLoadGame.setBounds(368, 13, 140, 31);
		}
		return btnLoadGame;
	}
	
	//Button to pause the game - deactivate the move button
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Pause");
			btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnNewButton.setVisible(false);
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnNewButton.setVisible(false);
					btnMove.setVisible(false);
					btnResume.setVisible(true);
					lblNewLabel.setVisible(false);
					Passive.setVisible(false);
					Grumpy.setVisible(false);

				}
			});
			btnNewButton.setBounds(709, 128, 119, 31);
		}
		return btnNewButton;
	}
	
	//Button to resume game - activate the move button
	private JButton getBtnResume() {
		if (btnResume == null) {
			btnResume = new JButton("Resume");
			btnResume.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnResume.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnNewButton.setVisible(true);
					btnMove.setVisible(true);
					btnResume.setVisible(false);
					lblNewLabel.setVisible(true);
					Passive.setVisible(true);
					Grumpy.setVisible(true);
				}
			});
			btnResume.setBounds(709, 129, 119, 31);
			btnResume.setVisible(false);
		}
		return btnResume;
	}
	
	//Button to STOP the game - includes saving of the current game
	private JButton getBtnStop() {
		if (btnStop == null) {
			btnStop = new JButton("Stop");
			btnStop.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnStop.setVisible(false);
			btnStop.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnMove.setVisible(false);
					btnStop.setVisible(false);
					btnResume.setVisible(false);
					btnNewButton.setVisible(false);
					btnSaveExit.setVisible(false);
					Passive.setVisible(false);
					Grumpy.setVisible(false);
					lblNewLabel.setVisible(false);
					btnNewGame.setVisible(true);
					btnLoadGame.setVisible(true);
					saveLoad.saveGame(guiGame);		
					panel.removeAll();
					panel.validate();
					panel.repaint();
				}
				
			});
			btnStop.setBounds(709, 185, 119, 31);
		}
		return btnStop;
	}
	
	//Radio button to activate the Passive mode of the Ogre - Only one can be selected at a time
	private JRadioButton getPassive() {
		if (Passive == null) {
			Passive = new JRadioButton("Passive");
			Passive.setForeground(Color.BLACK);
			Passive.setFont(new Font("Arial", Font.BOLD, 15));
			Passive.setBackground(Color.LIGHT_GRAY);
			Passive.setSelected(true);
			Passive.setVisible(false);
			Passive.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(Passive.isSelected()) {
						Grumpy.setSelected(false);
						guiGame.hek.setOgremood(new Passive());
						guiGame.setKillingAmount(guiGame.hek.performMood());
					}
				}
			});
			Passive.setBounds(709, 505, 119, 25);
		}
		return Passive;
	}
	
	//Radio button to activate the Grumpy mode of the Ogre - Only one can be selected at a time
	private JRadioButton getGrumpy() {
		if (Grumpy == null) {
			Grumpy = new JRadioButton("Grumpy");
			Grumpy.setForeground(Color.BLACK);
			Grumpy.setFont(new Font("Arial", Font.BOLD, 15));
			Grumpy.setBackground(Color.LIGHT_GRAY);
			Grumpy.setVisible(false);
			Grumpy.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(Grumpy.isSelected()) {
						Passive.setSelected(false);
						guiGame.hek.setOgremood(new Grumpy());
						guiGame.setKillingAmount(guiGame.hek.performMood());
					}
				}
			});
			Grumpy.setBounds(709, 535, 119, 25);
		}
		return Grumpy;
	}
	
	//Label for the Ogre mood
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Mood");
			lblNewLabel.setForeground(Color.BLACK);
			lblNewLabel.setVisible(false);
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("Arial", Font.BOLD, 16));
			lblNewLabel.setBounds(709, 465, 119, 31);
		}
		return lblNewLabel;
	}
	
	
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 16));
			lblNewLabel_1.setBounds(660, 770, 56, 16);
			lblNewLabel_1.setText("" + guiGame.hek.countDonkeys());
			lblNewLabel_1.setVisible(false);
		}
		return lblNewLabel_1;
	}
	private JLabel getLabel_1() {
		if (label_1 == null) {
			label_1 = new JLabel("0");
			label_1.setFont(new Font("Arial", Font.BOLD, 16));
			label_1.setBounds(260, 770, 56, 16);
			label_1.setText("" + guiGame.hek.countSnakes());
			label_1.setVisible(false);
		}
		return label_1;
	}
	private JLabel getLabel_2() {
		if (label_2 == null) {
			label_2 = new JLabel("0");
			label_2.setFont(new Font("Arial", Font.BOLD, 16));
			label_2.setBounds(452, 770, 56, 16);
			label_2.setText("" + guiGame.hek.countParrots());
			label_2.setVisible(false);
		}
		return label_2;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("snake");
			lblNewLabel_2.setBounds(176, 744, 70, 70);
			lblNewLabel_2.setIcon(snake);
			lblNewLabel_2.setVisible(false);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblParrot() {
		if (lblParrot == null) {
			lblParrot = new JLabel("parrot");
			lblParrot.setBounds(370, 744, 70, 70);
			lblParrot.setIcon(parrot);
			lblParrot.setVisible(false);
		}
		return lblParrot;
	}
	private JLabel getLblDonkey() {
		if (lblDonkey == null) {
			lblDonkey = new JLabel("donkey");
			lblDonkey.setBounds(584, 744, 70, 70);
			lblDonkey.setIcon(donkey);
			lblDonkey.setVisible(false);
		}
		return lblDonkey;
	}
	private JLabel getLblEnemies() {
		if (lblEnemies == null) {
			lblEnemies = new JLabel("Enemies:");
			lblEnemies.setFont(new Font("Arial", Font.BOLD, 16));
			lblEnemies.setBounds(12, 771, 77, 16);
			lblEnemies.setVisible(false);
		}
		return lblEnemies;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("0");
			lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 16));
			lblNewLabel_3.setBounds(92, 771, 56, 16);
			int sum = guiGame.hek.countParrots() + guiGame.hek.countSnakes() + guiGame.hek.countDonkeys();
			lblNewLabel_3.setText("" + sum);
			lblNewLabel_3.setVisible(false);
		}
		return lblNewLabel_3;
	}
}
