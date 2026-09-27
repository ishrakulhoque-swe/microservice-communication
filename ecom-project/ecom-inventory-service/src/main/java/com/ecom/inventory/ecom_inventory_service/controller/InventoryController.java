package com.ecom.inventory.ecom_inventory_service.controller;

import com.ecom.inventory.ecom_inventory_service.entity.Inventory;
import com.ecom.inventory.ecom_inventory_service.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @GetMapping("/{productId}")
    public Inventory checkInventory(@PathVariable Long productId){
        return inventoryService.checkStock(productId);
    }


    @PostMapping
    public String addProduct(@RequestBody Inventory inventory){
        return inventoryService.addProduct(inventory);
    }

    @PutMapping()
    public String updateProduct(
            @RequestBody Inventory inventory){
        return inventoryService.updateProduct(inventory);
    }

    @DeleteMapping("/{productId}")
    public String deleteProduct(@PathVariable Long productId){
        return inventoryService.deleteProduct(productId);
    }

}
