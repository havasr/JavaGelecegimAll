package com.allianz.erp.database.entity;

import com.allianz.erp.model.OrderDTO;
import com.allianz.erp.model.ProductDTO;
import com.allianz.erp.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@AttributeOverride(name= "uuid", column = @Column(name="orderItem_uuid"))
@Data
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
