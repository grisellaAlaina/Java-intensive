package ex02;

public class User {
    public int identifier;
    public String name;
    public int balance;

    public User(String name, int balance) {
      this.identifier = UserIdsGenerator.getInstance().getId();
      this.name = name;
      this.balance = balance;
    }
    public void UserInfo(){
        System.out.println("User name - " + name + "\n" + "ID - " + identifier + "\n" + "Balance - " + balance);

    }
}
