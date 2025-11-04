package org.azure.internal.orderserver.service;

import org.azure.internal.orderserver.model.OrderRequest;
import org.azure.internal.orderserver.model.Response;
import org.azure.internal.orderserver.repository.BalanceRepository;
import org.springframework.stereotype.Service;


@Service
public class OrderServiceImpl implements OrderService {


    private final BalanceRepository balanceRepository;


    public OrderServiceImpl(BalanceRepository balanceRepository) {
        this.balanceRepository = balanceRepository;
    }


    @Override
    public Response placeOrder(OrderRequest orderRequest) {

        double cb = balanceRepository.getBalance();

        double p = orderRequest.getProduct().getPrice();

        if(cb>=p) {
            double updateBalance = cb - p;
            balanceRepository.updateBalance(updateBalance);

            return new Response(
                    orderRequest.getOrderId(),
                    orderRequest.getProduct().getName(),
                    p,
                    updateBalance,
                    "SUCCESS",
                    String.valueOf(System.currentTimeMillis())
            );
        }

        return new Response(
                orderRequest.getOrderId(),
                orderRequest.getProduct().getName(),
                0,
                cb,
                "FAILED",
                String.valueOf(System.currentTimeMillis())
        );

    }
}
