package org.azure.internal.orderserver.service;

import org.azure.internal.orderserver.model.*;
import org.azure.internal.orderserver.repository.BalanceRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class OrderServerImplTest {

    @Mock
    private BalanceRepository balanceRepository;

    @InjectMocks
    private OrderServiceImpl orderService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    private OrderRequest createRequest(double price) {
        Product product = new Product();
        product.setName("Wireless Headphones");
        product.setPrice(price);

        Customer customer = new Customer();
        customer.setName("John Doe");

        Transaction transaction = new Transaction();
        transaction.setTimestamp("2025-10-28T14:35:00Z");

        OrderRequest request = new OrderRequest();
        request.setOrderId("ORD-20251028-001");
        request.setProduct(product);
        request.setCustomer(customer);
        request.setTransaction(transaction);

        return request;
    }

    @Test
    void testOrderSuccess() {
        OrderRequest request = createRequest(79.99);

        when(balanceRepository.getBalance()).thenReturn(1500.00);

        Response response = orderService.placeOrder(request);

        verify(balanceRepository).updateBalance(1420.01);

        assertEquals("SUCCESS", response.getStatus());
        assertEquals(79.99, response.getDebitedAmount());
        assertEquals(1420.01, response.getBalance());
        assertEquals("ORD-20251028-001", response.getOrderId());
    }

    @Test
    void testOrderFailedDueToLowBalance() {
        OrderRequest request = createRequest(500.00);

        when(balanceRepository.getBalance()).thenReturn(100.00);

        Response response = orderService.placeOrder(request);

        verify(balanceRepository, never()).updateBalance(anyDouble());

        assertEquals("FAILED", response.getStatus());
        assertEquals(0.0, response.getDebitedAmount());
        assertEquals(100.00, response.getBalance());
    }
}
