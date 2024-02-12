package com.assignment.backend.app;

import com.assignment.backend.app.dao.ProductDao;
import com.assignment.backend.app.enums.Category;
import com.assignment.backend.app.model.Product;
import com.assignment.backend.app.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ProductTests {

    @Mock
    private ProductDao productDao;

    @InjectMocks
    private ProductService productService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllProducts() {
        // Mock data
        List<Product> mockProducts = Arrays.asList(
                new Product("1", "Product 1", Category.STAPLES, 100.0),
                new Product("2", "Product 2", Category.DAIRY, 50.0)
        );

        when(productDao.getAllProducts()).thenReturn(mockProducts);

        List<Product> result = productService.getAllProducts();

        assertEquals(2, result.size());
    }

    @Test
    public void testAddProducts() {
        // Mock data
        List<Product> mockProducts = Arrays.asList(
                new Product("1", "Product 1", Category.STAPLES, 100.0),
                new Product("2", "Product 2", Category.DAIRY, 50.0)
        );

        when(productDao.addProducts(mockProducts)).thenReturn(mockProducts);

        List<Product> result = productService.addProducts(mockProducts);

        assertEquals(2, result.size());
    }

    @Test
    public void testGetProductByProductId() {
        String productId = "123";
        Product mockProduct = new Product(productId, "Product 1", Category.STAPLES, 100.0);

        when(productDao.getProductByProductId(productId)).thenReturn(mockProduct);

        Product result = productService.getProductByProductId(productId);

        assertEquals(productId, result.getProductId());
    }

    @Test
    public void testDeleteProductByProductId() {
        String productId = "123";

        productService.deleteProductByProductId(productId);

        verify(productDao, times(1)).deleteProductByProductId(productId);
    }

    @Test
    public void testUpdateProductPriceByProductId() {
        String productId = "123";
        double newPrice = 150.0;
        Product mockProduct = new Product(productId, "Product 1", Category.STAPLES, newPrice);

        when(productDao.updateProductPriceByProductId(productId, newPrice)).thenReturn(mockProduct);

        Product result = productService.updateProductPriceByProductId(productId, newPrice);

        assertEquals(newPrice, result.getPrice());
    }
}
