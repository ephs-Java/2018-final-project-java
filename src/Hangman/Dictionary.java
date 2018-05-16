package Hangman;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Dictionary {
	
	private String filename = "words.txt";
	private ArrayList<String> words;
	
	public Dictionary() throws FileNotFoundException{
		
		@SuppressWarnings("resource")
		Scanner f = new Scanner(new File(filename));
		words = new ArrayList<String>();
		while (f.hasNextLine()) {
			
				words.add(f.nextLine());
				
			}
			
		
		
	}
	
	public String getWord(){
		return this.words.get((int) (Math.random() * this.words.size()));
	}
	
	
}

