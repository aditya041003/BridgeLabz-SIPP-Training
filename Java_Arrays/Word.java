//write a PROGRAM TO CHECK ODD DIVISOR OF A NUMBER
import java.util.Scanner;
public class Word {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        boolean hasOddDivisor = false;

        for (int i = 1; i <= n; i++) {
            if (n % i == 0 && i % 2 != 0) {
                hasOddDivisor = true;
                break;
            }
        }

        if (hasOddDivisor) {
            System.out.println("The number " + n + " has an odd divisor.");
        } else {
            System.out.println("The number " + n + " does not have an odd divisor.");
        }
    }
}