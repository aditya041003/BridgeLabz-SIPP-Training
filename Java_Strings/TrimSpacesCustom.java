import java.util.Scanner;

public class Q12_TrimSpacesCustom {

    static int[] findTrimIndices(String str) {
        int start = 0;
        int end = str.length() - 1;

        while (start < str.length() && str.charAt(start) == ' ') start++;
        while (end >= 0 && str.charAt(end) == ' ') end--;

        return new int[]{start, end + 1};
    }

    static String customSubstring(String str, int start, int end) {
        String result = "";
        for (int i = start; i < end; i++) {
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
        System.out.print("Enter text with spaces: ");
        String input = sc.nextLine();

        int[] indices = findTrimIndices(input);
        String trimmedCustom = customSubstring(input, indices[0], indices[1]);
        String builtInTrimmed = input.trim();

        System.out.println("Custom Trimmed: [" + trimmedCustom + "]");
        System.out.println("Built-in Trimmed: [" + builtInTrimmed + "]");
        System.out.println("Are equal? " + compareStrings(trimmedCustom, builtInTrimmed));
        sc.close();
    }
}