package org.azure.internal.orderserver.repository;

public interface BalanceRepository {
    double getBalance();
    void updateBalance(double updateBalance);
}
