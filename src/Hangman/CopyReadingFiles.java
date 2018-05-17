package Hangman;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CopyReadingFiles {
	public static void main(String[] args) throws FileNotFoundException {

		String fileName = "words.txt";
		ArrayList<String> words = createArrayList(fileName);
		String fileName2 = "out.txt";
		ArrayList<String> badWords = createArrayList(fileName2);
		
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
	 * compares the dictionary to the list of bad words and modifies the dictionary
	 */
	public static void barOfSoap(ArrayList<String> words, ArrayList<String> badWords){
		for (int bad = 0; bad < badWords.size(); bad++) {
			for (int ok = 0; ok < words.size(); ok++) {
				if (badWords.get(bad).equals(words.get(ok)));
					words.remove(ok);
			}
		}
	}
	
	/*
	 * create a method that returns an ArrayList with words of 8 letters
	 */
	public static ArrayList<String> eightLetterWords(ArrayList<String> words){
		ArrayList<String> eights = new ArrayList<String>();
		for (String item : words) {
			if (item.length() < 9)
				eights.add(item);
		}
		return eights;
	}
	
	/*
	 * this method allows you to mix up your alpha list, think about going
	 * across the array and swapping each element with another randomly picked element.
	 * You can use MakeARandom to find that new spot to do the swap.
	 * get a number for the index of a word and assign it to a new index
	 */
	private static void randomizeIT(String[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int temp = i;
			int swapIndex = makeARandom(0, arr.length-1);
			arr[i] = arr[swapIndex];
			arr[swapIndex] = arr[temp];
		}
	}
	
	private static String[] convertToArray(ArrayList<String> words) {
		String[] wordArray = new String[words.size()];
		for (int i = 0; i < wordArray.length; i++) {
			wordArray[i] = words.get(i);
		}
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
			if (line.length() < 15) {
				words.add(line);
			}
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