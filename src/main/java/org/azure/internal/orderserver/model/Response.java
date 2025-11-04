package org.azure.internal.orderserver.model;

public class Response {

    private String orderId;
    private String ProductName;
    private double debitedAmount;
    private double balance;
    private String status;
    private String timestamp;


    public Response(){}


    public Response(String orderId, String productName, double debitedAmount, double balance, String status, String timestamp) {
        this.orderId = orderId;
        ProductName = productName;
        this.debitedAmount = debitedAmount;
        this.balance = balance;
        this.status = status;
        this.timestamp = timestamp;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getProductName() {
        return ProductName;
    }

    public double getDebitedAmount() {
        return debitedAmount;
    }

    public double getBalance() {
        return balance;
    }

    public String getStatus() {
        return status;
    }

    public String getTimestamp() {
        return timestamp;
    }
}
