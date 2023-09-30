package ex02;

public class Validation {
    int checkOne (String[] args) {
        int n = 0;
        if((args.length >= 2) && args[0].startsWith("--arraySize=")) {
            try {
                n = Integer.parseInt(args[0].substring("--arraySize=".length()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.err.println("too few arguments or error of input");
            System.exit(-1);
        }
        return n;
    }

    int checkTwo (String[] args) {
        int n = 0;
        if((args.length >= 2) && args[1].startsWith("--threadsCount=")) {
            try {
                n = Integer.parseInt(args[1].substring("--threadsCount=".length()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.err.println("too few arguments or error of input");
            System.exit(-1);
        }
        return n;
    }
}
