package ex05;

import java.util.UUID;

public class Transaction {
    private UUID uuid = UUID.randomUUID();

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    private String identifier;
    private User recipient;
    private User sender;
    private int transferAmount;
    private boolean valid = true;
    public boolean isValid() {
        return valid;
    }

    public void setUnValid() {
        valid = false;
    }

    public User getRecipient() {
        return recipient;
    }

    public User getSender() {
        return sender;
    }

    public int getTransferAmount() {
        return transferAmount;
    }

    public String getTransType() {
        return transType;
    }

    private String transType;

    public void Trans() throws Exception {
        if (checkAmount()) {
            recipient.setBalance(recipient.getBalance() + transferAmount);
            sender.setBalance(sender.getBalance() + transferAmount);
        }
        else
        throw new Exception("No money - no funny, honey!");
    }

    public void InfoBefore() {
        System.out.println("Sender is " + sender.getName() + " balance is " + sender.getBalance() + "\n" +
                "Rescipient is " + recipient.getName() + " balance is " + recipient.getBalance() + "\n" +
                "transferAmount is " + this.transferAmount
        );
    }

    public void InfoAfter() {
        System.out.println("Transaction ID is " + identifier + "\n");
    }

    public boolean checkAmount() {
        return sender.getBalance() >= transferAmount;
    }

    public Transaction(User recipient, User sender, int transferAmount, String type) throws Exception {
        identifier = uuid.toString();
        this.recipient = recipient;
        this.sender = sender;
        this.transferAmount = transferAmount;
        transType = type;
        InfoBefore();
        Trans();
        InfoAfter();
    }


}

