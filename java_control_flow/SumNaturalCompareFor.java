import java.util.Scanner;

public class SumNaturalCompareFor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n >= 1) {
            int sum = 0;
            for (int i = 1; i <= n; i++) {
                sum += i;
            }
            int formulaSum = n * (n + 1) / 2;
            System.out.println("For loop sum: " + sum);
            System.out.println("Formula sum: " + formulaSum);
        } else {
            System.out.println("Not a natural number");
        }
    }
}