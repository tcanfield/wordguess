import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class WordByLength {
	private ArrayList<String> wordBank = new ArrayList<String>();
	private int wordLength = 4;
	File wordFile;
	
	WordByLength(int wordLength, File wordFile) throws FileNotFoundException{
		this.wordLength = wordLength;
		this.wordFile = wordFile;
		findWords();
	}
	
	private void findWords() throws FileNotFoundException{
		Scanner scan = new Scanner(wordFile);
		while( scan.hasNext()){
			String word = scan.next();
			if(word.length() == wordLength){
				wordBank.add(word);
			}
		}
	}
	
	public ArrayList<String> getWordBank(){
		return wordBank;
	}

	public ArrayList<String> getRandomWords(int size) {
		ArrayList<String> words = new ArrayList<String>(10);
		Random rand = new Random();
		for(int i =0; i<size; i++){
			words.add(wordBank.get(rand.nextInt(wordBank.size())));
		}
		
		return words;
	}
}
