package com.allianz.erp.service;

import com.allianz.erp.database.entity.OrderEntity;
import com.allianz.erp.database.entity.OrderItemEntity;
import com.allianz.erp.database.entity.ProductEntity;
import com.allianz.erp.database.repository.OrderItemEntityRepository;
import com.allianz.erp.model.OrderStatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class OrderItemService {

    @Autowired
    OrderItemEntityRepository orderItemEntityRepository;
    @Autowired
    ProductService productService;

    public OrderItemEntity createOrderItem(UUID productUuid, int quantity) {
        ProductEntity product = productService.getProductByUUID(productUuid);
        OrderItemEntity orderItem =  new OrderItemEntity();
        orderItem.setProduct(product);
        orderItem.setQuantity(quantity);
        orderItem.setPriceAtOrder(product.getPrice());

        orderItemEntityRepository.save(orderItem);

        return orderItem;
    }

    public OrderItemEntity getOrderItemByUUID(UUID uuid) {
        Optional<OrderItemEntity> orderItemEntityOptional = orderItemEntityRepository.findByUuid(uuid);

        return orderItemEntityOptional.orElse(null);
    }


}
