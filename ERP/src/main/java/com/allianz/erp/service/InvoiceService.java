package com.allianz.erp.service;

import com.allianz.erp.database.entity.*;
import com.allianz.erp.database.repository.InvoiceEntityRepository;
import com.allianz.erp.model.ProductTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceService {
    @Autowired
    InvoiceEntityRepository invoiceEntityRepository;

    public InvoiceEntity createInvoice(OrderEntity order) {
        InvoiceEntity invoice = new InvoiceEntity();
        invoice.setOrder(order);
        order.setInvoice(invoice);

        invoiceEntityRepository.save(invoice);


        double totalPriceWithVAT = 0.0;
        double totalPriceWithoutVAT = 0.0;

        List<OrderItemEntity> orderItems = order.getOrderItemList();
        for (OrderItemEntity orderItem : orderItems) {
            totalPriceWithVAT += calculatePriceWithVAT(orderItem);
            totalPriceWithoutVAT += calculatePriceWithoutVAT(orderItem);
            // Display or process each OrderItem as needed
            System.out.println("Order Item: " + orderItem.getProduct().getName() + ", Quantity: " + orderItem.getQuantity()
                    + ", Unit Price: " + orderItem.getProduct().getPrice());
        }
        invoice.setTotalPriceWithVAT(totalPriceWithVAT);
        invoice.setTotalPriceWithoutVAT(totalPriceWithoutVAT);
        invoice.setTotalVATAmount(totalPriceWithVAT-totalPriceWithoutVAT);
        return invoice;

    }

    public double calculatePriceWithVAT(OrderItemEntity orderItem){
        ProductEntity product = orderItem.getProduct();
        if (product.isHasVAT()){
            return product.getPrice();
        } else{
            return addVATToProduct(product);
        }
    }

    public double addVATToProduct(ProductEntity product){
        VATEntity vat = new VATEntity();
        if (product.getProductType() == ProductTypeEnum.BASIC_NEED){
            return product.getPrice()*(vat.getBasicNeed()/100 + 1);
        } else if (product.getProductType() == ProductTypeEnum.CONSUMER_PRODUCT) {
            return product.getPrice()*(vat.getConsumerProduct()/100 + 1);
        } else {
            return product.getPrice()*(vat.getLuxuryItem()/100 + 1);
        }
    }

    public double calculatePriceWithoutVAT(OrderItemEntity orderItem){
        ProductEntity product = orderItem.getProduct();
        if (!product.isHasVAT()){
            return product.getPrice();
        } else{
            return subtractVATFromProduct(product);
        }
    }

    public double subtractVATFromProduct(ProductEntity product){
        VATEntity vat = new VATEntity();
        if (product.getProductType() == ProductTypeEnum.BASIC_NEED){
            return product.getPrice()-(product.getPrice()*(vat.getBasicNeed()/100));
        } else if (product.getProductType() == ProductTypeEnum.CONSUMER_PRODUCT) {
            return product.getPrice()-(product.getPrice()*(vat.getConsumerProduct()/100));
        } else {
            return product.getPrice()-(product.getPrice()*(vat.getLuxuryItem()/100));
        }
    }

}
