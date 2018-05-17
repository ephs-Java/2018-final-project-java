package Hangman;
import java.io.File;
import java.util.ArrayList;

public class VideoLeaderboard {

//	private static LeaderBoard lBoard;
	private File filePath;
	private String highWords;
	
	private ArrayList<Integer> topWordsSolved;
	private ArrayList<String> names;
	
	private VideoLeaderboard() {
		this.filePath = new File("HangmanLeaderboard.txt");
		this.highWords = "Scores";
		
		this.topWordsSolved = new ArrayList<Integer>();
		this.names = new ArrayList<String>();
	}
	
	/*
	 * If a player has a score high enough to belong on the leaderboard, add it to the place
	 * where it is higher than the score preceding it (pushing all other scores down),
	 * and remove the last one to make room.
	 * The "return" makes it so this comparison is done once, instead of adding it many times
	 * if it was higher than more then one score.
	 */
//	public void addScore(int score) {
//		for (int i = 0; i < highWords.size(); i++) {
//			if (score >= highWords.get(i)) {
//				highWords.add(i, score);
//				highWords.add(highWords.size() - 1);
//				return;
//			}
//		}
//	}
//	
//	/*
//	 * If a player has a number of words solved high enough to belong on the leaderboard,
//	 * add it to the place where it is higher than the score preceding it,
//	 * and remove the last one to make room. The "return" makes this comparison done once.
//	 */
//	public void addWordsSolved(int wordsSolved) {
//		for (int i = 0; i < topScores.size(); i++) {
//			if (wordsSolved >= topScores.get(i)) {
//				topScores.add(i, wordsSolved);
//				topScores.add(topScores.size() - 1);
//				return;
//			}
//		}
//	}
	
//	public void addName(String name) {
//		for (int i = 0; i < topScores.size(); i++) {
//			if (score >= topScores.get(i)) {
//				topScores.add(i, score);
//				topScores.add(topScores.size() - 1);
//			}
//		}
//	}
	
//	public static void main(String[] args) {
//		
//		
//		String name = "Gloria"; //.getName
//		for (int i = 1; i < 11; i++) {
//			System.out.println("| " + i + ". " + name + " |");
//		}
////		displayLeaderboard();
//	}
}