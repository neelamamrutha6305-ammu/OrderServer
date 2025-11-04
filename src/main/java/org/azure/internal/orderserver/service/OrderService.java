package org.azure.internal.orderserver.service;

import org.azure.internal.orderserver.model.OrderRequest;
import org.azure.internal.orderserver.model.Response;

public interface OrderService {
    Response placeOrder(OrderRequest orderRequest);
}
