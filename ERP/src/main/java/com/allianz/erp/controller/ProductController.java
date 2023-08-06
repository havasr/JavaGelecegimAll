package com.allianz.erp.controller;

import com.allianz.erp.database.entity.ProductEntity;
import com.allianz.erp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("product")
public class ProductController {
    @Autowired
    ProductService productService;

    //Creating product
    @PostMapping("product")
    public ResponseEntity<ProductEntity> createProduct(@RequestBody ProductEntity product) {
        ProductEntity product1 = productService.createProduct(product.getName(), product.getStock(), product.isHasVAT(),
                product.getPrice());
        return new ResponseEntity<>(product1, HttpStatus.CREATED);
    }

    //Delete product
    @DeleteMapping("product/{uuid}")
    public ResponseEntity<Boolean> deleteProduct(@PathVariable UUID uuid) {
        Boolean isDeleted = productService.deleteProductByUUID(uuid);
        if (isDeleted) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }

    //Update product
    @PutMapping("product/{uuid}")
    public ResponseEntity<ProductEntity> updateProductByUUID
    (@PathVariable UUID uuid, @RequestBody ProductEntity newProductEntity) {
        ProductEntity productEntity = productService.updateProductByUUID(uuid, newProductEntity);
        if (productEntity != null) {
            return new ResponseEntity<>(productEntity, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    //Search customer by UUID
    @GetMapping("product-uuid/{uuid}")
    public ResponseEntity<ProductEntity> getProductByUUID(@PathVariable UUID uuid) {
        ProductEntity productEntity = productService.getProductByUUID(uuid);
        if (productEntity != null) {
            return new ResponseEntity<>(productEntity, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("product-list-by-name-start-with/{key}")
    public ResponseEntity<List<ProductEntity>> getProductListByNameStartWith(@PathVariable String key) {
        return new ResponseEntity<>(productService.getProductNameStartWith(key), HttpStatus.OK);
    }

    @PutMapping("product-stock-update/{uuid}")
    public ResponseEntity<ProductEntity> updateStockOfProductByUUID(@PathVariable UUID uuid, @RequestBody int newStock){
        ProductEntity productEntity = productService.updateStockOfProductByUUID(uuid, newStock);
        if(productEntity != null){
            return new ResponseEntity<>(productEntity, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("product-price-update/{uuid}")
    public ResponseEntity<ProductEntity> updatePriceOfProductByUUID(@PathVariable UUID uuid, @RequestBody double newPrice){
        ProductEntity productEntity = productService.updatePriceOfProductByUUID(uuid, newPrice);
        if(productEntity != null){
            return new ResponseEntity<>(productEntity, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }




}
