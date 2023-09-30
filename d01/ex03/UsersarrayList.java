package ex03;

import java.util.ArrayList;

public class UsersarrayList implements UsersList {
private ArrayList<User> users = new ArrayList<>();
    @Override
    public void AddUser(User user) {
        users.add(user);
    }

    @Override
    public void RetrUserId(int id) {
        try {
            System.out.println("User with ID " + id + ":");
            users.get(id - 1).UserInfo();
            System.out.println();
        } catch(Exception err) {
            System.out.println("User not found\n");
        }
    }

    @Override
    public void RetrUserIndex(int index) {
        System.out.println("User with Index " + index + ":");
        users.get(index).UserInfo();
        System.out.println();
    }

    @Override
    public void RetrUserAmount() {
        System.out.println("Number of users is " + users.size());
        System.out.println();
    }
}
