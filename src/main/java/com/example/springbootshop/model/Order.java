package com.example.springbootshop.model;



import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders") 
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    private String orderStatus;

    @ElementCollection
    private List<String> orderHistory = new ArrayList<>();

    private Long userId;

    @ElementCollection
    private List<String> products = new ArrayList<>();

    private double totalAmount; 

    public Order() {}

    // Getters & Setters
    public Long getOrderId() { return orderId; }
    public void setOrderId(Long orderId) { this.orderId = orderId; }

    public String getOrderStatus() { return orderStatus; }
    public void setOrderStatus(String orderStatus) { this.orderStatus = orderStatus; }

    public List<String> getOrderHistory() { return orderHistory; }
    public void setOrderHistory(List<String> orderHistory) { this.orderHistory = orderHistory; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public List<String> getProducts() { return products; }
    public void setProducts(List<String> products) { this.products = products; }

    public double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }
}
