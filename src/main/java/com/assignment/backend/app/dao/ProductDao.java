package com.assignment.backend.app.dao;

import com.assignment.backend.app.model.Product;
import com.assignment.backend.app.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProductDao {

    @Autowired
    ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    public List<Product> addProducts(List<Product> products){
        return productRepository.saveAll(products);
    }

    public Product getProductByProductId(String productId){
        return productRepository.findById(productId).orElse(null);
    }
    public void deleteProductByProductId(String productId){
        productRepository.deleteById(productId);
    }

    public Product updateProductPriceByProductId(String productId, double price) {
        Optional<Product> byId = productRepository.findById(productId);
        if(byId.isPresent()){
            Product product = byId.get();
            product.setPrice(price);
            productRepository.save(product);
            return product;
        }
        return null;
    }
}
