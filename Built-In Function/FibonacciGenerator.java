import java.util.Scanner;

public class FibonacciGenerator {
    public static void main(String[] args) {
        System.out.print("Enter number of terms: ");
        int terms = new Scanner(System.in).nextInt();
        generateFibonacci(terms);
    }

    static void generateFibonacci(int terms) {
        int a = 0, b = 1;
        System.out.print("Fibonacci Sequence: ");
        for (int i = 1; i <= terms; i++) {
            System.out.print(a + " ");
            int temp = a + b;
            a = b;
            b = temp;
        }
    }
}