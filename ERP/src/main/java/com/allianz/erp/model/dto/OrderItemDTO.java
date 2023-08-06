package com.allianz.erp.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class OrderItemDTO {
    private UUID uuid;
    private OrderDTO order;
    private ProductDTO product;
    private int quantity;
    private double priceAtOrder;
    public OrderItemDTO(){this.uuid = UUID.randomUUID();}
}
