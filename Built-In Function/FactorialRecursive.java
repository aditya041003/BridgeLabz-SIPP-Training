import java.util.Scanner;

public class FactorialRecursive {
    public static void main(String[] args) {
        int n = getInput();
        System.out.println("Factorial of " + n + " is: " + factorial(n));
    }

    static int getInput() {
        System.out.print("Enter a number: ");
        return new Scanner(System.in).nextInt();
    }

    static long factorial(int n) {
        if (n == 0) return 1;
        return n * factorial(n - 1);
    }
}