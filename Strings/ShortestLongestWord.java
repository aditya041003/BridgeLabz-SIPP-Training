import java.util.*;

public class Q17_ShortestLongestWord {

    static String[] splitWords(String str) {
        List<String> list = new ArrayList<>();
        String word = "";
        for (char c : str.toCharArray()) {
            if (c == ' ') {
                if (!word.isEmpty()) {
                    list.add(word);
                    word = "";
                }
            } else {
                word += c;
            }
        }
        if (!word.isEmpty()) list.add(word);
        return list.toArray(new String[0]);
    }

    static String[] findShortestLongest(String[] words) {
        String shortest = words[0], longest = words[0];
        for (String word : words) {
            if (word.length() < shortest.length()) shortest = word;
            if (word.length() > longest.length()) longest = word;
        }
        return new String[]{shortest, longest};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String input = sc.nextLine();
        String[] words = splitWords(input);
        String[] result = findShortestLongest(words);
        System.out.println("Shortest Word: " + result[0]);
        System.out.println("Longest Word: " + result[1]);
        sc.close();
    }
}