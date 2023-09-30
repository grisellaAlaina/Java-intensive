package ex04;

import java.util.ArrayList;

public class UsersarrayList implements UsersList {
private ArrayList<User> users = new ArrayList<>();
    @Override
    public void addUser(User user) {
        users.add(user);
    }

    @Override
    public void retrUserId(int id) {
        try {
            System.out.println("User with ID " + id + ":");
            users.get(id - 1).UserInfo();
            System.out.println();
        } catch(Exception err) {
            System.out.println("User not found\n");
        }
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
    public void retrUserIndex(int index) {
        System.out.println("User with Index " + index + ":");
        users.get(index).UserInfo();
        System.out.println();
    }

    @Override
    public int retrUserAmount() {
        System.out.println("Number of users is " + users.size());
        System.out.println();
        return 0;
    }
    @Override
    public User getUser(int id) {
        return users.get(id - 1);
    }
}
