package com.allianz.erp.database.entity;

import com.allianz.erp.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@AttributeOverride(name= "uuid", column = @Column(name="customer_uuid"))
@Data
public class BillEntity extends BaseEntity {

    @OneToOne(mappedBy = "bill")
    private OrderEntity order;

}
