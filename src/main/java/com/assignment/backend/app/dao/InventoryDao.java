package com.assignment.backend.app.dao;

import com.assignment.backend.app.model.Inventory;
import com.assignment.backend.app.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class InventoryDao {
    @Autowired
    InventoryRepository inventoryRepository;
    public List<Inventory> getAllInventory(){
        return inventoryRepository.findAll();
    }

    public boolean isStockAvailable(String productId, int quantity) {
        if(quantity>0){
            Optional<Inventory> byId = inventoryRepository.findByProductId(productId);
            if(byId.isPresent()) return byId.get().getQuantity()>=quantity;
            return false;
        }
        return true;
    }

    public void addStock(Inventory inventory) {
        Inventory actual_inventory=inventoryRepository.findByProductId(inventory.getProductId()).orElse(null);
        int toAdd=inventory.getQuantity();
        if(actual_inventory!=null){
            int stock_available=actual_inventory.getQuantity();
            actual_inventory.setQuantity(stock_available+toAdd);
            inventoryRepository.save(actual_inventory);
        }
        else {
            inventoryRepository.save(inventory);
        }
    }

    public void sellStock(Inventory inventory) {
        Inventory actual_inventory=inventoryRepository.findByProductId(inventory.getProductId()).orElse(null);
        int toSell=inventory.getQuantity();
        if(actual_inventory!=null){
            int stock_available=actual_inventory.getQuantity();
            actual_inventory.setQuantity(stock_available-toSell);
            inventoryRepository.save(actual_inventory);
        }
    }

    public Inventory getInventoryByProductId(String productId) {
        return inventoryRepository.findByProductId(productId).orElse(null);
    }
}
