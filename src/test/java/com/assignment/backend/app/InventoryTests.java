package com.assignment.backend.app;

import com.assignment.backend.app.dao.InventoryDao;
import com.assignment.backend.app.model.Inventory;
import com.assignment.backend.app.repository.InventoryRepository;
import com.assignment.backend.app.service.InventoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class InventoryTests {

    @Mock
    private InventoryDao inventoryDao;

    @InjectMocks
    private InventoryService inventoryService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllInventory() {
        // Mock data
        List<Inventory> mockInventoryList = Arrays.asList(
                new Inventory("1", 10),
                new Inventory("2", 15)
        );

        when(inventoryDao.getAllInventory()).thenReturn(mockInventoryList);

        List<Inventory> result = inventoryService.getAllInventory();

        assertEquals(2, result.size());
    }

    @Test
    public void testGetInventoryByProductId() {
        String productId = "123";
        Inventory mockInventory = new Inventory(productId, 10);

        when(inventoryDao.getInventoryByProductId(productId)).thenReturn(mockInventory);

        Inventory result = inventoryService.getInventoryByProductId(productId);

        assertEquals(productId, result.getProductId());
        assertEquals(10, result.getQuantity());
    }

    @Test
    public void testIsStockAvailable() {
        String productId = "123";
        int quantity = 5;

        when(inventoryDao.isStockAvailable(productId, quantity)).thenReturn(true);

        boolean result = inventoryService.isStockAvailable(productId, quantity);

        assertEquals(true, result);
    }

    @Test
    public void testAddStock() {
        Inventory inventory = new Inventory("123", 10);

        doNothing().when(inventoryDao).addStock(inventory);

        inventoryService.addStock(inventory);

        verify(inventoryDao, times(1)).addStock(inventory);
    }

    @Test
    public void testSellStock() {
        Inventory inventory = new Inventory("123", 5);

        doNothing().when(inventoryDao).sellStock(inventory);

        inventoryService.sellStock(inventory);

        verify(inventoryDao, times(1)).sellStock(inventory);
    }

}
