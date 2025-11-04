package org.azure.internal.orderserver.controller;


import org.azure.internal.orderserver.model.OrderRequest;
import org.azure.internal.orderserver.model.Response;
import org.azure.internal.orderserver.service.OrderService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @PostMapping
    public Response createOrder(@RequestBody OrderRequest request) {
        return service.placeOrder(request);
    }
}
