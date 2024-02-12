package com.assignment.backend.app.controller;

import com.assignment.backend.app.model.Product;
import com.assignment.backend.app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.SortedMap;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping(path = "/")
    public ResponseEntity<List<Product>> getAllProducts(){
        try{
            List<Product> products=productService.getAllProducts();
            return ResponseEntity.status(HttpStatus.OK).body(products);
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PostMapping(path = "/")
    public ResponseEntity<List<Product>> addProducts(@RequestBody List<Product> products){
        try{
            List<Product> newProducts=productService.addProducts(products);
            return ResponseEntity.status(HttpStatus.CREATED).body(newProducts);
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Product> getProductByProductId(@PathVariable String productId){
        try{
            Product product=productService.getProductByProductId(productId);
            if(product==null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            return ResponseEntity.status(HttpStatus.OK).body(product);
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }

    }

    @PutMapping("/{productId}")
    public ResponseEntity<Product> updateProductPriceByProductId(@PathVariable String productId,@RequestBody double price){
        try{
            Product updatedProduct=productService.updateProductPriceByProductId(productId,price);
            if(updatedProduct==null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            return ResponseEntity.status(HttpStatus.OK).body(updatedProduct);
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<Product> deleteProductByProductId(@PathVariable String productId){
        try{
            productService.deleteProductByProductId(productId);
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }


}
