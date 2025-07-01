import java.util.Scanner;
import java.util.HashMap;

public class MostFrequentCharacter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine().replaceAll("\\s", "");

        HashMap<Character, Integer> freq = new HashMap<>();
        for (char c : input.toCharArray())
            freq.put(c, freq.getOrDefault(c, 0) + 1);

        char mostFreq = ' ';
        int maxCount = 0;
        for (char c : freq.keySet()) {
            if (freq.get(c) > maxCount) {
                maxCount = freq.get(c);
                mostFreq = c;
            }
        }

        System.out.println("Most Frequent Character: '" + mostFreq + "'");
    }
}