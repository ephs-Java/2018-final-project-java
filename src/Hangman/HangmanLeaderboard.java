package Hangman;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class HangmanLeaderboard {
	
	private String player;
	private int solved;

	public HangmanLeaderboard(String player, int solved) {
		this.player = player;
		this.solved = solved;
	}

	/*
	 * Takes the game information and prepares the lines to be written to disk.
	 */
	
	public ArrayList<String> convertToArrayList() {
		ArrayList<String> lead = new ArrayList<String>();

		for (int i = 0; i < lead.size(); i++) {
			lead.add(i, this.solved + "|" + this.player);
		}
		return lead;
	}
	
	/*
	 * Writes the file to disk to store permanently.
	 */
	public void writeFile(ArrayList<String> ranks) throws IOException {
		File flead = new File("HangmanLeaderboard.txt");
		FileOutputStream fos = new FileOutputStream(flead);

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

		for (int i = 0; i < ranks.size(); i++) {
			bw.write(ranks.get(i));
			bw.newLine();
		}

		bw.close();
	}

	/*
	 * Reads the leaderboard text file and loads into an ArrayList.
	 */
	public ArrayList<String> readFile(String theFileName) throws IOException {
		// read in the file
		Scanner input = new Scanner(new File(theFileName));

		ArrayList<String> lead = new ArrayList<String>();

		// read in the file, one line at a time
		while (input.hasNextLine()) {
			String line = input.nextLine();
			lead.add(line);
		}
		return lead;
	}

	/*
	 * iterate through the ArrayList of data and print it nicely after parsing it.
	 */
	public void printArrayList(ArrayList<String> lead) {
		System.out.println("\nThe current game leaderboard is:");
		System.out.println("- - - - - - - - -");
		for (int i = 0; i < lead.size(); i++) {
			displayLeader(lead.get(i));
		}
	}

	/*
	 * parse data being stored as the high "score" and that player's name
	 * separated by a pipe "|".
	 */
	private void displayLeader(String line) {
		int pipePlace = line.indexOf("|");
		String solved = line.substring(0, pipePlace);
		String player = line.substring(pipePlace + 1);
		System.out.println(solved + "  " + player);
		System.out.println("- - - - - - - - -");
	}

	/*
	 * If a player has a number of words solved high enough to belong on the
	 * leaderboard, add it to the place where it is higher than the score
	 * preceding it, and remove the last one to make room. The "return" makes so
	 * that this comparison done once.
	 */
	public ArrayList<String> addWordsSolved(ArrayList<String> lead) {
		int pipePlace = 0;
		int leadSolved = 0;
		String tempS = "#s";
		
		for (int i = 0; i < lead.size(); i++) {
			pipePlace = lead.get(i).indexOf("|");
			tempS = lead.get(i).substring(0, pipePlace);
			leadSolved = Integer.parseInt(tempS);
			
			if (this.solved > leadSolved) {
				lead.add(i, this.solved + "|" + this.player);
				lead.remove(lead.size() - 1);
				System.out.println("Congradulations, your rank is " + i+1 + "!");
				return lead;
			}
		}
		return lead;
	}
}