package org.azure.internal.orderserver.repository;

import org.springframework.stereotype.Repository;

@Repository
public class BalanceRepositoryImpl implements BalanceRepository {

    private double balance;

    @Override
    public double getBalance() {
        return 1500.00;
    }

    @Override
    public void updateBalance(double updateBalance) {
        this.balance = updateBalance;


    }
}
