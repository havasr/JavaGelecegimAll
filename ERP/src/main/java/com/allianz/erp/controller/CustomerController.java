package com.allianz.erp.controller;

import com.allianz.erp.database.entity.CustomerEntity;
import com.allianz.erp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    // Create a new customer
    @PostMapping("create")
    public ResponseEntity<CustomerEntity> createCustomer(@RequestBody CustomerEntity customer) {
        CustomerEntity customer1 = customerService.createCustomer(customer.getName(), customer.getSurname(),
                customer.getBirthYear(), customer.getEmail(), customer.getCardNo(), customer.getAddress());
        return new ResponseEntity<>(customer1, HttpStatus.CREATED);
    }

    // Delete a customer by UUID
    @DeleteMapping("delete/{uuid}")
    public ResponseEntity<Boolean> deleteCustomer(@PathVariable UUID uuid) {
        Boolean isDeleted = customerService.deleteCustomerByUUID(uuid);
        if (isDeleted) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }

    // Update a customer by UUID
    @PutMapping("update/{uuid}")
    public ResponseEntity<CustomerEntity> updateCustomerByUUID
    (@PathVariable UUID uuid, @RequestBody CustomerEntity newCustomerEntity) {
        CustomerEntity customerEntity = customerService.updateCustomerByUUID(uuid, newCustomerEntity);
        if (customerEntity != null) {
            return new ResponseEntity<>(customerEntity, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    // Search for a customer by UUID
    @GetMapping("customer-uuid/{uuid}")
    public ResponseEntity<CustomerEntity> getCustomerByUUID(@PathVariable UUID uuid) {
        CustomerEntity customerEntity = customerService.getCustomerByUUID(uuid);
        if (customerEntity != null) {
            return new ResponseEntity<>(customerEntity, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    // Get a list of customers whose names start with a given key
    @GetMapping("customer-list-by-name-start-with/{key}")
    public ResponseEntity<List<CustomerEntity>> getCustomerListByNameStartWith(@PathVariable String key) {
        return new ResponseEntity<>(customerService.getCustomerNameStartWith(key), HttpStatus.OK);
    }

    // Get a list of customers whose names start with a given key and surnames start with another given key
    @GetMapping("customer-list-by-name-surname-start-with/name/{name}/surname/{surname}")
    public ResponseEntity<List<CustomerEntity>> getCustomerListNameStartWithAndSurnameStartWith(@PathVariable String name, @PathVariable String surname) {
        return new ResponseEntity<>(customerService.getCustomerNameStartWithAndSurnameStartWith(name, surname), HttpStatus.OK);
    }

}
