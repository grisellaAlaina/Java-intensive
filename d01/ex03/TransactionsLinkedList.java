package ex03;

import java.util.LinkedList;

public class TransactionsLinkedList implements TransactionList {
    LinkedList<Transaction> transList = new LinkedList<>();


    @Override
    public void AddTrans(Transaction trans) {
        transList.add(trans);
    }

    @Override
    public void RemoveById(String id) {
        for(Transaction i:transList) {
            if (i.getIdentifier() == id) {
                transList.remove(i);
            }
        }
    }

    @Override
    public Transaction[] TransinArr() {
        return (Transaction[])transList.toArray();
    }
}
