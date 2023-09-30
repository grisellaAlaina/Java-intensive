package ex01;

public class Program {
    public static void main(String[] args) {
        String dictPath = "ex01/Dictionary.txt";
        if (args.length < 2) {
            System.err.println("too few arguments");
            System.exit(-1);
        }
        Similarity cosineSim = new Similarity(args[0], args[1], dictPath);
        cosineSim.startApp();
    }
}