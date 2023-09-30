package ex04;

public interface TransactionList {
    public void addTrans(Transaction trans);
    public void removeById(String id);
    public Transaction[] transInArr();
    public void delTrans(String uuid);
    public void unValid (String uuid);
}
