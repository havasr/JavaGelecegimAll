package com.allianz.erp.service;

import com.allianz.erp.database.entity.CustomerEntity;
import com.allianz.erp.database.entity.OrderEntity;
import com.allianz.erp.database.repository.CustomerEntityRepository;
import com.allianz.erp.model.Enum.OrderStatusEnum;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CustomerService {

    @Autowired
    CustomerEntityRepository customerEntityRepository;
    @Autowired
    OrderService orderService;

    // Create a new customer
    public CustomerEntity createCustomer(String name, String surname, int birthYear, String email,
                                         String cardNo, String address) {
        if (name == null || name.isEmpty() || surname == null || surname.isEmpty() ||
                email == null || email.isEmpty() || cardNo == null || cardNo.isEmpty() ||
                address == null || address.isEmpty()) {
            throw new ValidationException("All fields are required.");
        }

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

    // Delete a customer by UUID
    @Transactional
    public Boolean deleteCustomerByUUID(UUID uuid) {
        CustomerEntity customerEntity = getCustomerByUUID(uuid);

        if (customerEntity == null) {
            customerEntityRepository.deleteByUuid(uuid);
            return true;
        }
        return false;
    }

    // Get a customer by UUID
    public CustomerEntity getCustomerByUUID(UUID uuid) {
        Optional<CustomerEntity> customerEntityOptional = customerEntityRepository.findByUuid(uuid);

        return customerEntityOptional.orElse(null);
    }

    // Update a customer by UUID
    public CustomerEntity updateCustomerByUUID(UUID uuid, CustomerEntity newCustomerEntity) {
        CustomerEntity customerEntity = getCustomerByUUID(uuid);

        if (customerEntity != null && newCustomerEntity != null) {
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

    // Get a list of customers whose names start with the given key
    public List<CustomerEntity> getCustomerNameStartWith(String key) {
        return customerEntityRepository.findAllByNameStartingWith(key);
    }

    // Get a list of customers whose names start with the given name and surnames start with the given surname
    public List<CustomerEntity> getCustomerNameStartWithAndSurnameStartWith(String name, String surname) {
        return customerEntityRepository.findAllByNameStartingWithOrSurnameStartingWith(name, surname);
    }

    // Place an order for a customer
    public CustomerEntity placeOrderFromCustomer(UUID uuid, UUID orderUUID) {
        // Place an order for a customer
        CustomerEntity customerEntity = getCustomerByUUID(uuid);
        OrderEntity order = orderService.getOrderByUUID(orderUUID);
        // If the customer exists, add the order to their order history and change order status
        if (customerEntity != null) {
            customerEntity.getOrderHistory().add(order);
            order.setCustomer(customerEntity);
            order.setOrderStatus(OrderStatusEnum.CREATED);
            return customerEntity;
        }
        return null;
    }

}
