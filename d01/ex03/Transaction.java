package ex03;

import java.util.UUID;

public class Transaction {
    private UUID uuid = UUID.randomUUID();
    private String identifier = uuid.toString();
    private User recipient;
    private User sender;

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

    public int transferAmount;

    public void Trans() throws Exception {
        if (CheckAmount()) {
            recipient.setBalance(recipient.getBalance() + transferAmount);
            sender.setBalance(sender.getBalance() - transferAmount);
        }
        else
        throw new Exception("No money - no funny, honey!");
    }

    public boolean CheckAmount() {
        return sender.getBalance() >= transferAmount;
    }

    public Transaction(User recipient, User sender, int transferAmount) throws Exception {
        this.identifier = uuid.toString();
        this.recipient = recipient;
        this.sender = sender;
        this.transferAmount = transferAmount;
        Trans();
    }
}

