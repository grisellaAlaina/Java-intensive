package ex05;

public class User {
    private int identifier;
    private String name;
    private int balance;

    public TransactionsLinkedList userTrans = new TransactionsLinkedList();

    public User(String name, int balance) {
      this.identifier = UserIdsGenerator.getInstance().getId();
      this.name = name;
      this.balance = balance;
    }

    public void setIdentifier(int identifier) {
        this.identifier = identifier;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setUserTrans(TransactionsLinkedList userTrans) {
        this.userTrans = userTrans;
    }

    public int getIdentifier() {
        return identifier;
    }

    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance;
    }

    public TransactionsLinkedList getUserTrans() {
        return userTrans;
    }
}
