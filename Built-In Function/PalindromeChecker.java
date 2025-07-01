import java.util.Scanner;

public class PalindromeChecker {
    public static void main(String[] args) {
        String input = getInput();
        if (isPalindrome(input))
            System.out.println("It is a palindrome.");
        else
            System.out.println("It is not a palindrome.");
    }

    static String getInput() {
        System.out.print("Enter a string: ");
        return new Scanner(System.in).nextLine().toLowerCase().replaceAll("\\s", "");
    }

    static boolean isPalindrome(String str) {
        int len = str.length();
        for (int i = 0; i < len / 2; i++)
            if (str.charAt(i) != str.charAt(len - i - 1)) return false;
        return true;
    }
}