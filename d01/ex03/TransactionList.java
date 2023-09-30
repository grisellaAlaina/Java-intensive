package ex03;

public interface TransactionList {
    public void AddTrans(Transaction trans);
    public void RemoveById(String id);
    public Transaction[] TransinArr();
}
