package com.allianz.erp.model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class BillDTO {
    private UUID uuid;
    private OrderDTO order;
    private double price;

    public BillDTO(){this.uuid = UUID.randomUUID();}

}
