package com.allianz.erp.database.entity;

import com.allianz.erp.model.Enum.ProductTypeEnum;
import com.allianz.erp.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table
@AttributeOverride(name = "uuid", column = @Column(name = "product_uuid"))
@Getter
@Setter
public class ProductEntity extends BaseEntity {
    @Column
    @NotNull
    private String name;
    @Column
    @NotNull
    private int stock;
    @Column
    @NotNull
    private boolean hasVAT;
    @Column
    @NotNull
    private ProductTypeEnum productType;
    @Column
    @NotNull
    private double price;
    @OneToOne(mappedBy = "product")
    private OrderItemEntity orderItem;
}
