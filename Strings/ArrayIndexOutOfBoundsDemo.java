import java.util.Scanner;

public class Q9_ArrayIndexOutOfBoundsDemo {

    static void generateException(String[] names) {
        System.out.println("Accessing index out of bounds: " + names[names.length]);
    }

    static void handleException(String[] names) {
        try {
            System.out.println("Accessing index out of bounds: " + names[names.length]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught ArrayIndexOutOfBoundsException: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Caught RuntimeException: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String[] names = { "Alice", "Bob", "Charlie" };
        // generateException(names); // Uncomment to see abrupt termination
        handleException(names);
    }
}