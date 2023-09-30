package ex01;

import java.util.concurrent.TimeUnit;

public class Consumer implements Runnable{
    private final DataQueue dataQueue;
    private int end;

    public Consumer(DataQueue dataQueue, int numbers) {
        this.dataQueue = dataQueue;
        this.end = numbers;
    }

    @Override
    public void run() {
        consume();
    }

    public void consume() {
        synchronized (dataQueue) {
            for (int i = 0; i < end * 2; i++) {
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                while (dataQueue.isEmpty()) {
                    try {
                        dataQueue.wait();
                    } catch (InterruptedException e) {
                        System.out.println("Error while waiting to Consume messages.");
                        break;
                    }
                }
                boolean bool = dataQueue.remove();
                dataQueue.notifyAll();
                if (bool) {
                    System.out.println("Han");
                } else {
                    System.out.println("Egg");
                }
            }
        }
    }
}
