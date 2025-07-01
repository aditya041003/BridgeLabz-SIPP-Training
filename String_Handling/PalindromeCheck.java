import java.util.Scanner;

public class PalindromeCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine().toLowerCase().replaceAll("\\s", "");

        boolean isPalindrome = true;
        int len = input.length();
        for (int i = 0; i < len / 2; i++) {
            if (input.charAt(i) != input.charAt(len - i - 1)) {
                isPalindrome = false;
                break;
            }
        }

        System.out.println("Palindrome: " + isPalindrome);
    }
}