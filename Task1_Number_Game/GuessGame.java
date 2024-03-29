package Task1_Number_Game;

import java.util.Scanner;
import java.util.Random;

public class GuessGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int min = 1;
        int max = 100;
        int randomNumber = getRandomNumber(min, max);
        System.out.println("I have generated a random number between " + min + " and " + max + ".");
        System.out.println("Try to guess the number!");
        System.out.print("Enter your guess: ");
        int guess = scanner.nextInt();

        if (guess == randomNumber) {
            System.out.println("Congratulations! You've guessed the number " + randomNumber + " correctly!");
        } else {
            System.out.println("Sorry, the correct number was " + randomNumber + ".");
        }

        scanner.close();
    }
    public static int getRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }
}
