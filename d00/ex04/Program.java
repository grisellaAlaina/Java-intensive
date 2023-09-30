package ex04;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        sc.close();
        char[] strArr = str.toCharArray();
        int[] valueArr = new int[65535];
        char[] resArr = new char[10];
        int len_count = 0;
        for (char c : strArr) {
            valueArr[c] += 1;
        }

        for (char c : strArr) {
            len_count += putIn(valueArr, resArr, c);
        }
        if (len_count > 10) {
            len_count = 10;
        }

        printRes(len_count, resArr, valueArr);
    }

    static void printRes(int len, char[] resArr, int[] valueArr) {
        double cef = valueArr[resArr[0]] / len;
        for (int i = 0; i < len ; ++i) {
            System.out.print(valueArr[resArr[i]] + " ");
        }
        System.out.println();

        for (int i = 10; i > 0; i--) {
            for (int j = 0; j < len; j++) {
                if ((int)(valueArr[resArr[j]] / cef) >= i) {
                    System.out.print("# ");
                }
            }
            System.out.println();
        }
        for (int i = 0; i < len ; ++i) {
            System.out.print(resArr[i] + " ");
        }
    }

    static int putIn(int[] valueArr, char[] resArr, char c) {
        if (!chekIn(c, resArr)) {
            boolean flag = false;
            for (int i = 9; i > -1; i--) {
                flag = true;
                char tmp;
                if (valueArr[resArr[i]] < valueArr[c]) {
                    if (i == 9) {
                        resArr[i] = c;
                    } else {
                        tmp = resArr[i];
                        resArr[i] = c;
                        resArr[i + 1] = tmp;
                    }
                    flag = true;
                } else if (valueArr[resArr[i]] == c) {
                    if (resArr[i] < c) {
                        tmp = resArr[i];
                        resArr[i] = c;
                        resArr[i+1] = tmp;
                        flag = true;
                    }
                }
            }
            if (flag) {
                return 1;
            }
        }
        return 0;
    }
    static boolean chekIn(char c, char[] resArr) {
        for (int i = 0; i < 10; i++) {
            if (c == resArr[i]) {
                return true;
            }
        }
        return false;
    }
}