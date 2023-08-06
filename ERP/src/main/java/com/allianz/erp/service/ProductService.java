package com.allianz.erp.service;

import com.allianz.erp.database.entity.ProductEntity;
import com.allianz.erp.database.repository.ProductEntityRepository;
import com.allianz.erp.model.OrderStatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {

    @Autowired
    ProductEntityRepository productEntityRepository;

    public ProductEntity createProduct(String name, int stock, boolean hasVAT,
                                               double price) {
        ProductEntity product = new ProductEntity();
        product.setName(name);
        product.setStock(stock);
        product.setHasVAT(hasVAT);
        product.setPrice(price);

        productEntityRepository.save(product);

        return product;
    }


    @Transactional
    public Boolean deleteProductByUUID(UUID uuid) {
        ProductEntity productEntity = getProductByUUID(uuid);

        if (productEntity != null) {

            productEntityRepository.deleteByUuid(uuid);

            return true;
        }
        return false;
    }

    public ProductEntity getProductByUUID(UUID uuid) {
        Optional<ProductEntity> productEntityOptional = productEntityRepository.findByUuid(uuid);

        return productEntityOptional.orElse(null);
    }


    public ProductEntity updateProductByUUID(UUID uuid, ProductEntity newProductEntity) {
        ProductEntity productEntity = getProductByUUID(uuid);

        if (productEntity != null) {
            productEntity.setName(newProductEntity.getName());
            productEntity.setStock(newProductEntity.getStock());
            productEntity.setHasVAT(newProductEntity.isHasVAT());
            productEntity.setPrice(newProductEntity.getPrice());

            productEntityRepository.save(productEntity);

            return productEntity;
        }
        return null;
    }

    public List<ProductEntity> getProductNameStartWith(String key) {
        return productEntityRepository.findAllByNameStartingWith(key);
    }

    public ProductEntity updateStockOfProductByUUID(UUID uuid, int newStock){
        ProductEntity productEntity = getProductByUUID(uuid);
        if (productEntity != null){
            productEntity.setStock(newStock);
            return productEntity;
        }
        return null;
    }

    public ProductEntity updatePriceOfProductByUUID(UUID uuid, double newPrice){
        ProductEntity productEntity = getProductByUUID(uuid);
        if (productEntity != null){
            productEntity.setPrice(newPrice);
            return productEntity;
        }
        return null;
    }

}
