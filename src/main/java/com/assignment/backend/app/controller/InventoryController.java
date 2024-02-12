package com.assignment.backend.app.controller;

import com.assignment.backend.app.model.Inventory;
import com.assignment.backend.app.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.aggregation.ArrayOperators;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
    @RequestMapping("/inventory")
public class InventoryController {
    /*
    getAllInventory – Inventory
isStockAvailable - [/productId] – {quantity} – true/false
addStock – {prod_id,qty}
sellStock - {prod_id,qty}*/

    @Autowired
    InventoryService inventoryService;

    @GetMapping("/")
    public ResponseEntity<List<Inventory>> getAllInventory(){
        try{
            List<Inventory> inventory=inventoryService.getAllInventory();
            return ResponseEntity.status(HttpStatus.OK).body(inventory);
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }

    }

    @GetMapping("/{productId}")
    public ResponseEntity<Inventory> getInventoryByProductId(@PathVariable String productId){
        try{
            Inventory inventory=inventoryService.getInventoryByProductId(productId);
            if(inventory==null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            return ResponseEntity.status(HttpStatus.OK).body(inventory);
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }

    }

    @GetMapping("/isStockAvailable/{productId}/{quantity}")
    public boolean isStockAvailable(@PathVariable String productId, @PathVariable int quantity){
        try{
            return inventoryService.isStockAvailable(productId,quantity);
        }
        catch (Exception e){
            System.out.println(e);
        }
        return false;
    }

    @PostMapping("/addStock")
    public void addStock(@RequestBody Inventory inventory){
        try{
            inventoryService.addStock(inventory);
        }
        catch (Exception e){
            System.out.println(e);
        }

    }

    @PostMapping("/sellStock")
    public void sellStock(@RequestBody Inventory inventory){
        try {
            inventoryService.sellStock(inventory);
        }
         catch (Exception e){
            System.out.println(e);
        }
    }

}
