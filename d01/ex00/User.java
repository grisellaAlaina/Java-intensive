package ex00;

public class User {
    private static int idCount = 0;
    private int identifier = 0;
    private String name = "";
    private int balance = 0;

    public static int getIdCount() {
        return idCount;
    }

    public int getIdentifier() {
        return identifier;
    }

    public String getName() {
        return name;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public User(String name, int balance) {
      this.identifier = idCount;
      ++idCount;
      this.name = name;
      this.balance = balance;
    }
}
