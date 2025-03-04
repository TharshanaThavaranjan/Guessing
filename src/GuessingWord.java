import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class GuessingWord {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            Random random = new Random();

            // List of words to choose from
            String[] words = {"java", "programming", "computer", "development", "game"};
            String wordToGuess = words[random.nextInt(words.length)];
            Set<Character> guessedLetters = new HashSet<>();
            int maxAttempts = 7;
            int attemptsLeft = maxAttempts;

            System.out.println("Welcome to Guess the Word!");
            System.out.println("Try to guess the word letter by letter.");

            while (attemptsLeft > 0) {
                String displayWord = getDisplayWord(wordToGuess, guessedLetters);
                System.out.println("Word: " + displayWord);
                System.out.println("Attempts left: " + attemptsLeft);

                System.out.print("Guess a letter: ");
                char guess = scanner.nextLine().toLowerCase().charAt(0);

                if (!Character.isLetter(guess)) {
                    System.out.println("Invalid input. Please enter a letter.");
                    continue;
                }

                if (guessedLetters.contains(guess)) {
                    System.out.println("You already guessed that letter.");
                    continue;
                }

                guessedLetters.add(guess);

                if (wordToGuess.indexOf(guess) == -1) {
                    attemptsLeft--;
                    System.out.println("Incorrect guess!");
                } else {
                    System.out.println("Good guess!");
                }

                if (isWordGuessed(wordToGuess, guessedLetters)) {
                    System.out.println("Congratulations! You've guessed the word: " + wordToGuess);
                    break;
                }
            }

            if (attemptsLeft == 0) {
                System.out.println("Game over! The word was: " + wordToGuess);
            }

            scanner.close();
        }

        private static String getDisplayWord(String word, Set<Character> guessedLetters) {
            StringBuilder displayWord = new StringBuilder();
            for (char letter : word.toCharArray()) {
                if (guessedLetters.contains(letter)) {
                    displayWord.append(letter).append(" ");
                } else {
                    displayWord.append("_ ");
                }
            }
            return displayWord.toString().trim();
        }

        private static boolean isWordGuessed(String word, Set<Character> guessedLetters) {
            for (char letter : word.toCharArray()) {
                if (!guessedLetters.contains(letter)) {
                    return false;
                }
            }
            return true;
        }


}
