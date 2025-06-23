import java.util.Scanner;

public class Q10_IllegalArgumentExceptionDemo {

    static void generateException(String text) {
        System.out.println("Substring with invalid indices: " + text.substring(5, 2));
    }

    static void handleException(String text) {
        try {
            System.out.println("Substring with invalid indices: " + text.substring(5, 2));
        } catch (IllegalArgumentException e) {
            System.out.println("Caught IllegalArgumentException: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Caught RuntimeException: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String input = sc.next();
        // generateException(input); // Uncomment to see abrupt termination
        handleException(input);
        sc.close();
    }
}