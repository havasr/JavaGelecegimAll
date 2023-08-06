package com.allianz.erp.service;

import com.allianz.erp.database.entity.*;
import com.allianz.erp.database.repository.InvoiceEntityRepository;
import com.allianz.erp.model.Enum.ProductTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class InvoiceService {
    @Autowired
    InvoiceEntityRepository invoiceEntityRepository;

    // Create an invoice for a given order and calculate the total prices with and without VAT
    public InvoiceEntity createInvoice(OrderEntity order) {
        InvoiceEntity invoice = new InvoiceEntity();
        invoice.setOrder(order);
        order.setInvoice(invoice);

        invoiceEntityRepository.save(invoice);


        double totalPriceWithVAT = 0.0;
        double totalPriceWithoutVAT = 0.0;

        // Calculate total prices for each order item in the order
        List<OrderItemEntity> orderItems = order.getOrderItemList();
        for (OrderItemEntity orderItem : orderItems) {
            totalPriceWithVAT += calculatePriceWithVAT(orderItem);
            totalPriceWithoutVAT += calculatePriceWithoutVAT(orderItem);
            // Print order item details (name, quantity, and unit price)
            System.out.println("Order Item: " + orderItem.getProduct().getName() + ", Quantity: " + orderItem.getQuantity()
                    + ", Unit Price: " + orderItem.getProduct().getPrice());
        }
        invoice.setTotalPriceWithVAT(totalPriceWithVAT);
        invoice.setTotalPriceWithoutVAT(totalPriceWithoutVAT);
        invoice.setTotalVATAmount(totalPriceWithVAT - totalPriceWithoutVAT);
        return invoice;

    }

    // Calculate the price with VAT for a given order item if it already doesn't have VAT included
    public double calculatePriceWithVAT(OrderItemEntity orderItem) {
        ProductEntity product = orderItem.getProduct();
        if (product.isHasVAT()) {
            return product.getPrice();
        } else {
            return addVATToProduct(product);
        }
    }

    // Add VAT to the price of a product based on its product type
    public double addVATToProduct(ProductEntity product) {
        VATEntity vat = new VATEntity();
        if (product.getProductType() == ProductTypeEnum.BASIC_NEED) {
            return product.getPrice() * (vat.getBasicNeed() / 100 + 1);
        } else if (product.getProductType() == ProductTypeEnum.CONSUMER_PRODUCT) {
            return product.getPrice() * (vat.getConsumerProduct() / 100 + 1);
        } else {
            return product.getPrice() * (vat.getLuxuryItem() / 100 + 1);
        }
    }

    // Calculates the price without VAT for a given order item if it has VAT included
    public double calculatePriceWithoutVAT(OrderItemEntity orderItem) {
        ProductEntity product = orderItem.getProduct();
        if (!product.isHasVAT()) {
            return product.getPrice();
        } else {
            return subtractVATFromProduct(product);
        }
    }

    // Subtracts VAT from the price of a product based on its product type
    public double subtractVATFromProduct(ProductEntity product) {
        VATEntity vat = new VATEntity();
        if (product.getProductType() == ProductTypeEnum.BASIC_NEED) {
            return product.getPrice() - (product.getPrice() * (vat.getBasicNeed() / 100));
        } else if (product.getProductType() == ProductTypeEnum.CONSUMER_PRODUCT) {
            return product.getPrice() - (product.getPrice() * (vat.getConsumerProduct() / 100));
        } else {
            return product.getPrice() - (product.getPrice() * (vat.getLuxuryItem() / 100));
        }
    }

    // Get an invoice by its UUID
    public InvoiceEntity getInvoiceByUUID(UUID uuid) {
        Optional<InvoiceEntity> invoiceEntityOptional = invoiceEntityRepository.findByUuid(uuid);

        return invoiceEntityOptional.orElse(null);
    }

}
