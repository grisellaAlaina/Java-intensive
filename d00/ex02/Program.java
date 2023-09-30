package ex02;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        int count = 0;
        while(true) {
            n = sc.nextInt();
            if (n == 42) {
                System.out.println("Count of coffee-requerst - " + count);
                sc.close();
                System.exit(0);
            }
            if (isPrime(n)) {
                count++;
            }
        }
    }
    public static boolean isPrime(int n) {
        boolean res = true;
        int sumN = n % 10;
        while (n !=0) {
            n /= 10;
            sumN += n % 10;
        }
        if (sumN == 2) {
            return res;
        }
        if ((sumN % 2) == 0) {
            return !res;
        }
        for (int i = 3; i * i <= sumN; i += 2) {
            if ((sumN % i) == 0) {
                return !res;
            }
        }
        return res;
    }
}


