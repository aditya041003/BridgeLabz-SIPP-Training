import java.util.Scanner;

public class Q6_CharArrayComparison {
    static char[] customToCharArray(String text) {
        char[] chars = new char[text.length()];
        for (int i = 0; i < text.length(); i++) {
            chars[i] = text.charAt(i);
        }
        return chars;
    }

    static boolean compareCharArrays(char[] a, char[] b) {
        if (a.length != b.length) return false;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter text:");
        String text = sc.next();
        char[] builtInArray = text.toCharArray();
        char[] customArray = customToCharArray(text);
        boolean areEqual = compareCharArrays(builtInArray, customArray);

        System.out.println("Built-in toCharArray:");
        for (char c : builtInArray) System.out.print(c + " ");
        System.out.println("
Custom toCharArray:");
        for (char c : customArray) System.out.print(c + " ");
        System.out.println("
Are both arrays equal? " + areEqual);
        sc.close();
    }
}