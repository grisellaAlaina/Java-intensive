package ex05;

public interface TransactionList {
    public Transaction[] transInArr();
    public void addTrans(Transaction trans);
    public void removeById(String id);
    public void delTrans(String uuid);
}
