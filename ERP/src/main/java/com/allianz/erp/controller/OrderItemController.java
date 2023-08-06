package com.allianz.erp.controller;

import com.allianz.erp.database.entity.OrderItemEntity;
import com.allianz.erp.database.entity.ProductEntity;
import com.allianz.erp.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("order-item")
public class OrderItemController {

    @Autowired
    OrderItemService orderItemService;

    //Create order item with product UUID and quantity
    @PostMapping("order-item/{productUuid}/{quantity}")
    public ResponseEntity<OrderItemEntity> createOrderItem(@PathVariable UUID productUuid, @PathVariable Integer quantity) {
        OrderItemEntity orderItem1 = orderItemService.createOrderItem(productUuid, quantity);
        return new ResponseEntity<>(orderItem1, HttpStatus.CREATED);
    }

    //Get order item by UUID
    @GetMapping("order-item-uuid/{uuid}")
    public ResponseEntity<OrderItemEntity> getOrderItemByUUID(@PathVariable UUID uuid) {
        OrderItemEntity orderItemEntity = orderItemService.getOrderItemByUUID(uuid);
        if (orderItemEntity != null) {
            return new ResponseEntity<>(orderItemEntity, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

}
