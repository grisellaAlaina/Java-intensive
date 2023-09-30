package ex01;

import java.util.LinkedList;

public class DataQueue {
    private final LinkedList<Boolean> queue = new LinkedList<>();
    private final int maxSize;


    DataQueue(int maxSize) {
        this.maxSize = maxSize;
    }

    public void add(boolean bool) {
        queue.add(bool);
    }

    public boolean remove() {
        boolean bool = queue.pop();
        return bool;
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}
