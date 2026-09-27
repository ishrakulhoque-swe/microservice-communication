package com.ecom.inventory.ecom_inventory_service.service;

import com.ecom.inventory.ecom_inventory_service.entity.Inventory;
import com.ecom.inventory.ecom_inventory_service.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository repository;


    public Inventory checkStock(Long productId) {
        Optional<Inventory> inv = repository.findById(productId);
        return inv.get();
    }

    public String addProduct(Inventory inventory) {
        repository.save(inventory);
        return "Product Added";
    }

    public String updateProduct( Inventory inventory) {
        repository.save( inventory);
        return "Product Updated";
    }

    public String deleteProduct(Long productId) {
        repository.deleteById(productId);
        return "Product Deleted";
    }
}
