package com.assignment.backend.app.service;

import com.assignment.backend.app.dao.InventoryDao;
import com.assignment.backend.app.model.Inventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InventoryService {
    @Autowired
    InventoryDao inventoryDao;
    public List<Inventory> getAllInventory(){
        return inventoryDao.getAllInventory();
    }

    public boolean isStockAvailable(String productId, int quantity) {
        return inventoryDao.isStockAvailable(productId,quantity);
    }

    public void addStock(Inventory inventory) {
        inventoryDao.addStock(inventory);
    }

    public void sellStock(Inventory inventory) {
        inventoryDao.sellStock(inventory);
    }

    public Inventory getInventoryByProductId(String productId) {
        return inventoryDao.getInventoryByProductId(productId);
    }
}
