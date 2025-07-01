import java.util.Scanner;

public class CompareStrings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first string: ");
        String str1 = sc.nextLine();
        System.out.print("Enter second string: ");
        String str2 = sc.nextLine();

        int len = Math.min(str1.length(), str2.length());
        for (int i = 0; i < len; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                if (str1.charAt(i) < str2.charAt(i)) {
                    System.out.println(str1 + " comes before " + str2);
                } else {
                    System.out.println(str2 + " comes before " + str1);
                }
                return;
            }
        }

        if (str1.length() < str2.length())
            System.out.println(str1 + " comes before " + str2);
        else if (str1.length() > str2.length())
            System.out.println(str2 + " comes before " + str1);
        else
            System.out.println("Both strings are equal.");
    }
}