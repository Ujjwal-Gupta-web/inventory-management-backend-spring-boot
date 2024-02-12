package com.assignment.backend.app.service;

import com.assignment.backend.app.dao.ProductDao;
import com.assignment.backend.app.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Component
public class ProductService {

    @Autowired
    ProductDao productDao;

    public List<Product> getAllProducts(){
        return productDao.getAllProducts();
    }

    public List<Product> addProducts(List<Product> products){
        return productDao.addProducts(products);
    }

    public Product getProductByProductId(String productId){
        return productDao.getProductByProductId(productId);
    }

    public void deleteProductByProductId(String productId){
        productDao.deleteProductByProductId(productId);
    }

    public Product updateProductPriceByProductId(String productId, double price) {
        return productDao.updateProductPriceByProductId(productId,price);
    }
}
