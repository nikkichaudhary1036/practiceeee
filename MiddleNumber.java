import java.util.Scanner;

public class MiddleNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter three numbers: ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        int middle;

        if ((a > b && a < c) || (a < b && a > c)) {
            middle = a;
        } else if ((b > a && b < c) || (b < a && b > c)) {
            middle = b;
        } else {
            middle = c;
        }

        System.out.println("Middle number is: " + middle);
    }
}
