package ex00;

import java.util.concurrent.TimeUnit;

public class ChickenThread extends Thread{
    String name;
    int count;
    public ChickenThread(String name, int count) {
        this.name = name;
        this.count = count;
    }
    @Override
    public void run() {
        for (int i = 0; i < count; i++) {
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(name);
        }
    }

}
