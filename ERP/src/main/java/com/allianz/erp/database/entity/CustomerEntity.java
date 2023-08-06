package com.allianz.erp.database.entity;

import com.allianz.erp.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@AttributeOverride(name = "uuid", column = @Column(name = "customer_uuid"))
@Getter
@Setter
public class CustomerEntity extends BaseEntity {
    @Column
    @NotNull
    private String name;
    @Column
    @NotNull
    private String surname;
    @Column
    @NotNull
    private int birthYear;
    @Column
    @NotNull
    private String email;
    @Column
    @NotNull
    private String cardNo;
    @Column
    @NotNull
    private String address;
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderEntity> orderHistory = new ArrayList<>();
}
