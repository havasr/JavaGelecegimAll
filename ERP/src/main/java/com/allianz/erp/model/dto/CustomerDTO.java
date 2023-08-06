package com.allianz.erp.model.dto;

import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CustomerDTO {
    private UUID uuid;
    private String name;
    private String surname;
    private int birthYear;
    private String email;
    private int cardNo;
    private String address;
    public CustomerDTO(){this.uuid = UUID.randomUUID();}

}
