import java.util.Scanner;

public class Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        int fact = 1;
        int i = n;

        do {
            fact *= i;
            i--;
        } while (i > 0);

        System.out.println("Factorial = " + fact);
    }
}
