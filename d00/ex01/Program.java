package ex01;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        if (n <= 1) {
            System.err.println("IllegalArgument");
            System.exit(-1);
        }
        if (n == 2) {
            System.out.println("true " + 2);
            System.exit(0);
        }
        if (n % 2 == 0) {
            System.out.println("false " + 3);
            System.exit(0);
        }
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) {
                System.out.println("false " + (n / 2 + 2));
                System.exit(0);
            }
        }
        System.out.println("true " + (n / 2  + 2));

    }
}
