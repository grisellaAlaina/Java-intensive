package ex04;

import java.util.LinkedList;

public class User {
    private int identifier;
    private String name;
    private int balance;

    public int getIdentifier() {
        return identifier;
    }

    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public TransactionsLinkedList userTrans = new TransactionsLinkedList();

    public User(String name, int balance) {
      this.identifier = UserIdsGenerator.getInstance().getId();
      this.name = name;
      this.balance = balance;
    }
    public void UserInfo(){
        System.out.println("User name - " + name + "\n" + "ID - " + identifier + "\n" + "Balance - " + balance);

    }


}
