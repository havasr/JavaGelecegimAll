package com.allianz.erp.database.entity;

import com.allianz.erp.util.dbutil.BaseEntity;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@AttributeOverride(name = "uuid", column = @Column(name = "vat_uuid"))
@Getter
@Setter
public class VATEntity extends BaseEntity {

    @Column
    private int basicNeed = 1;
    @Column
    private int consumerProduct = 8;
    @Column
    private int luxuryItem = 18;
    //As per the requirements for the project the VAT values are held in a table
}
