package Hangman;

import java.awt.BorderLayout;
import java.io.FileNotFoundException;

import javax.swing.*;

public class Runner {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Hangman h = new Hangman();
		System.out.println(h.getWord());
		
		JFrame f = new JFrame("test");
		
		f.setSize(300,300);
		
		JLabel l = new JLabel("hello");
		JPanel contentPane = new JPanel(new BorderLayout());
		contentPane.add(l, BorderLayout.LINE_START);
		f.setVisible(true);
		f.setContentPane(contentPane);
	}

}
