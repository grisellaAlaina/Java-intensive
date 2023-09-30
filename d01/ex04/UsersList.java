package ex04;

public interface UsersList {

    public void addUser(User user);
    public void retrUserId(int id);
    public void retrUserIndex(int index);
    public int retrUserAmount();
    public void retrBalance(int id);
    public User getUser(int id);

}
