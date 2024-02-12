package com.assignment.backend.app.repository;

import com.assignment.backend.app.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProductRepository extends MongoRepository<Product, String> {
    List<Product> findAll();
}
