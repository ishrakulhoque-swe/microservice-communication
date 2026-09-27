package com.ecom.order.ecom_order_service.controller;

import com.ecom.order.ecom_order_service.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/{productId}")
    public String placeOrder(@PathVariable Long productId){

        return orderService.placeOrder(productId);
    }
}
