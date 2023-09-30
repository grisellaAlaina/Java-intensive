package ex04;

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
                transList.remove(i);
            }
        }
    }

    @Override
    public void unValid(String uuid) {
        for (Transaction i : transList) {
            if (i.getIdentifier().equals(uuid)) {
                i.setUnValid();
            }
        }
    }

    public Transaction[] retrUnvalidArr() {
        Transaction[] arr = new Transaction[transList.size()];
        int i = 0;
        for (Transaction l : transList) {
            if(!l.isValid()) {
                arr[i] = l;
                i++;
            }
        }
        return arr;
    }




}
