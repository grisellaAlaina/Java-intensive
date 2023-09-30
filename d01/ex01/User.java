package ex01;

public class User {
    private int identifier;
    private String name;
    private int balance;

    public User(String name, int balance) {
      this.identifier = UserIdsGenerator.getInstance().getId();
      this.name = name;
      this.balance = balance;
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

}
