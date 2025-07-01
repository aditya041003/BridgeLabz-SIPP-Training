import java.util.Scanner;

public class LongestWord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String[] words = sc.nextLine().split("\\s+");

        String longest = "";
        for (String word : words)
            if (word.length() > longest.length())
                longest = word;

        System.out.println("Longest word: " + longest);
    }
}