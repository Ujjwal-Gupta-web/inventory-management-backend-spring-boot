package com.assignment.backend.app.repository;

import com.assignment.backend.app.model.Inventory;
import com.assignment.backend.app.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface InventoryRepository extends MongoRepository<Inventory, String> {
    Optional<Inventory> findByProductId(String productId);
//    List<Inventory> findAll();
}