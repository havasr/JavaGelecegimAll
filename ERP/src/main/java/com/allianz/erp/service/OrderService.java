package com.allianz.erp.service;

import com.allianz.erp.database.entity.OrderEntity;
import com.allianz.erp.database.entity.OrderItemEntity;
import com.allianz.erp.database.repository.OrderEntityRepository;
import com.allianz.erp.model.OrderStatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public OrderEntity createOrder() {
        OrderEntity order = new OrderEntity();
        order.setOrderStatus(OrderStatusEnum.PENDING);

        orderEntityRepository.save(order);

        return order;
    }

    public OrderEntity getOrderByUUID(UUID uuid) {
        Optional<OrderEntity> orderEntityOptional = orderEntityRepository.findByUuid(uuid);

        return orderEntityOptional.orElse(null);
    }

    public OrderEntity addItemToOrder(UUID uuid, UUID orderItemUUID) {
        OrderEntity order = getOrderByUUID(uuid);
        OrderItemEntity orderItem = orderItemService.getOrderItemByUUID(orderItemUUID);
        if (orderItem.getProduct().getStock() > 0) {
            order.getOrderItemList().add(orderItem);
            orderItem.setOrder(order);

            return order;
        }
        System.out.println("Cannot add item. Insufficient stock.");
        return null;
    }

    public OrderEntity approveOrder(UUID uuid) {
        OrderEntity order = getOrderByUUID(uuid);
        boolean allItemsInStock = allItemsInStock(order.getOrderItemList());

        if (allItemsInStock){
            updateStockOfOrderItems(order.getOrderItemList());
            order.setOrderStatus(OrderStatusEnum.APPROVED);
            invoiceService.createInvoice(order);
            return order;
        } else {
            order.setOrderStatus(OrderStatusEnum.CANCELLED);
            System.out.println("Your order has been cancelled due to insufficient stock.");
            return order;
        }
    }

    public boolean allItemsInStock(List<OrderItemEntity> orderItemEntityList){
        //Checks if items are in stock
        for (OrderItemEntity orderItem : orderItemEntityList) {
            if (orderItem.getProduct().getStock() <= 0) {
                return false;
            }
        } return true;
    }

    public void updateStockOfOrderItems(List<OrderItemEntity> orderItemEntityList) {
        for (OrderItemEntity orderItem : orderItemEntityList) {
            orderItem.getProduct().setStock(orderItem.getProduct().getStock() - orderItem.getQuantity());
        }
    }
}
