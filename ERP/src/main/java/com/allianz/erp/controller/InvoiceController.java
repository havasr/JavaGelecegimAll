package com.allianz.erp.controller;

import com.allianz.erp.database.entity.InvoiceEntity;
import com.allianz.erp.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("invoice")
public class InvoiceController {
    @Autowired
    InvoiceService invoiceService;

    //Get Invoice by UUID
    @GetMapping("invoice-uuid/{uuid}")
    public ResponseEntity<InvoiceEntity> getInvoiceByUUID(@PathVariable UUID uuid) {
        InvoiceEntity invoiceEntity = invoiceService.getInvoiceByUUID(uuid);
        if (invoiceEntity != null) {
            return new ResponseEntity<>(invoiceEntity, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
