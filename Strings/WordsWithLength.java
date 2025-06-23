import java.util.*;

public class Q15_WordsWithLength {

    static String[] customSplit(String str) {
        List<String> words = new ArrayList<>();
        String word = "";
        for (int i = 0; i < str.length(); i++) {
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

    static String[][] getWordsWithLength(String[] words) {
        String[][] result = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(customLength(words[i]));
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String input = sc.nextLine();

        String[] words = customSplit(input);
        String[][] result = getWordsWithLength(words);

        System.out.println("Word	Length");
        for (String[] row : result) {
            System.out.println(row[0] + "	" + row[1]);
        }
        sc.close();
    }
}