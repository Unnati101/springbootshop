package com.example.springbootshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootshop.model.Order;
import com.example.springbootshop.service.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    // Checkout preview
    @PostMapping("/checkout")
    public Order checkout(@RequestBody Order order) {
        return orderService.checkout(order);
    }

    // Place order
    @PostMapping("/place")
    public Order placeOrder(@RequestBody Order order) {
        return orderService.placeOrder(order);
    }

    // Check order
    @GetMapping("/{id}")
    public Order checkOrder(@PathVariable Long id) {
        return orderService.checkOrder(id);
    }

    // Update order status
    @PutMapping("/{id}")
    public Order updateOrder(@PathVariable Long id, @RequestParam String status) {
        return orderService.updateOrder(id, status);
    }

    // Order history
    @GetMapping("/history/{userId}")
    public List<Order> getOrderHistory(@PathVariable Long userId) {
        return orderService.getOrderHistory(userId);
    }
}
