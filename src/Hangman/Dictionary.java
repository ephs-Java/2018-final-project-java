package Hangman;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Dictionary {
	
	//private String filename = "computer.txt";
	private ArrayList<String> words;
	
	public Dictionary(String filename){
		
		Scanner f;
		try {
			f = new Scanner(new File(filename));
			words = new ArrayList<String>();
			while (f.hasNextLine()) {
				
					words.add(f.nextLine());
					
				}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
		
		
	}
	
	public String getWord(){
		return this.words.get((int) (Math.random() * this.words.size()));
	}
	
	
}

