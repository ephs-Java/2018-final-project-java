package Hangman;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SwingConstants;

public class UI extends JFrame {
	/**
	 * 
	 */
	
	private JPanel contentPane;
	private JButton bStart;
	private JButton bQuit;
	private JLabel lTitle;
	private JPanel rulesPane;
	private JButton btnNewButton;

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
		
		initContainers();
		actions();
	}

	public void initContainers() {
		setTitle("Hangman");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		rulesPane = new JPanel();
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lTitle = new JLabel("Hangman\n");
		lTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lTitle.setBounds(0, 6, 444, 117);
		lTitle.setFont(new Font("Lucida Grande", Font.PLAIN, 60));
		contentPane.add(lTitle);
		bStart = new JButton("Start");
		bStart.setBounds(58, 135, 150, 79);
		contentPane.add(bStart);
		bQuit = new JButton("Quit");
		bQuit.setBounds(360, 0, 84, 35);
		contentPane.add(bQuit);
		
		btnNewButton = new JButton("Rules");
		
		btnNewButton.setBounds(234, 135, 150, 79);
		contentPane.add(btnNewButton);
	}

	public void actions() {
		bQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		bStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
	}
}
