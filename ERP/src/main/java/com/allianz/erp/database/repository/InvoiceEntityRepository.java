package com.allianz.erp.database.repository;

import com.allianz.erp.database.entity.InvoiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface InvoiceEntityRepository extends JpaRepository<InvoiceEntity, Long> {
    @Modifying
    void deleteByUuid(UUID uuid);

    Optional<InvoiceEntity> findByUuid(UUID uuid);
}
