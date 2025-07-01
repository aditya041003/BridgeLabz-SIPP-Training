import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    static Scanner scanner = new Scanner(System.in);
    static Random rand = new Random();

    public static void main(String[] args) {
        int low = 1, high = 100;
        String feedback;
        int guess;

        System.out.println("Think of a number between 1 and 100.");
        do {
            guess = generateGuess(low, high);
            System.out.println("Is your number " + guess + "? (Enter: high/low/correct)");
            feedback = scanner.nextLine().toLowerCase();

            if (feedback.equals("high")) {
                high = guess - 1;
            } else if (feedback.equals("low")) {
                low = guess + 1;
            }
        } while (!feedback.equals("correct"));

        System.out.println("Hooray! The computer guessed your number.");
    }

    static int generateGuess(int low, int high) {
        return rand.nextInt(high - low + 1) + low;
    }
}