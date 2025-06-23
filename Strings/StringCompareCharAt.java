import java.util.Scanner;

public class Q8_StringCompareCharAt {

    static boolean compareWithCharAt(String a, String b) {
        if (a.length() != b.length()) return false;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first string: ");
        String str1 = sc.next();
        System.out.print("Enter second string: ");
        String str2 = sc.next();

        boolean resultCharAt = compareWithCharAt(str1, str2);
        boolean resultEquals = str1.equals(str2);

        System.out.println("CharAt comparison result: " + resultCharAt);
        System.out.println("Built-in equals() result: " + resultEquals);
        sc.close();
    }
}