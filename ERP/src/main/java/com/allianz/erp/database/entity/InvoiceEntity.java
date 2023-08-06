package com.allianz.erp.database.entity;

import com.allianz.erp.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@AttributeOverride(name= "uuid", column = @Column(name="invoice_uuid"))
@Getter
@Setter
public class InvoiceEntity extends BaseEntity {

    @Column
    private int invoiceNo;
    @Column
    private double totalPriceWithVAT;
    @Column
    private double totalPriceWithoutVAT;
    @Column
    private double totalVATAmount;
    @OneToOne(mappedBy = "invoice")
    private OrderEntity order;

}
