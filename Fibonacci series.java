import java.util.Scanner;

public class Fibonacci {
    public static void fibonacciSeries(int n) {
        int first = 0, second = 1;
        System.out.print("Fibonacci Series: " + first + " " + second);
        
        for (int i = 2; i < n; i++) {
            int next = first + second;
            System.out.print(" " + next);
            first = second;
            second = next;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of terms: ");
        int n = scanner.nextInt();
        
        if (n < 2) {
            System.out.println("Please enter a number greater than or equal to 2.");
        } else {
            fibonacciSeries(n);
        }
        
        scanner.close();
    }
}
