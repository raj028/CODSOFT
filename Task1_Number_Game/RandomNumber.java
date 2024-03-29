package Task1_Number_Game;

import java.util.Random;

public class RandomNumber{
    public static void main(String[] args) {
        int min = 1;
        int max = 100;
        int randomNumber = getRandomNumber(min, max);
        System.out.println("Random number between " + min + " and " + max + ": " + randomNumber);
    }

    public static int getRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }
}
