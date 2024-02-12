package com.assignment.backend.app.dao;

import com.assignment.backend.app.enums.OrderType;
import com.assignment.backend.app.model.Order;
import com.assignment.backend.app.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderDao {

    @Autowired
    OrderRepository orderRepository;
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public List<Order> getOrdersByOrderType(OrderType orderType) {
        return orderRepository.findAllByOrderType(orderType);
    }

    public Order getOrderByOrderId(String orderId) {
        return orderRepository.findById(orderId).orElse(null);
    }

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }
}
