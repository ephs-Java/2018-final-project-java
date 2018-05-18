package Hangman;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import java.awt.Toolkit;

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
	private JLabel lblNewLabel;
	private JButton btnNewButton_1;
	private Hangman h;
	private JLabel lblNewLabel_1;

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
	 */
	public UI() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("/Users/90303054/git/2018-final-project-java/img/15 - ZfSFtqk.png"));

		initContainers();
		actions();
	}

	public void initContainers() {
		h = new Hangman();
		setTitle("Hangman");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);

		pGame = new JPanel();
		pGame.setEnabled(false);
		pGame.setBounds(0, 0, 450, 278);
		contentPane.add(pGame);
		pGame.setLayout(null);

		btnNewButton_1 = new JButton("Make word");

		btnNewButton_1.setBounds(151, 176, 117, 29);
		pGame.add(btnNewButton_1);

		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(165, 77, 202, 16);
		pGame.add(lblNewLabel_1);

		pGame.setVisible(false);

		pStart = new JPanel();
		pStart.setBounds(0, 0, 450, 278);
		contentPane.add(pStart);
		pStart.setLayout(null);
		lTitle = new JLabel("Hangman\n");
		lTitle.setBounds(73, 6, 296, 71);
		pStart.add(lTitle);
		lTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lTitle.setFont(new Font("Lucida Grande", Font.PLAIN, 60));
		bStart = new JButton("Start");
		bStart.setBounds(173, 80, 75, 29);
		pStart.add(bStart);
		bQuit = new JButton("Quit");
		bQuit.setBounds(173, 148, 75, 29);
		pStart.add(bQuit);

		btnNewButton = new JButton("Rules");
		btnNewButton.setBounds(173, 115, 75, 29);
		pStart.add(btnNewButton);

		pRules = new JPanel();
		pRules.setEnabled(false);
		pRules.setBounds(0, 0, 450, 278);
		contentPane.add(pRules);
		pRules.setLayout(null);

		btnBack = new JButton("Back");

		btnBack.setBounds(155, 243, 117, 29);
		pRules.add(btnBack);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 6, 438, 237);
		pRules.add(scrollPane);

		JTextPane txtpnTheWordTo = new JTextPane();
		txtpnTheWordTo.setEditable(false);
		txtpnTheWordTo.setText(
				"The word to guess is represented by a row of dashes, representing each letter of the word. If the guessing player suggests a letter which occurs in the word, the other player writes it in all its correct positions. If the suggested letter or number does not occur in the word, the other player draws one element of a hanged man stick figure as a tally mark.\nThe player guessing the word may, at any time, attempt to guess the whole word. If the word is correct, the game is over and the guesser wins. Otherwise, the other player may choose to penalize the guesser by adding an element to the diagram. On the other hand, if the other player makes enough incorrect guesses to allow his opponent to complete the diagram, the game is also over, this time with the guesser losing. However, the guesser can also win by guessing all the letters or numbers that appears in the word, thereby completing the word, before the diagram is completed.\n");
		scrollPane.setViewportView(txtpnTheWordTo);
		pRules.setVisible(false);
	}

	public void actions() {
		bQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		bStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pGame.setVisible(true);
				pStart.setVisible(false);

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
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				h.newWord();
				lblNewLabel_1.setText(h.getWord());
			}
		});

	}
}
