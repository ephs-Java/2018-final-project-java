package Hangman;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

import java.awt.Color;
import java.awt.Label;
import javax.swing.JComboBox;

public class UI extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */

	private JPanel contentPane;
	private JButton bStart;
	private JButton bQuit;
	private JLabel lTitle;
	private JButton btnNewButton;
	private JPanel pStart;
	private JPanel pRules;
	private JButton btnBack;
	private JPanel pGame;
	private Hangman h;
	private JButton[] buttons;
	private JButton bBack;
	private JPanel bpanel;
	private JLabel hangingImage;
	private Label progress;
	private JLabel word;
	private JButton playagain;
	private String filename;
	private JComboBox comboBox;

	private String name;
	private int numCorrect;
	private JScrollPane scrollPane;
	private JTextPane txtpnTheWordTo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI frame = new UI();
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws IOException
	 */
	public UI() throws IOException {
		contentPane = new JPanel();
		pStart = new JPanel();
		bStart = new JButton("Start");
		lTitle = new JLabel("Hangman\n");
		bQuit = new JButton("Quit");
		playagain = new JButton("Play again?");
		btnNewButton = new JButton("Rules");
		pGame = new JPanel();
		String[] items = { "words.txt", "countries.txt", "computer.txt", "food.txt", "school.txt" , "out.txt" };
		comboBox = new JComboBox(items);
		word = new JLabel("");
		bpanel = new JPanel();
		bBack = new JButton("Back");
		hangingImage = new JLabel();
		progress = new Label();
		pRules = new JPanel();
		btnBack = new JButton("Back");
		scrollPane = new JScrollPane();
		txtpnTheWordTo = new JTextPane();
		initContainers();
		actions();
	}

	/**
	 * Adds to leaderboard the information obtained from the game.
	 */

	public void makeButtons() {
		// TODO Auto-generated method stub
		int j = 65;

		for (int i = 0; i < buttons.length; i++) {
			char c = (char) j;
			String letter = "" + c;

			buttons[i] = new JButton(letter);

			bpanel.add(buttons[i]);
			j++;

		}

		bpanel.setVisible(true);
		for (int i = 0; i < buttons.length; i++) {
			final int index = i;
			buttons[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (h.checkLetter(buttons[index].getText()))
						buttons[index].setForeground(Color.GREEN);
					else
						buttons[index].setVisible(false);

					progress.setText(h.getProgress());
					hangingImage.setIcon(h.getImage());
					if (h.getLives() == 0) {
						bpanel.setVisible(false);
						word.setText("The word was: " + h.getWord());
						playagain.setVisible(true);
					} else if (h.wordEquals()) {
						bpanel.setVisible(false);
						playagain.setVisible(true);
						try {
							h.playSound("img/win.wav");
						} catch (LineUnavailableException | UnsupportedAudioFileException | IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			});

		}
	}

	public void initContainers() throws IOException {
		filename = "words.txt";
		buttons = new JButton[26];
		setTitle("Hangman");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		/*
		 * Creates the start JPanel and adds components.
		 */

		pStart.setBackground(new Color(25, 25, 112));
		pStart.setBounds(0, 0, 900, 600);
		contentPane.add(pStart);
		pStart.setLayout(null);
		
		bStart.setFont(new Font("Copperplate", Font.BOLD, 18));
		bStart.setBounds(300, 147, 300, 100);
		pStart.add(bStart);

		lTitle.setForeground(new Color(255, 255, 255));
		lTitle.setBounds(175, 6, 565, 139);
		pStart.add(lTitle);
		lTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lTitle.setFont(new Font("Wawati SC", Font.BOLD | Font.ITALIC, 99));

		bQuit.setFont(new Font("Copperplate", Font.BOLD, 16));
		bQuit.setBounds(300, 403, 300, 100);
		pStart.add(bQuit);

		btnNewButton.setFont(new Font("Copperplate", Font.BOLD, 16));
		btnNewButton.setBounds(300, 280, 300, 100);
		pStart.add(btnNewButton);

		comboBox.setBounds(365, 246, 176, 27);
		pStart.add(comboBox);

		pGame.setBackground(new Color(0, 128, 128));
		pGame.setEnabled(false);
		pGame.setBounds(0, 0, 900, 600);
		contentPane.add(pGame);
		pGame.setLayout(null);

		playagain.setBounds(373, 450, 117, 29);
		pGame.add(playagain);
		playagain.setVisible(false);

		word.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		word.setBounds(373, 400, 414, 61);
		pGame.add(word);

		bpanel.setBackground(new Color(0, 128, 128));
		bpanel.setBounds(100, 416, 703, 270);
		pGame.add(bpanel);

		bBack.setFont(new Font("Copperplate", Font.BOLD, 16));
		bBack.setBounds(710, 37, 173, 61);
		pGame.add(bBack);
		pGame.setVisible(false);

		hangingImage.setBounds(150, 37, 687, 315);
		pGame.add(hangingImage);

		progress.setAlignment(Label.CENTER);
		progress.setFont(new Font("Comic Sans MS", Font.PLAIN, 40));
		progress.setBounds(10, 332, 873, 76);
		pGame.add(progress);
		/*
		 * Creates JPanel rules and creates buttons and text box.
		 */

		pRules.setBackground(new Color(123, 104, 238));
		pRules.setBounds(0, 0, 900, 600);
		contentPane.add(pRules);
		pRules.setLayout(null);

		btnBack.setFont(new Font("Copperplate", Font.BOLD, 14));
		btnBack.setBounds(349, 420, 190, 91);
		pRules.add(btnBack);

		scrollPane.setBounds(6, 6, 888, 370);
		pRules.add(scrollPane);

		txtpnTheWordTo.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		txtpnTheWordTo.setEditable(false);
		txtpnTheWordTo.setText(
				"The word to guess is represented by a row of dashes, representing each letter of the word. If the guessing player suggests a letter which occurs in the word, the other player writes it in all its correct positions. If the suggested letter or number does not occur in the word, the other player draws one element of a hanged man stick figure as a tally mark.\nThe player guessing the word may, at any time, attempt to guess the whole word. If the word is correct, the game is over and the guesser wins. Otherwise, the other player may choose to penalize the guesser by adding an element to the diagram. On the other hand, if the other player makes enough incorrect guesses to allow his opponent to complete the diagram, the game is also over, this time with the guesser losing. However, the guesser can also win by guessing all the letters or numbers that appears in the word, thereby completing the word, before the diagram is completed.\nIn our version of Hangman, you want to accumulate the most points as possible. Make sure to watch the Eclipse Counsole for in-game messages!\n\nGood Luck!");
		scrollPane.setViewportView(txtpnTheWordTo);
		pRules.setVisible(false);
		makeButtons();

	}

	public void updateLabel(String c) {
		filename = c;
	}

	public void actions() {
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox<String> combo = (JComboBox<String>) e.getSource();
				String choice = (String) combo.getSelectedItem();
				updateLabel(choice);
			}
		});
		bQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		bStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pGame.setVisible(true);
				pStart.setVisible(false);
				startGame();

			}

		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pStart.setVisible(false);
				pRules.setVisible(true);
			}
		});
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pStart.setVisible(true);
				pRules.setVisible(false);
			}
		});

		bBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pStart.setVisible(true);
				pRules.setVisible(false);
				pGame.setVisible(false);
			}
		});
		playagain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startGame();
			}
		});

	}

	public void startGame() {
		h = new Hangman(filename);
		hangingImage.setIcon(h.getImage());
		progress.setText(h.getProgress());
		bpanel.setVisible(true);
		word.setText("");
		for (JButton b : buttons) {
			b.setForeground(Color.BLACK);
			b.setVisible(true);
		}
		playagain.setVisible(false);
	}

	
}
