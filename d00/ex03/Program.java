package ex03;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String week;
        int week_count = 0;
        int min_grade;
        int grade_storage = 0;

        for (int i = 0; i < 5; i++) {
            week = sc.nextLine();
            if (week.equals("42")) {
                break;
            }
            week_count++;
            if (!week.equals("Week " + (i + 1))) {
                System.err.println("IllegalArgument");
                System.exit(-1);
            }
            min_grade = findMin(sc);
            grade_storage += grade_converter(min_grade, i);
        }
        print_res(grade_storage, week_count);
    }

    public static void print_res(int n, int end) {
        for (int i = 0; i < end; i++) {
            for (int j = 0; j < n % 10; j++) {
                System.out.print("=");
            }
            System.out.println(">");
            n /= 10;
        }
    }

    public static int grade_converter(int grade, int i) {
        int pow = 1;
        for (int j = 0; j < i; j++) {
            pow *= 10;
        }
        return grade * pow;
    }


    public static int findMin(Scanner sc) {
        System.out.println("Input grade:");
        int grade;
        int res = 10;
        for (int i = 0; i < 5; ++i) {
            grade = sc.nextInt();
            gradeCheck(grade);
            if (grade < res) {
                res = grade;
            }
        }
        sc.nextLine();
        return res;
    }

    public static void gradeCheck(int n) {
        if (n < 1 || n > 9) {
            System.err.println("IllegalArgument");
            System.exit(-1);
        }
    }
}