package com.allianz.erp.database.entity;

import com.allianz.erp.util.dbutil.BaseEntity;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table
@AttributeOverride(name= "uuid", column = @Column(name="vat_uuid"))
@Data
public class VATEntity extends BaseEntity {

    @Column
    private int basicNeed = 1;
    @Column
    private int consumerProduct = 8;
    @Column
    private int luxuryItem = 18;

}
