package com.allianz.erp.service;

import com.allianz.erp.database.entity.ProductEntity;
import com.allianz.erp.database.repository.ProductEntityRepository;
import jakarta.validation.ValidationException;
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

    // Create a new product
    public ProductEntity createProduct(String name, int stock, boolean hasVAT,
                                       double price) {
        if (name == null || name.isEmpty()) {
            throw new ValidationException("All fields are required.");
        }
        ProductEntity product = new ProductEntity();
        product.setName(name);
        product.setStock(stock);
        product.setHasVAT(hasVAT);
        product.setPrice(price);

        productEntityRepository.save(product);

        return product;
    }

    // Delete a product by its UUID
    @Transactional
    public Boolean deleteProductByUUID(UUID uuid) {
        ProductEntity productEntity = getProductByUUID(uuid);
        if (productEntity == null) {
            productEntityRepository.deleteByUuid(uuid);
            return true;
        }
        return false;
    }

    // Get a product by its UUID
    public ProductEntity getProductByUUID(UUID uuid) {
        Optional<ProductEntity> productEntityOptional = productEntityRepository.findByUuid(uuid);

        return productEntityOptional.orElse(null);
    }

    // Update a product by its UUID
    @Transactional
    public ProductEntity updateProductByUUID(UUID uuid, ProductEntity newProductEntity) {
        ProductEntity productEntity = getProductByUUID(uuid);

        if (productEntity == null) {
            throw new IllegalArgumentException("Product not found with UUID: " + uuid);
        }
        productEntity.setName(newProductEntity.getName());
        productEntity.setStock(newProductEntity.getStock());
        productEntity.setHasVAT(newProductEntity.isHasVAT());
        productEntity.setPrice(newProductEntity.getPrice());

        productEntityRepository.save(productEntity);

        return productEntity;
    }

    // Get a list of products whose names start with the given key
    public List<ProductEntity> getProductNameStartWith(String key) {
        return productEntityRepository.findAllByNameStartingWith(key);
    }

    // Update a product's stock by its UUID
    @Transactional
    public ProductEntity updateProductStockByUUID(UUID uuid, int newStock) {
        ProductEntity productEntity = getProductByUUID(uuid);
        if (productEntity != null) {
            productEntity.setStock(newStock);
            return productEntity;
        }
        throw new IllegalArgumentException("Product not found with UUID: " + uuid);
    }

    // Update a product's price by its UUID
    @Transactional
    public ProductEntity updateProductPriceByUUID(UUID uuid, double newPrice) {
        ProductEntity productEntity = getProductByUUID(uuid);
        if (productEntity != null) {
            productEntity.setPrice(newPrice);
            return productEntity;
        }
        throw new IllegalArgumentException("Product not found with UUID: " + uuid);
    }

}
