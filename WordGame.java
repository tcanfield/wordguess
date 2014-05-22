import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;


public class WordGame {
	private boolean isOver = false;
	private int guesses = 4;
	private int difficulty;
	private int letters = 4;
	private int wordCount = 5;
	private ArrayList<String> words = new ArrayList<String>();
	private String targetWord;
	
	public WordGame(int difficulty, File wordFile) throws FileNotFoundException{
		this.difficulty = difficulty;
		difficulty();
		
		WordByLength wordBank = new WordByLength(letters, wordFile);
		this.words = wordBank.getRandomWords(wordCount);
		
		Random rand = new Random();
		targetWord = words.get(rand.nextInt(words.size()));
	}
	
	public void guess(String guess){
		if(!words.contains(guess)){
			System.out.println("Guess a word in the list.");
			return;
		}
		if(guess.length() != targetWord.length()){
			System.out.println("Guess a word of length " +targetWord.length());
			return;
		}
		if(guess.equalsIgnoreCase(targetWord)){
			System.out.println("Correct!");
			System.exit(1);
		}else{
			int correctLetters = 0;
			guesses--;
			
			printWords();
			
			for(int i =0; i<guess.length(); i++){
				if(guesses <= 0){
					isOver = true;
				}
				if(Character.toLowerCase(guess.charAt(i)) == Character.toLowerCase(targetWord.charAt(i))){
					correctLetters++;
				}
			}
			System.out.println("Guess (" +guesses + " left) " + guess);
			System.out.println(correctLetters + "/" + letters +" correct\n");
		}	
	}
	
	public boolean isOver(){
		return isOver;
	}
	
	public void printWords(){
		for(int i =0; i<words.size(); i++){
			System.out.println(words.get(i));
		}
	}
	
	public String getTarget(){
		return targetWord;
	}
	
	private void difficulty(){
		if(difficulty == 1){
			letters = 4;
			wordCount = 5;
		}
		if(difficulty == 2){
			letters = 7;
			wordCount = 8;
		}
		if(difficulty == 3){
			letters = 10;
			wordCount = 11;
		}
		if(difficulty == 4){
			letters = 12;
			wordCount = 13;
		}
		if(difficulty == 5){
			letters = 15;
			wordCount = 15;
		}
	}
}

