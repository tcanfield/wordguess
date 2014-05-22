import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class test {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("enable1.txt");
		Scanner inputScanner = new Scanner(System.in);
		int difficulty;
		while(true){
			System.out.println("Enter difficulty (1-5):");
			try{
				difficulty = Integer.parseInt(inputScanner.next());
				if(difficulty >=0 && difficulty <= 5){
					break;
				}				
			}
			catch(NumberFormatException e){
				
			}
		}

		WordGame game = new WordGame(difficulty, file);
		
		//read guesses in from stdin
		game.printWords();
		while(!game.isOver()){
			game.guess(inputScanner.next());
		}
		System.out.println("Out of guesses! The correct word was " +game.getTarget());
	}

}
