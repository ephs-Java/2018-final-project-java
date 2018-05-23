package Hangman;

import javax.swing.ImageIcon;

public class Hangman {
	private String name;
	private int score;
	private String word;
	private String progress;
	private int lives;
	private Dictionary d;
	private ImageIcon[] images;
	public Hangman(){

		this.lives = 5;
		this.progress = "";
		this.newWord();
		this.images = new ImageIcon[6];
		for(int i = images.length-1; i>= 0 ; i--){
			images[i] = new ImageIcon("img/" + i + ".png");
		}

}

	public void newWord(){
		// makes a dictionary and creates the censored word
		this.d = new Dictionary();
		this.word = this.d.getWord();
		for (int i = 0; i < this.word.length(); i++) {

			this.progress += "_";
			
		}

	}

	public void checkLetter(String letter) {
		this.word = this.word.toUpperCase();
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
					
					
				}  else{
					// adds the char to the new string if it has already been
					// found
					n += this.word.charAt(i);

				}
			}
	
		}

	

		this.progress = n;
		
		// records score
		if (count == 0) {
			lives--;
		}
		
		
		
		
	}
	public String checkStatus(){
		if(lives ==  0){
			return "You lost!";
		}else if(this.word.equals(this.progress)){
			return "You won!";
		}else{
			return "";
		}
		
		
		
	}


	public String getWord(){
		return word;
	}

	public ImageIcon[] getImages() {
		return images;
	}
	public String getProgress(){
		return progress;
	}
	public ImageIcon getImage(){
		return images[lives];
	}

	
}
