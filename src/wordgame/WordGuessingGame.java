package wordgame;

import java.util.Random;
import java.util.Scanner;

public class WordGuessingGame {
    private String wordToGuess;
    private char[] guessedLetters;
    private int attempts;
    
	public WordGuessingGame(String[]wordList,int maxAttempts) {
		Random random=new Random();
		this.wordToGuess= wordList[random.nextInt(wordList.length)];
	    this.guessedLetters=new char[this.wordToGuess.length()];
	    for(int i=0;i<this.guessedLetters.length;i++) {
	    	this.guessedLetters[i]='_';
	    }
	    this.attempts=maxAttempts;    
 }
	public String play() {
		
		Scanner scanner=new Scanner(System.in);
		
		
		while(attempts>0) {
			diaplayState();
			System.out.println("You have "+ attempts + " attempts left...");
			System.out.println("Guess a letter: ");
			
			char guess=scanner.nextLine().toLowerCase().charAt(0);
			
			if(processGuess(guess)) {
				System.out.println("correct!");
				if(new String(guessedLetters).equals(wordToGuess)) {
				System.out.println("You have guessed the word! You win!");	
				return "Win";
				}
			}else {
				System.out.println("That guess was incorrect!");
			    attempts--;
		}
		}
		
		return "Loss";
		}
	
	
    private boolean processGuess(char letter) {
    	boolean letterFound=false;
    	for (int i = 0; i <wordToGuess.length(); i++) {
			if(wordToGuess.charAt(i)== letter) {
				guessedLetters[i]=letter;
				letterFound=true;
			}
		}
    	return letterFound;
    }
    
    private void diaplayState() {
    	System.out.println("Guessed letters: " + new String(guessedLetters));
    }
}