package com.allianz.erp.model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ProductDTO {
    private UUID uuid;
    private String name;
    private int stock;
    private boolean hasVAT;
    private double price;
    private OrderStatusEnum orderStatus;
    public ProductDTO() {
        this.uuid = UUID.randomUUID();
    }
}
