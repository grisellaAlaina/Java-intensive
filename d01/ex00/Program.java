package ex00;

public class Program {
    public static void main(String[] args) throws Exception {
        User user = new User("Trump", 2344);
        User user2 = new User("Goben", 4000);
        User user3 = new User("Sadboy", 43423);

        System.out.println(user.getName() + " " + user.getBalance());
        System.out.println(user2.getName() + " " + user2.getBalance());
        Transaction trans1 = new Transaction(user, user2, 1000, "debit");
        System.out.println(user.getName() + " " + user.getBalance());
        System.out.println(user2.getName() + " " + user2.getBalance());
        System.out.println();

        System.out.println(user.getName() + " " + user.getBalance());
        System.out.println(user3.getName() + " " + user3.getBalance());
        Transaction trans2 = new Transaction(user, user3, 1000, "credit");
        System.out.println(user.getName() + " " + user.getBalance());
        System.out.println(user3.getName() + " " + user3.getBalance());
        System.out.println();

//        System.out.println(user.getName() + " " + user.getBalance());
//        System.out.println(user2.getName() + " " + user2.getBalance());
//        Transaction trans3 = new Transaction(user, user2, 10000, "debit");
//        System.out.println(user.getName() + " " + user.getBalance());
//        System.out.println(user2.getName() + " " + user2.getBalance());


    }
}
