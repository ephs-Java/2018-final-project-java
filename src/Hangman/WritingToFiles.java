package Hangman;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class WritingToFiles {

	public static void main(String[] args) throws IOException {
		String[] solved = new String[3];
		String[] names = new String[3];
		writeFile(solved);
	}

	public static void writeFile(String[] ranks) throws IOException {
		File flead = new File("HangmanLeaderboard.txt");
		FileOutputStream fos = new FileOutputStream(flead);

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
		
		for(int i = 0; i < ranks.length; i++){
			bw.write(ranks[i]);
			bw.newLine();
		}

		bw.close();
	}
}