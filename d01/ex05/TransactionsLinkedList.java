package ex05;

import java.util.LinkedList;

public class TransactionsLinkedList implements TransactionList {
    LinkedList<Transaction> transList = new LinkedList<>();


    @Override
    public void addTrans(Transaction trans) {
        transList.add(trans);
    }

    @Override
    public void removeById(String id) {
        for(Transaction i:transList) {
            if (i.getIdentifier() == id) {
                transList.remove(i);
            }
        }
    }

    @Override
    public Transaction[] transInArr() {
        Transaction[] arr = new Transaction[transList.size()];
        int i = 0;
        for (Transaction l : transList) {
            arr[i] = l;
            i++;
        }
        return arr;
    }

    @Override
    public void delTrans(String uuid) {
        for (Transaction i : transList) {
            if (i.getIdentifier().equals(uuid)) {
                if (i.getTransType() == "debit") {
                    System.out.println("Transfer From " + i.getSender().getName() + "(id = " + i.getSender().getIdentifier() + ")" + " " + i.getTransferAmount() + " removed");
                    System.out.println();
                } else {
                    System.out.println("Transfer To " + i.getRecipient().getName() + "(id = " + i.getRecipient().getIdentifier() + ")" + " " + i.getTransferAmount() + " removed");
                    System.out.println();
                }
                transList.remove(i);
            }
        }
    }

    public Transaction[] retrUnvalidArr() {
        int count = 0;
        for (Transaction l : transList) {
            if (!l.isValid()) count++;
        }
        Transaction[] arr = new Transaction[count];
        int i = 0;
        for (Transaction l : transList) {
            if(!l.isValid()) {
                arr[i] = l;
                i++;
            }
        }
        return arr;
    }

    public void unValid(String uuid) {
        for (Transaction i : transList) {
            if (i.getIdentifier().equals(uuid)) {
                i.setUnValid();
                System.out.println(" HERE WE ARE " + i.isValid());
            }
        }
    }


}
