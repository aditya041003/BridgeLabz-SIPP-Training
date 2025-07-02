import java.util.Scanner;

public class RemoveSpecificCharacter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        System.out.print("Character to remove: ");
        char ch = sc.nextLine().charAt(0);

        String result = input.replace(String.valueOf(ch), "");
        System.out.println("Modified String: " + result);
    }
}