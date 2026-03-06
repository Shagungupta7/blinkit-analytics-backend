package com.blinkit.blinkit_analytics_backend.controller;
import com.blinkit.blinkit_analytics_backend.model.Order;
import com.blinkit.blinkit_analytics_backend.repository.OrderRepository;
import com.blinkit.blinkit_analytics_backend.service.OrderService;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;
    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }

    @PostMapping
    public Order createOrder(@RequestBody Order order){
        return orderService.saveOrder(order);
    }

    @GetMapping
    public List<Order> getAllOrders(){
        return orderService.getAllOrders();
    }
}
