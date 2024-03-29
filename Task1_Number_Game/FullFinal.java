package Task1_Number_Game;
import java.util.Scanner;
import java.util.Random;
public class FullFinal {
        public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int min = 1;
        int max = 100;
        int maxAttempts = 5; 
        int rounds = 0;
        int score = 0;

        boolean playAgain = true;

        while (playAgain) {
            int randomNumber = random.nextInt(max - min + 1) + min;
            System.out.println("I have generated a random number between " + min + " and " + max + ".");
            System.out.println("You have " + maxAttempts + " attempts to guess the number.");

            boolean correctGuess = false;
            int attempts = 0;

            while (!correctGuess && attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                attempts++;

                if (guess == randomNumber) {
                    correctGuess = true;
                    System.out.println("Congratulations! You've guessed the number " + randomNumber + " correctly!");
                    System.out.println("Number of attempts: " + attempts);
                    score += maxAttempts - attempts + 1; 
                } else {
                    System.out.println(guess < randomNumber ? "Too low! Try again." : "Too high! Try again.");
                }
            }

            if (!correctGuess) {
                System.out.println("Sorry, you've run out of attempts. The correct number was " + randomNumber + ".");
            }

            rounds++;

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = scanner.next().toLowerCase();

            if (!playAgainInput.equals("yes")) {
                playAgain = false;
            }
        }

        System.out.println("Scorecard!");
        System.out.println("Rounds played: " + rounds);
        System.out.println("Your total score: " + score);

        scanner.close();
    }
}
