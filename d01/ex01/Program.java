package ex01;



public class Program {
    public static void main(String[] args) throws Exception {
        User user = new User("Trump", 2344);
        User user2 = new User("Goben", 4000);
        System.out.println("user " + user.getName() + " has id " + user.getIdentifier());
        System.out.println("user " + user2.getName() + " has id " + user2.getIdentifier());


    }
}
