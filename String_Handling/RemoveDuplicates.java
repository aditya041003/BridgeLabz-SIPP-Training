import java.util.Scanner;
import java.util.LinkedHashSet;

public class RemoveDuplicates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        StringBuilder result = new StringBuilder();
        LinkedHashSet<Character> set = new LinkedHashSet<>();

        for (char c : input.toCharArray())
            if (set.add(c)) result.append(c);

        System.out.println("Modified String: " + result);
    }
}