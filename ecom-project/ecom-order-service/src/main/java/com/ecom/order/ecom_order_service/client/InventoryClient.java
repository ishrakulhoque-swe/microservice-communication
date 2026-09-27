package com.ecom.order.ecom_order_service.client;

import com.ecom.order.ecom_order_service.dto.Inventory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "inventory-service", url = "http://localhost:8082")
public interface InventoryClient {

    @GetMapping("/inventory/{productId}")
    public Inventory getInventory(@PathVariable Long productId);

    @PostMapping("/inventory")
    public String updateInventory(@RequestBody Inventory inventory);
}
