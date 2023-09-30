package ex02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class AddThread {
    public int sumByThread(int[] arr, int threadCount) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(threadCount);
        int countItems = arr.length / threadCount;
        final List<Future<Integer>> intermediateAmounts = new ArrayList<>();
        for (int i = 0; i < threadCount; ++i) {
            int first = countItems * i;
            int last = (i == threadCount - 1) ? arr.length : first + countItems;
            int finalI = i;
            intermediateAmounts.add(executorService.submit(() -> {
                int intermedSum = Arrays.stream(arr, first, last).sum();
                String threadName = Thread.currentThread().getName();
                System.out.println("Thread " + (finalI + 1) + "(" + threadName + "): from " + first + " to " + last + " sum is " + intermedSum);
                return intermedSum;
            }));
        }
        executorService.shutdown();
        return sumAmount(intermediateAmounts);
    }

    private int sumAmount(List<Future<Integer>> intermediateAmounts) throws ExecutionException, InterruptedException {
        int amount = 0;
        for (Future<Integer> item : intermediateAmounts) {
            amount += item.get();
        }
        return amount;
    }
}
