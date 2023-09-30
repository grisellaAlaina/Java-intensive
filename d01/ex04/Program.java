package ex04;


public class Program {
    public static void main(String[] args) throws Exception {
        TransactionsService mainServ = new TransactionsService();
        mainServ.addUser("Trump", 2344);
        mainServ.addUser("Goben", 4000);
        mainServ.addUser("Sanboy", 43423);
        mainServ.retrieveBalance(2);
        mainServ.makeTrans(1, 2, 300);
        mainServ.makeTrans(3, 1, 234);
        Transaction[] arr = mainServ.getAllTrans(1);
        for (Transaction i : arr) {
            if (i.getTransType() == "debit") {
                System.out.println("From " + i.getSender().getName() + " - " + i.getTransType());
            } else {
                System.out.println("To " + i.getRecipient().getName() + " - " + i.getTransType());
            }
        }
        String tmp = arr[0].getIdentifier();
        mainServ.delTrans(tmp, 1);
        arr = mainServ.getAllTrans(1);
        for (Transaction i : arr) {
            if (i.getTransType() == "debit") {
                System.out.println("From " + i.getSender().getName() + " - " + i.getTransType());
            } else {
                System.out.println("To " + i.getRecipient().getName() + " - " + i.getTransType());
            }
        }
        mainServ.makeTrans(2, 1, 21312312);










    }
}
