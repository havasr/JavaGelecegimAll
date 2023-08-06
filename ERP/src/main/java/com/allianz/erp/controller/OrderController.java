package com.allianz.erp.controller;

import com.allianz.erp.database.entity.OrderEntity;
import com.allianz.erp.database.entity.ProductEntity;
import com.allianz.erp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    OrderService orderService;

    // Create a new order
    @PostMapping("create")
    public ResponseEntity<OrderEntity> createOrder(@RequestBody OrderEntity order) {
        OrderEntity order1 = orderService.createOrder();
        return new ResponseEntity<>(order1, HttpStatus.CREATED);
    }
    // Get order by UUID
    @GetMapping("order-uuid/{uuid}")
    public ResponseEntity<OrderEntity> getOrderByUUID(@PathVariable UUID uuid) {
        OrderEntity orderEntity = orderService.getOrderByUUID(uuid);
        if (orderEntity != null) {
            return new ResponseEntity<>(orderEntity, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    // Add an item to an existing order
    @PutMapping("add-item-to-order/{orderUuid}/{orderItemUuid}")
    public ResponseEntity<OrderEntity> addItemToOrder
            (@PathVariable UUID orderUuid, @PathVariable UUID orderItemUuid) {
        OrderEntity orderEntity = orderService.addItemToOrder(orderUuid, orderItemUuid);
        if (orderEntity != null) {
            return new ResponseEntity<>(orderEntity, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    // Approve an order by UUID
    @PutMapping("approve-order/{uuid}")
    public ResponseEntity<OrderEntity> approveOrder(@PathVariable UUID uuid) {
        OrderEntity orderEntity = orderService.approveOrder(uuid);
        if (orderEntity != null) {
            return new ResponseEntity<>(orderEntity, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

}
