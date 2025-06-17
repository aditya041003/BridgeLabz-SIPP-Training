import java.util.Scanner;

public class Q7_SubstringComparison {

    static String customSubstring(String str, int start, int end) {
        String result = "";
        for (int i = start; i < end && i < str.length(); i++) {
            result += str.charAt(i);
        }
        return result;
    }

    static boolean compareStrings(String a, String b) {
        if (a.length() != b.length()) return false;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string: ");
        String input = sc.next();
        System.out.print("Enter start index: ");
        int start = sc.nextInt();
        System.out.print("Enter end index: ");
        int end = sc.nextInt();

        String builtIn = input.substring(start, end);
        String custom = customSubstring(input, start, end);

        System.out.println("Built-in substring: " + builtIn);
        System.out.println("Custom substring: " + custom);
        System.out.println("Are equal? " + compareStrings(builtIn, custom));
        sc.close();
    }
}