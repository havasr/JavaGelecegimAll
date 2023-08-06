package com.allianz.erp.service;

import com.allianz.erp.database.entity.CustomerEntity;
import com.allianz.erp.database.repository.CustomerEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CustomerService {

    @Autowired
    CustomerEntityRepository customerEntityRepository;

    public CustomerEntity createCustomer(String name, String surname, int birthYear, String email,
                                         int cardNo, String address) {
        CustomerEntity customer = new CustomerEntity();
        customer.setName(name);
        customer.setSurname(surname);
        customer.setBirthYear(birthYear);
        customer.setEmail(email);
        customer.setCardNo(cardNo);
        customer.setAddress(address);

        customerEntityRepository.save(customer);

        return customer;
    }


    @Transactional
    public Boolean deleteCustomerByUUID(UUID uuid) {
        CustomerEntity customerEntity = getCustomerByUUID(uuid);

        if (customerEntity != null) {

            customerEntityRepository.deleteByUuid(uuid);

            return true;
        }
        return false;
    }

    public CustomerEntity getCustomerByUUID(UUID uuid) {
        Optional<CustomerEntity> customerEntityOptional = customerEntityRepository.findByUuid(uuid);

        return customerEntityOptional.orElse(null);
    }


    public CustomerEntity updateCustomerByUUID(UUID uuid, CustomerEntity newCustomerEntity) {
        CustomerEntity customerEntity = getCustomerByUUID(uuid);

        if (customerEntity != null) {
            customerEntity.setName(newCustomerEntity.getName());
            customerEntity.setSurname(newCustomerEntity.getSurname());
            customerEntity.setBirthYear(newCustomerEntity.getBirthYear());
            customerEntity.setEmail(newCustomerEntity.getEmail());
            customerEntity.setCardNo(newCustomerEntity.getCardNo());
            customerEntity.setAddress(newCustomerEntity.getAddress());

            customerEntityRepository.save(customerEntity);

            return customerEntity;
        }
        return null;
    }

    public List<CustomerEntity> getCustomerNameStartWith(String key) {
        return customerEntityRepository.findAllByNameStartingWith(key);
    }

    public List<CustomerEntity> getCustomerNameStartWithAndSurnameStartWith(String name, String surname) {
        return customerEntityRepository.findAllByNameStartingWithOrSurnameStartingWith(name, surname);
    }


}
