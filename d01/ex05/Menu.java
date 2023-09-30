package ex05;

import java.util.*;

public class Menu {
    TransactionsService mainServ = new TransactionsService();
    private final Scanner sc = new Scanner(System.in);
    private static String mode_ = "";

    private void printMenu() {
        String str1 = "1.Add a user";
        String str2 = "2.View user balances";
        String str3 = "3.Perform a transfer";
        String str4 = "4.View all transactions for a specific user";
        String str5 = "5.DEV - remove a transfer by ID";
        String str6 = "6.DEV - check transfer validity";
        String str7dev = "7.Finish execution";
        String str7 = "5.Finish execution";
        if (mode_.equals("dev-mode")) {
            System.out.println(str1 + "\n" + str2 + "\n" + str3 + "\n"
                    + str4 + "\n" + str5 + "\n" + str6 + "\n" + str7dev);
        } else {
            System.out.println(str1 + "\n" + str2 + "\n"
                    + str3 + "\n" + str4 + "\n" + str7);
        }
    }

    private void startFullMode() throws Exception {
        printMenu();
        while(true) {
            String menuIn = sc.next();
            switch (menuIn) {
                case "1":
                    addUser();
                    break;
                case "2":
                    userBalans();
                    break;
                case "3":
                    transact();
                    break;
                case "4":
                    userTransactions();
                    break;
                case "5":
                    sc.close();
                    System.exit(0);
                default:
                    System.err.println("Illegal argumentt");
                    System.out.println("Try again");
            }
            System.out.println("-----------------------------------");
            printMenu();
        }
    }

    void startDevMode() throws Exception {
        printMenu();
        while (true) {
            String itemMenu = sc.next();
                switch (itemMenu) {
                    case "1":
                        addUser();
                        break;
                    case "2":
                        userBalans();
                        break;
                    case "3":
                        transact();
                        break;
                    case "4":
                        userTransactions();
                        break;
                    case "5":
                        removeTransfer();
                        break;
                    case "6":
                        checkTransfer();
                        break;
                    case "7":
                        sc.close();
                        System.exit(0);
                    default:
                        System.err.println("Illegal argumentt");
                        System.out.println("Try again");
                }
            System.out.println("-----------------------------------");
            printMenu();
        }
    }


    private void checkTransfer() {
        Transaction[] tmp = mainServ.checkValid();
        for (Transaction i : tmp) {
            if (i.getTransType() == "debit") {
                System.out.println(i.getSender().getName() + "(id = " + i.getSender().getIdentifier() + ")" + " has an unacknowledged transfer id = " + i.getIdentifier() + " from " +
                        i.getRecipient().getName() + "(id = " + i.getRecipient().getIdentifier() + ")" + " " + i.getTransferAmount());
                System.out.println();
            } else {
                System.out.println(i.getRecipient().getName() + "(id = " + i.getRecipient().getIdentifier() + ")" + " has an unacknowledged transfer id = " + i.getIdentifier() + " from " +
                        i.getSender().getName() + "(id = " + i.getSender().getIdentifier() + ")" + " " + i.getTransferAmount());
                System.out.println();
            }
        }
    }

    private void addUser() {
        try {
            System.out.println("Enter a user name and a balance");
            String uName = sc.next();
            int uBalance = sc.nextInt();
            mainServ.addUser(uName, uBalance);
            int id = mainServ.userArr.retrUserAmount();
            System.out.println("User with id = " + id + " is added");
        } catch (InputMismatchException wa) {
            System.out.println("wrong argument");
            addUser();
        }
    }

    private void userBalans() {
        try {
            System.out.println("Enter a user ID");
            int id = sc.nextInt();
            String name = mainServ.userArr.getUser(id).getName();
            int balance = mainServ.userArr.getUser(id).getBalance();
            System.out.println(name + " - " + balance);
        } catch (IndexOutOfBoundsException lol) {
            System.out.println("User not found");
            userBalans();
        } catch (InputMismatchException wa) {
            System.out.println("wrong argument");
        }
    }

    void transact() throws Exception {
        try {
            System.out.println("Enter a sender ID, a recipient ID, and a transfer amount");
            int senderId = sc.nextInt();
            int recipientId = sc.nextInt();
            int transferAmount = sc.nextInt();
            mainServ.makeTrans(senderId, recipientId, transferAmount);
            System.out.println("The transfer is completed");
        } catch (IndexOutOfBoundsException lol) {
            System.out.println("User not found");
            transact();
        } catch (InputMismatchException wa) {
            System.out.println("wrong argument");
        }
    }

    void userTransactions() {
        try {
            System.out.println("Enter a user ID");
            int id = sc.nextInt();
            Transaction[] arr = mainServ.getAllTrans(id);
            for (Transaction i : arr) {
                if (i.getTransType() == "debit") {
                    System.out.println("From " + i.getSender().getName() + "(id = " + i.getSender().getIdentifier() + ") - " + i.getTransferAmount() + " with id = " + i.getIdentifier());
                } else {
                    System.out.println("To " + i.getRecipient().getName() + "(id = " + i.getRecipient().getIdentifier() + ") - " + i.getTransferAmount() + " with id = " + i.getIdentifier());
                }
            }
        } catch (IndexOutOfBoundsException lol) {
            System.out.println("User not found");
            userTransactions();
        } catch (InputMismatchException wa) {
            System.out.println("wrong argument");
            userTransactions();
        }
    }

    void removeTransfer() {
        System.out.println("Enter a user ID and a transfer ID");
        int uid = sc.nextInt();
        String tid = sc.next();
        mainServ.delTrans(tid, uid);
    }


    public void menuRun(String[] args) throws Exception {
        if (args.length > 0) {
            mode_ = args[0];
        }
        if (mode_.equals("dev-mode")) {
            startDevMode();
        } else {
            startFullMode();
        }
    }



}
