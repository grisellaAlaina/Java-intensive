package ex00;

public class Program {
    private static int count;
    public static void main(String[] args) {
        Validation v = new Validation();
        count = v.check(args);
        ChickenThread first = new ChickenThread("Hen", count);
        ChickenThread second = new ChickenThread("Egg", count);
        first.start();
        second.start();
        try {
            first.join();
            second.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        HumanThread();

    }

    static void HumanThread() {
        for (int i = 0; i < count; i++) {
            System.out.println("Human");
        }
    }
}
