package com.allianz.erp.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class InvoiceDTO {
    private UUID uuid;
    private int invoiceNo;
    private double totalPrice;
    private double totalPriceWithoutVAT;
    private OrderDTO order;

    public InvoiceDTO(){this.uuid = UUID.randomUUID();}

}
