package ex01;

public class Program {
    public static void main(String[] args) {
        Validation v = new Validation();
        int numbers = v.check(args);
        DataQueue dataQueue = new DataQueue(numbers);
        Producer hanProd = new Producer(dataQueue, true, numbers);
        Producer eggProd = new Producer(dataQueue, false, numbers);
        Consumer cons = new Consumer(dataQueue, numbers);

        Thread eggThread = new Thread(eggProd);
        Thread hanThread = new Thread(hanProd);
        Thread consThread = new Thread(cons);

        eggThread.start();
        hanThread.start();
        consThread.start();


    }
}

