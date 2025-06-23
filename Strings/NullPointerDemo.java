package Java_Strings;
public class NullPointerDemo {

    // 1. Method to generate NullPointerException
    public static void generateException() {
        String text = null;
        // This will throw NullPointerException
        System.out.println("Length of text: " + text.length());
    }

    // 2. Method to handle NullPointerException using try-catch
    public static void handleException() {
        String text = null;
        try {
            System.out.println("Length of text: " + text.length());
        } catch (NullPointerException e) {
            System.out.println("Caught NullPointerException! The text variable is null.");
        }
    }

    // 3. Main method
    public static void main(String[] args) {
        System.out.println("Calling method to generate exception:");
        try {
            generateException(); // This will crash if not handled
        } catch (NullPointerException e) {
            System.out.println("Exception caught in main: " + e);
        }

        System.out.println("\nCalling method to handle exception:");
        handleException(); // This handles the exception safely
    }
}
