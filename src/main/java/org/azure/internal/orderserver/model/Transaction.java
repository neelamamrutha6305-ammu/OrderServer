package org.azure.internal.orderserver.model;

public class Transaction {
    private double debited;
    private double credited;
    private double balance;
    private String status;
    private String timestamp;

    public double getDebited() {
        return debited;
    }

    public void setDebited(double debited) {
        this.debited = debited;
    }

    public double getCredited() {
        return credited;
    }

    public void setCredited(double credited) {
        this.credited = credited;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}




