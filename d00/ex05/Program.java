package ex05;

import java.util.Arrays;
import java.util.Scanner;

public class Program {
    static String[] calendar = new String[]{"TU", "WE", "TH", "FR", "SA", "SU", "MO"};
    static String[][] calMtx = new String[2][30];
    static String[] students = new String[10];
    static int r = 0;
    static int c = 0;
    static String[] lessons = new String[50];
    static String[] journal = new String[500];
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        putInS();
        putInL();
        String[][] res = new String[r][c];
        res[0][0] = "          ";
        int[] dates = new int[c];
        makeRes(res, dates);
        takeAbsent(res, dates);
        printRes(res);


        sc.close();
    }

    public static int getNamePlace(String str, String[][] res) {
        int result = 0;
        String tmp;
        for (int i = 1; i < r; i++) {
            tmp = students[i - 1];
            if (tmp.equals(str)) {
                result = i;
            }
        }
        return result;
    }

    public static void takeAbsent(String[][] res, int[] dates) {
        String tmp;
        int num;
        int num2;
        while (true) {
            tmp = sc.next();
            if (tmp.equals(".")) break;
            num = getNamePlace(tmp, res);
            sc.next();
            num2 = sc.nextInt();
            for (int i = 0; i < c; i++) {
                if (num2 == dates[i]) {
                    num2 = i;
                }
            }
            tmp = sc.next();
            if (tmp.equals("HERE")) {
                res[num][num2] = "         1|";
            } else res[num][num2] = "        -1|";
        }
    }

    public static void printRes(String[][] res) {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c - 1; j++) {
                System.out.print(res[i][j]);
            }
            System.out.println();
        }
    }

    public static String tail(String str) {
        int end = 10 - str.length();
        for (int i = 0; i < end; i++) {
            str += " ";
        }
        return str;
    }

    public static void resFields(String[][] res) {
        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c - 1; j++) {
                res[i][j] = "          |";
            }
        }
    }

    public static void makeRes(String[][] res, int[] dates) {
        String tmp;
        String day;
        for (int i = 1; i < r; i++) {
            tmp = tail(students[i - 1]);
            res[i][0] = tmp;
        }
        int count = 0;
        for (int i = 0; i < 30; i++) {
            if (count > c) break;
            if (calMtx[0][i] != null) {
                count++;
                dates[count] = i + 1;
                day = String.valueOf(i + 1);
                if (i + 1 < 9) {
                    tmp = calMtx[0][i] + ":00 " + calMtx[1][i] + "  " + day + "|";
                    res[0][count] = tmp;
                } else {
                    tmp = calMtx[0][i] + ":00 " + calMtx[1][i] + " " + day + "|";
                    res[0][count] = tmp;
                }

            }
        }
        resFields(res);
    }


    public static void putInCal(String t, String d) {
        for (int i = 0; i < 30; i++) {
            if (i < 7) {
                calMtx[1][i] = calendar[i];
            } else {
                calMtx[1][i] = calendar[i % 7];
            }
            if (calMtx[1][i].equals(d)) {
                calMtx[0][i] = t;
                c++;
            }
        }
        c++;
    }

    public static void putInL() {
        String t, d;
        for (int i = 0; i < 50; i++) {
            t = sc.next();
            if (t.equals(".")) break;
            d = sc.next();
            putInCal(t, d);
        }
    }

    public static void putInS() {
        String a;
        for (int i = 0; i < 10; i++) {
            a = sc.next();
            if (a.equals(".")) {
                r++;
                break;
            }
            students[i] = a;
            r++;
        }
    }
}



