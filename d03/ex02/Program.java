package ex02;

import java.util.Arrays;
import java.util.SplittableRandom;
import java.util.concurrent.ExecutionException;

public class Program {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
    Validation v = new Validation();
    int arrSize = v.checkOne(args);
    int threadCount = v.checkTwo(args);
    int[] arr = new SplittableRandom().ints(arrSize, -1000, 1001).toArray();
    int sum = 0;
    for (int i : arr) {
        sum += i;
    }
    System.out.println("Sum: " + sum);
    int res = new AddThread().sumByThread(arr, threadCount);
    System.out.println("Sum by threads:" + res);
    }

}
