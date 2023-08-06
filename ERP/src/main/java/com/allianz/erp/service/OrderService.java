package com.allianz.erp.service;

import com.allianz.erp.database.entity.OrderEntity;
import com.allianz.erp.database.entity.OrderItemEntity;
import com.allianz.erp.database.repository.OrderEntityRepository;
import com.allianz.erp.model.Enum.OrderStatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class OrderService {

    @Autowired
    OrderEntityRepository orderEntityRepository;
    @Autowired
    OrderItemService orderItemService;
    @Autowired
    InvoiceService invoiceService;

    // Create a new order with a default PENDING order status
    public OrderEntity createOrder() {
        OrderEntity order = new OrderEntity();
        order.setOrderStatus(OrderStatusEnum.PENDING);

        orderEntityRepository.save(order);

        return order;
    }

    // Get an order by its UUID
    public OrderEntity getOrderByUUID(UUID uuid) {
        Optional<OrderEntity> orderEntityOptional = orderEntityRepository.findByUuid(uuid);

        return orderEntityOptional.orElse(null);
    }

    // Add an item to the order and update the order's status if the item is in stock
    @Transactional
    public OrderEntity addItemToOrder(UUID uuid, UUID orderItemUUID) {
        OrderEntity order = getOrderByUUID(uuid);
        OrderItemEntity orderItem = orderItemService.getOrderItemByUUID(orderItemUUID);
        if (orderItem.getProduct().getStock() <= 0) {
            throw new IllegalArgumentException("Cannot add item. Insufficient stock.");
        }

        order.getOrderItemList().add(orderItem);
        orderItem.setOrder(order);

        return order;
    }

    // Approve an order, check if all items are in stock, update stock, and create an invoice
    @Transactional
    public OrderEntity approveOrder(UUID uuid) {
        OrderEntity order = getOrderByUUID(uuid);
        boolean allItemsInStock = allItemsInStock(order.getOrderItemList());
       // If any item is not in stock, cancel the order and throw an exception
        if (!allItemsInStock) {
            order.setOrderStatus(OrderStatusEnum.CANCELLED);
            throw new IllegalArgumentException("Your order has been cancelled due to insufficient stock.");
        }
        // All items are in stock, so update stock and set the order status to APPROVED
        updateStockOfOrderItems(order.getOrderItemList());
        order.setOrderStatus(OrderStatusEnum.APPROVED);
        // Create an invoice for the approved order
        invoiceService.createInvoice(order);
        return order;
    }

    // Helper method to check if all items in the order are in stock
    public boolean allItemsInStock(List<OrderItemEntity> orderItemEntityList) {
        //Checks if items are in stock
        for (OrderItemEntity orderItem : orderItemEntityList) {
            if (orderItem.getProduct().getStock() <= 0) {
                return false;
            }
        }
        return true;
    }

    // Helper method to update the stock of order items after an order is approved
    public void updateStockOfOrderItems(List<OrderItemEntity> orderItemEntityList) {
        for (OrderItemEntity orderItem : orderItemEntityList) {
            orderItem.getProduct().setStock(orderItem.getProduct().getStock() - orderItem.getQuantity());
        }
    }
}
