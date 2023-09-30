package ex05;

import java.util.ArrayList;

public class UsersarrayList implements UsersList {
private ArrayList<User> users = new ArrayList<>();
    @Override
    public void addUser(User user) {
        users.add(user);
    }
    @Override
    public void retrBalance(int id) {
        try {
            System.out.println(users.get(id - 1).getName() + " - " + users.get(id - 1).getBalance());
            System.out.println();
        } catch(Exception err) {
            System.out.println("User not found\n");
        }
    }
    @Override
    public int retrUserAmount() {
        return users.size();
    }

    @Override
    public User getUser(int id) {
            return users.get(id - 1);
    }
}
