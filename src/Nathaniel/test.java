package Nathaniel;


import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame f = new JFrame("test");
		
		f.setSize(300,300);
		JButton button1 = new JButton("Button 1");
        JButton button2 = new JButton("Button 2");
        
        f.getContentPane().add(BorderLayout.LINE_START, button1);
        f.getContentPane().add(BorderLayout.CENTER, button2);
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a) {
            System.out.println("button1");
            }
            
          });
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a) {
            System.out.println("button2");
            }
            
          });
        f.setVisible(true);
	}

}
