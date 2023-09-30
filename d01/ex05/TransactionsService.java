package ex05;

import java.util.LinkedList;
import java.util.List;

public class TransactionsService {

    public static UsersList userArr = new UsersarrayList();

    public static void addUser(String name, int balance) {
        User user = new User(name, balance);
        userArr.addUser(user);
    }

    public static void retrieveBalance(int id) {
        userArr.retrBalance(id);
    }

    public static void makeTrans(int sender, int rec, int amount) throws Exception {
            Transaction newTransD = new Transaction(userArr.getUser(rec), userArr.getUser(sender), amount, "debit");
            Transaction newTransC = new Transaction(userArr.getUser(rec), userArr.getUser(sender), amount, "credit");
            newTransC.setIdentifier(newTransD.getIdentifier());
            userArr.getUser(sender).userTrans.addTrans(newTransC);
            userArr.getUser(rec).userTrans.addTrans(newTransD);
    }

    public Transaction[] getAllTrans(int id) {
        return userArr.getUser(id).userTrans.transInArr();
    }

    public static void delTrans(String uuid, int id) {
        userArr.getUser(id).userTrans.delTrans(uuid);
        for (int i = 1; i <= userArr.retrUserAmount(); i++) {
            userArr.getUser(i).userTrans.unValid(uuid);
        }
    }

    public static Transaction[] checkValid() {
        List<Transaction> arr = new LinkedList<>();
        for (int i = 1; i <= userArr.retrUserAmount(); i++) {
            Transaction[] tmp = userArr.getUser(i).userTrans.retrUnvalidArr();
            for (Transaction j : tmp) {
                arr.add(j);
            }
        }
        Transaction[] res = new Transaction[arr.size()];
        int i = 0;
        for (Transaction l : arr) {
            res[i] = l;
            i++;
        }
        return res;
    }
}

