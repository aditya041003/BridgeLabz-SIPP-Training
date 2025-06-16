import java.util.Scanner;

public class MultiplesBelow100While {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a positive number less than 100: ");
        int number = sc.nextInt();

        int counter = 100;
        while (counter > 0) {
            if (counter % number == 0) {
                System.out.println(counter);
            }
            counter--;
        }
    }
}