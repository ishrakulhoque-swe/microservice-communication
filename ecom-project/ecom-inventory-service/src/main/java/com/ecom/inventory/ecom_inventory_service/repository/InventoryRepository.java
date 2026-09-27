package com.ecom.inventory.ecom_inventory_service.repository;

import com.ecom.inventory.ecom_inventory_service.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory,Long> {
}
