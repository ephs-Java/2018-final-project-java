package Hangman;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Hangman {
	private String name;
	private int score;
	private String word;
	private String progress;
	private int misses;
	private Scanner k = new Scanner(System.in);
	private Dictionary d;

	public Hangman() throws FileNotFoundException {

		this.misses = 0;
		this.progress = "";
		this.newWord();

	}

	public void newWord() throws FileNotFoundException {
		// makes a dictionary and creates the censored word
		this.d = new Dictionary();
		this.word = this.d.getWord();
		for (int i = 0; i < this.word.length(); i++) {

			this.progress += "_";
		}

	}

	public boolean checkLetter(String letter) {
		int count = 0;
		String n = "";
		for (int i = 0; i < this.word.length(); i++) {
			if (this.word.charAt(i) == letter.charAt(0)) {
				// adds the correct letter to the new progress
				n += this.word.charAt(i);
				count++;

			} else {

				if (this.progress.charAt(i) == '_') {
					// if they missed add a _ to progress
					n += "_";

				} else {
					// adds the char to the new string if it has already been
					// found
					n += this.word.charAt(i);

				}
			}

		}

		this.progress = n;
		System.out.println(this.progress);
		// records score
		if (count > 0) {
			System.out.println("You found a letter!");
			return true;
		} else {
			misses++;
			System.out.println("You missed!");

			return false;

		}

	}

	public String getWord(){
		return word;
	}

	
}
