package com.example.springbootshop.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springbootshop.model.Order;
import com.example.springbootshop.repository.OrderRepository;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    // Checkout - just returns preview
    public Order checkout(Order order) {
        order.setOrderStatus("Checkout");
        order.getOrderHistory().add("Checkout preview created");
        return order;
    }

    // for  Placing order
    public Order placeOrder(Order order) {
        order.setOrderStatus("Pending");
        order.getOrderHistory().add("Order placed");
        return orderRepository.save(order);
    }

    // Check order by id
    public Order checkOrder(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    // Update order status
    public Order updateOrder(Long id, String status) {
        Order order = orderRepository.findById(id).orElse(null);
        if (order != null) {
            order.setOrderStatus(status);
            order.getOrderHistory().add("Status updated to: " + status);
            return orderRepository.save(order);
        }
        return null;
    }

    // Order history by user
    public List<Order> getOrderHistory(Long userId) {
        return orderRepository.findByUserId(userId);
    }
}
