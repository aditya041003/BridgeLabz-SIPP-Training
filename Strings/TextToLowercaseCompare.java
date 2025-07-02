package Java_Strings;
import java.util.Scanner;
public class TextToLowercaseCompare {

    // Method to convert a string to lowercase using ASCII logic
    public static String convertToLowerCase(String text) {
        StringBuilder lowercase = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            // Check if the character is uppercase
            if (ch >= 'A' && ch <= 'Z') {
                // Convert to lowercase by adding 32
                ch = (char) (ch + 32);
            }

            lowercase.append(ch);
        }

        return lowercase.toString();
    }

    // Method to compare two strings character by character
    public static boolean compareStrings(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false; // Different lengths mean not equal
        }

        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return false; // Characters mismatch
            }
        }

        return true; // All characters match
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Get user input
        System.out.println("Enter the text:");
        String inputText = scanner.nextLine();

        // 2. Convert using built-in toLowerCase()
        String builtInLower = inputText.toLowerCase();

        // 3. Convert using custom method
        String customLower = convertToLowerCase(inputText);

        // 4. Compare the two results
        boolean isEqual = compareStrings(builtInLower, customLower);

        // Display results
        System.out.println("Built-in toLowerCase(): " + builtInLower);
        System.out.println("Custom toLowerCase(): " + customLower);
        System.out.println("Are both lowercase conversions equal? " + isEqual);
    }
}
