package com.assignment.backend.app.repository;

import com.assignment.backend.app.enums.OrderType;
import com.assignment.backend.app.model.Inventory;
import com.assignment.backend.app.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface OrderRepository extends MongoRepository<Order, String> {
    List<Order> findAllByOrderType(OrderType orderType);
//    List<Order> findAll();
}
