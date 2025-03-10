import java.util.Random;
import java.util.Scanner;

public class GuessingNumber {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            Random random = new Random();

            int lowerBound = 1;
            int upperBound = 100;
            int numberToGuess = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            int numberOfTries = 0;
            boolean hasGuessedCorrectly = false;

            System.out.println("Welcome to the Number Guessing Game!");
            System.out.println("Guess a number between " + lowerBound + " and " + upperBound + ":");

            while (!hasGuessedCorrectly) {
                System.out.print("Enter your guess: ");
                int playerGuess = scanner.nextInt();
                numberOfTries++;

                if (playerGuess < lowerBound || playerGuess > upperBound) {
                    System.out.println("Please enter a number between " + lowerBound + " and " + upperBound + ".");
                } else if (playerGuess < numberToGuess) {
                    System.out.println("Too low! Try again.");
                } else if (playerGuess > numberToGuess) {
                    System.out.println("Too high! Try again.");
                } else {
                    hasGuessedCorrectly = true;
                    System.out.println("Congratulations! You've guessed the number " + numberToGuess + " correctly in " + numberOfTries + " tries.");
                }
            }

            scanner.close();
        }
    }



