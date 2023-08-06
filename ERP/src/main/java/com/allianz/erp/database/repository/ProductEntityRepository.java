package com.allianz.erp.database.repository;

import com.allianz.erp.database.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProductEntityRepository extends JpaRepository<ProductEntity, Long> {

    @Modifying
    void deleteByUuid(UUID uuid);

    Optional<ProductEntity> findByUuid(UUID uuid);

    List<ProductEntity> findAllByNameStartingWith(String key);



}
