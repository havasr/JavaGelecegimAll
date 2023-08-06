package com.allianz.erp.database.entity;

import com.allianz.erp.model.Enum.OrderStatusEnum;
import com.allianz.erp.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@AttributeOverride(name = "uuid", column = @Column(name = "customer_uuid"))
@Getter
@Setter
public class OrderEntity extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItemEntity> orderItemList = new ArrayList<>();

    private OrderStatusEnum orderStatus;

    @OneToOne
    @JoinColumn(name = "invoice_id")
    private InvoiceEntity invoice;

}
