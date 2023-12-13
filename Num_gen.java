import java.util.Scanner;
import java.util.Random;

public class Num_gen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int maxAttempts = 5; // Maximum attempts allowed per round
        int userGuess, attempts, roundsWon = 0, totalAttempts = 0;
        boolean playAgain;
        
        System.out.println("Welcome to the Number Guessing Game!");
        
        do {
            int generatedNumber = random.nextInt(100) + 1; // Generates a random number between 1 and 100
            attempts = 0;
            
            System.out.println("\nNew round! Guess a number between 1 and 100.");
            
            while (attempts < maxAttempts) {
                System.out.print("Attempt " + (attempts + 1) + "/" + maxAttempts + ": Enter your guess: ");
                userGuess = scanner.nextInt();
                attempts++;
                
                if (userGuess < generatedNumber) {
                    System.out.println("Too low! Try again.");
                } else if (userGuess > generatedNumber) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Congratulations! You guessed the correct number: " + generatedNumber);
                    roundsWon++;
                    totalAttempts += attempts;
                    break;
                }
            }
            
            if (attempts == maxAttempts) {
                System.out.println("Sorry, you've reached the maximum attempts. The number was: " + generatedNumber);
            }
            
            System.out.print("Do you want to play again? (Yes/No): ");
            String playChoice = scanner.next().toLowerCase();
            playAgain = playChoice.equals("yes");
            
        } while (playAgain);
        
        System.out.println("\nGame Over!");
        if (roundsWon > 0) {
            double averageAttempts = (double) totalAttempts / roundsWon;
            System.out.println("You won " + roundsWon + " round(s) with an average of " + averageAttempts + " attempts per round.");
        } else {
            System.out.println("You didn't win any rounds.");
        }
        
        scanner.close();
    }
}
