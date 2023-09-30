package ex01;

import java.util.concurrent.TimeUnit;

public class Producer implements Runnable {
    private final DataQueue dataQueue;
    private final boolean bool;
    private final int max;
    private boolean running = false;
    public Producer(DataQueue dataQueue, Boolean bool, int numbers) {
        this.dataQueue = dataQueue;
        this.bool = bool;
        this.max = numbers;
    }

    @Override
    public void run() {
        try {
            produce();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void produce() throws InterruptedException {
        synchronized (dataQueue) {
            for (int i = 0; i < max; i++) {
                dataQueue.add(bool);
                dataQueue.notifyAll();
                dataQueue.wait();

//                dataQueue.notifyIsNotEmpty();
            }
        }
    }
}

