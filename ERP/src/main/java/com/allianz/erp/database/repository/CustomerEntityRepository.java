package com.allianz.erp.database.repository;

import com.allianz.erp.database.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CustomerEntityRepository extends JpaRepository<CustomerEntity, Long> {

    @Modifying
    void deleteByUuid(UUID uuid);

    Optional<CustomerEntity> findByUuid(UUID uuid);

    List<CustomerEntity> findAllByNameStartingWith(String key);

    List<CustomerEntity> findAllByNameStartingWithOrSurnameStartingWith(String name, String surname);



}
