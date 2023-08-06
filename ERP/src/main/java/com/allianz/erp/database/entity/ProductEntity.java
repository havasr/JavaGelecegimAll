package com.allianz.erp.database.entity;

import com.allianz.erp.model.Enum.ProductTypeEnum;
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
    private ProductTypeEnum productType;
    @Column
    private double price;
    @OneToOne(mappedBy = "product")
    private OrderItemEntity orderItem;

}
