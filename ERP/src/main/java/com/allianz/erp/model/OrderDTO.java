package com.allianz.erp.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class OrderDTO {
    private UUID uuid;
    private CustomerDTO customer;
    private List<OrderItemDTO> orderItem;
    private OrderStatusEnum orderStatus;
    public OrderDTO(){this.uuid = UUID.randomUUID();}

}
