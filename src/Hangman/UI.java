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
	private JButton btnNewButton;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblNewLabel;

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
		
		
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 450, 278);
		contentPane.add(panel);
		panel.setLayout(null);
		lTitle = new JLabel("Hangman\n");
		lTitle.setBounds(79, 6, 296, 71);
		panel.add(lTitle);
		lTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lTitle.setFont(new Font("Lucida Grande", Font.PLAIN, 60));
		bStart = new JButton("Start");
		bStart.setBounds(173, 80, 75, 29);
		panel.add(bStart);
		bQuit = new JButton("Quit");
		bQuit.setBounds(173, 148, 75, 29);
		panel.add(bQuit);
		
		btnNewButton = new JButton("Rules");
		btnNewButton.setBounds(170, 115, 78, 29);
		panel.add(btnNewButton);
		
		panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 450, 278);
		contentPane.add(panel_1);
		
		lblNewLabel = new JLabel("New label");
		panel_1.add(lblNewLabel);
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
				panel.setVisible(false);
				panel_1.setVisible(true);
			}
		});
		
	}
}
