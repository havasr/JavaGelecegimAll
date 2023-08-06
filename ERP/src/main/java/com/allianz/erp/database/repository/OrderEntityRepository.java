package com.allianz.erp.database.repository;

import com.allianz.erp.database.entity.OrderEntity;
import com.allianz.erp.database.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface OrderEntityRepository extends JpaRepository<OrderEntity, Long> {

    @Modifying
    void deleteByUuid(UUID uuid);

    Optional<OrderEntity> findByUuid(UUID uuid);

}
