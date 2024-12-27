package wordgame;

import java.util.Scanner;

public class App {
public static void main(String[] args) {
	String[] words={"java","programming","class","computer","method"};
	WordGuessingGame game=new WordGuessingGame(words, 10);
	
	Scanner scanner=new Scanner(System.in);
	boolean shouldPlayAgain=false;
	
	int wins=0;
	int losses=0;
	
	do {
	    
		String result = game.play();
		
		if(result.equals("Win")) {
			wins++;
		}else {
			losses++;
		}
		
		System.out.println("Wins: " + wins + ", Losses: " + losses);
		System.out.print("Would you like to play again? (y/n): ");
		char playAgain=scanner.nextLine().toLowerCase().charAt(0);
		shouldPlayAgain=playAgain=='y';
	}while(shouldPlayAgain);
	
	game.play();
}
}