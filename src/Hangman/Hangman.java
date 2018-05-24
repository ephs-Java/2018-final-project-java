package Hangman;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;

public class Hangman {
	private String word;
	private String progress;
	private int lives;
	private Dictionary d;
	private ImageIcon[] images;
	private ImageIcon win;
	private String brokenword;

	public Hangman() {

		this.lives = 6;
		this.progress = "";
		this.newWord();
		this.word = this.word.toUpperCase();
		this.brokenword = "";
		for (int i = 0; i < this.word.length(); i++) {
			this.brokenword += this.word.charAt(i) + " ";
		}
		this.images = new ImageIcon[7];
		for (int i = images.length - 1; i >= 0; i--) {
			images[i] = new ImageIcon("img/" + i + ".png");
		}
		this.win = new ImageIcon("img/win.png");

	}

	public void newWord() {
		// makes a dictionary and creates the censored word
		this.d = new Dictionary();
		this.word = this.d.getWord();
		for (int i = 0; i < this.word.length(); i++) {
			if (this.word.charAt(i) == ' ')
				this.progress += "  ";
			else
				;
			this.progress += "_ ";

		}

	}

	public boolean checkLetter(String letter){

		int count = 0;

		String n = "";
		for (int i = 0; i < brokenword.length(); i++) {
			if (brokenword.charAt(i) == letter.charAt(0)) {
				// adds the correct letter to the new progress
				n += brokenword.charAt(i);
				count++;

			} else {

				if (this.progress.charAt(i) == '_') {
					// if they missed add a _ to progress
					n += "_";

				} else {
					// adds the char to the new string if it has already been
					// found
					n += brokenword.charAt(i);

				}
			}

		}

		this.progress = n;

		// records score
		if (count == 0){
			lives--;
			
			try {
				playSound("img/no.wav");
			} catch (LineUnavailableException | UnsupportedAudioFileException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}else{
			return true;
		}

	}

	public int getLives() {
		return lives;
	}

	public boolean wordEquals() {
		return this.brokenword.equals(this.progress);
	}

	public String getWord() {
		return word;
	}

	public ImageIcon[] getImages() {
		return images;
	}

	public String getProgress() {
		return progress;
	}

	public ImageIcon getImage() {
		if (wordEquals())
			return win;
		return images[lives];
	}
	public void playSound(String file)  throws LineUnavailableException, UnsupportedAudioFileException, IOException{
		File soundFile = new File(file);
		AudioInputStream input = AudioSystem.getAudioInputStream(soundFile);
		Clip clip = AudioSystem.getClip();
		clip.open(input);
		clip.start();
	}

}
