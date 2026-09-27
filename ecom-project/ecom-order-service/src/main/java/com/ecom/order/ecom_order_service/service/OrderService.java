package com.ecom.order.ecom_order_service.service;

import com.ecom.order.ecom_order_service.client.InventoryClient;
import com.ecom.order.ecom_order_service.dto.Inventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

//    @Autowired
//    private RestTemplate restTemplate;

    @Autowired
    private RestClient restClient;

    @Autowired
    private InventoryClient inventoryClient;

    public String placeOrder(Long productId){

        // Todo - Call inventory to check if product is available

        // -------- Rest-Template :
        //String response = restTemplate.getForObject("http://localhost:8082/inventory/"+productId, String.class);

        // -------- Rest-Client :
//        ResponseEntity<Inventory> entity = restClient.get()
//                .uri("http://localhost:8082/inventory/{productId}",productId)
//                .retrieve()
//                .toEntity(Inventory.class);

        //System.out.println(entity.getStatusCode());

        // -------- Feign Client :
        Inventory inventory = inventoryClient.getInventory(productId);

        updateInventory(inventory);

        return inventory.getQuantity()>0?
                "Order Placed Successfully":
                "Product Out Of Stock";

    }

    private void updateInventory(Inventory inventory) {
        inventory.setQuantity(inventory.getQuantity()-1);

        String s = inventoryClient.updateInventory(inventory);
    }
}
