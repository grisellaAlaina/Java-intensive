package ex03;


public class Program {
    public static void main(String[] args) throws Exception {
        UserIdsGenerator userIdsGenerator;
        User newuser = new User("Trump", 2344);
        User newuser2 = new User("Goben", 4000);
        User newuser3 = new User("Sadboy", 43423);
        UsersList UserArr = new UsersarrayList();
        UserArr.AddUser(newuser);
        UserArr.AddUser(newuser2);
        UserArr.AddUser(newuser3);
        UserArr.RetrUserId(2);
        UserArr.RetrUserIndex(0);
        UserArr.RetrUserAmount();
        Transaction newTrans = new Transaction(newuser2, newuser, 342);
        TransactionList transBase = new TransactionsLinkedList();
        transBase.AddTrans(newTrans);
        transBase.RemoveById(newTrans.getIdentifier());






    }
}
