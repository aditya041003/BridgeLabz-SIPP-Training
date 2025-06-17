import java.util.*;

public class Q14_SplitTextCustom {

    static int customLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (Exception e) {}
        return count;
    }

    static String[] customSplit(String str) {
        List<String> words = new ArrayList<>();
        String word = "";
        int len = customLength(str);
        for (int i = 0; i < len; i++) {
            char c = str.charAt(i);
            if (c == ' ') {
                if (!word.equals("")) {
                    words.add(word);
                    word = "";
                }
            } else {
                word += c;
            }
        }
        if (!word.equals("")) words.add(word);
        return words.toArray(new String[0]);
    }

    static boolean compareArrays(String[] a, String[] b) {
        if (a.length != b.length) return false;
        for (int i = 0; i < a.length; i++) {
            if (!a[i].equals(b[i])) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String input = sc.nextLine();

        String[] custom = customSplit(input);
        String[] builtIn = input.split(" ");

        System.out.println("Custom split: " + Arrays.toString(custom));
        System.out.println("Built-in split: " + Arrays.toString(builtIn));
        System.out.println("Are equal? " + compareArrays(custom, builtIn));
        sc.close();
    }
}