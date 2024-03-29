package Task1_Number_Game;

import java.util.Scanner;
import java.util.Random;

public class GuessGame3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int min = 1;
        int max = 100;
        int randomNumber = random.nextInt(max - min + 1) + min;
        System.out.println("I have generated a random number between " + min + " and " + max + ".");
        System.out.println("Try to guess the number!");

        boolean correctGuess = false;
        int attempts = 0;

        while (!correctGuess) {
            System.out.print("Enter your guess: ");
            int guess = scanner.nextInt();
            attempts++;

            if (guess == randomNumber) {
                correctGuess = true;
                System.out.println("Congratulations! You've guessed the number " + randomNumber + " correctly!");
                System.out.println("Number of attempts: " + attempts);
            } else {
                System.out.println(guess < randomNumber ? "Too low! Try again." : "Too high! Try again.");
                System.out.println();
            }
        }

        scanner.close();
    }
}

