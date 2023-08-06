package com.allianz.erp.database.entity;

import com.allianz.erp.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@AttributeOverride(name= "uuid", column = @Column(name="orderItem_uuid"))
@Getter
@Setter
public class OrderItemEntity extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderEntity order;

    @OneToOne
    @JoinColumn(name = "product_id")
    private ProductEntity product;
    @Column
    private int quantity;
    @Column
    private double priceAtOrder;

}
