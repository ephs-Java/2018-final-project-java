package Hangman;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
/*
 * Start at the bottom of the file and complete the missing methods.
 * You might consider making a copy of this file just in case you make a mess
 * and need to restart.
 */
public class ReadingFiles {
	public static void main(String[] args) throws FileNotFoundException {

		String fileName = "words.txt"; //change this to use a different file of words.

		ArrayList<String> words = createArrayList(fileName);
		// looking for sunshine
		System.out.println("Index of Sunshine: " + words.indexOf("sunshine"));
		
		int theSize = words.size();
		System.out.println("The array list size: " + theSize);
	
		//array list changed into array
		String[] wordList = convertToArray(words);
		//look for sunshine
				for (int item = 0; item < theSize; item++) {
					if (wordList[item].equalsIgnoreCase("sunshine")) {
						System.out.println("We found sunshine at: " + item);
					}
				}
		// randomize the array of words
		randomizeIT(wordList);

		//look for sunshine
		for (int item = 0; item < theSize; item++) {
			if (wordList[item].equalsIgnoreCase("sunshine")) {
				System.out.println("We found sunshine at: " + item);
			}
		}

	} //---------------end of Main
	
	
	
	
	
	/*
	 * create a method that fills an ArrayList with words of 8 letters
	 * return the ArrayList
	 */
	public static ArrayList<String> eightLetterWords(ArrayList<String> words){
		ArrayList<String> eights = new ArrayList<String>();
		
		
		
		
		
		return eights;
	}
	
	
	
	
	
	
	/*
	 * this method allows you to mix up your alpha list, think about going
	 * across the array and swapping each element with another randomly picked element.
	 * You can use MakeARandom to find that new spot to do the swap 
	 */
	private static void randomizeIT(String[] arr) {
	
	
	}
	/*
	 * Using an array makes sorting easier, and is an AP question
	 * I've seen on a test or two....finish this method
	 */
	private static String[] convertToArray(ArrayList<String> words) {
		String[] wordArray = new String[words.size()];
		
		return wordArray;
	}
	/*
	 * using a text file full of words, one word on each line, read in a line and put that line
	 * into the ArrayList. This method works, and you shouldn't need to do anything but understand it
	 */
	private static ArrayList<String> createArrayList(String theFileName) throws FileNotFoundException{
		// read in the file
		Scanner input = new Scanner(new File(theFileName));
		// create an array list, to put the words into
		ArrayList<String> words = new ArrayList<String>();
		
		// read in the file, one line at a time
		while (input.hasNextLine()) {
			String line = input.nextLine();
			// make everything lower case
			line = line.toLowerCase();
			words.add(line);
		}
		// Display the size of the array list
		System.out.println("Size: " + words.size());
		return words;
	}

	// picking a random number
	private static int makeARandom(int low, int high) {
		return (int) (Math.random() * high + low);
	}

}
