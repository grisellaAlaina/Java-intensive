package ex00;

import java.util.UUID;
import java.lang.Exception;

public class Transaction {


    public UUID getUuid() {
        return uuid;
    }

    public String getIdentifier() {
        return identifier;
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

    private UUID uuid = UUID.randomUUID();
    private String transType;
    private String identifier = uuid.toString();
    private User recipient;
    private User sender;
    private int transferAmount;

    private void Trans() throws Exception {
        if (checkAmount()) {
            recipient.setBalance(recipient.getBalance() + transferAmount);
            sender.setBalance(sender.getBalance() - transferAmount);
        }
        else
        throw new Exception("No money - no funny, honey!");
    }

    boolean checkAmount() {
        return sender.getBalance() >= transferAmount;
    }

    public Transaction(User recipient, User sender, int transferAmount, String type) throws Exception {
        transType = type;
        this.identifier = uuid.toString();
        this.recipient = recipient;
        this.sender = sender;
        this.transferAmount = transferAmount;
        Trans();
    }
}

