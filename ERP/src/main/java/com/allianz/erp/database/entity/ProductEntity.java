package com.allianz.erp.database.entity;

import com.allianz.erp.model.OrderStatusEnum;
import com.allianz.erp.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Table
@AttributeOverride(name= "uuid", column = @Column(name="product_uuid"))
@Data
public class ProductEntity extends BaseEntity {

    @Column
    private UUID uuid;
    @Column
    private String name;
    @Column
    private int stock;
    @Column
    private boolean hasVAT;
    @Column
    private double price;
    @Column
    private OrderStatusEnum orderStatus;
    @OneToOne(mappedBy = "product")
    private OrderItemEntity orderitem;

}
