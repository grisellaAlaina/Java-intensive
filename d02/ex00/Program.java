package ex00;

public class Program {
    public static  void main (String[] args) {
        String signFile = "ex00/signatures.txt";
        String result = "ex00/result.txt";

        CheckExtension my = new CheckExtension(signFile, result);
        my.run();



    }
}
