package ex02;


public class Program {
    public static void main(String[] args) throws Exception {
        User newuser = new User("Trump", 2344);
        User newuser2 = new User("Goben", 4000);
        User newuser3 = new User("Sadboy", 43423);
        UsersList UserArr = new UsersarrayList();
        UserArr.AddUser(newuser);
        UserArr.AddUser(newuser2);
        UserArr.AddUser(newuser3);
        UserArr.RetrUserId(2);
        UserArr.RetrUserId(2323);
        UserArr.RetrUserIndex(0);
        UserArr.RetrUserAmount();


    }
}
