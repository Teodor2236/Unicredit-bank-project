package com.summerpractice.bank_product_catalogue.controller;

import com.summerpractice.bank_product_catalogue.model.DTO.ProductDetailsDTO;
import com.summerpractice.bank_product_catalogue.service.ProductDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product-details/v1.0.0")
public class ProductDetailsController {

    private final ProductDetailsService productDetailsService;

    @Autowired
    public ProductDetailsController(ProductDetailsService productDetailsService) {
        this.productDetailsService = productDetailsService;
    }

    @PostMapping("/create")
    public ResponseEntity<ProductDetailsDTO> create(@RequestBody ProductDetailsDTO productDetailsDTO) {
        ProductDetailsDTO createdProductDetails = productDetailsService.create(productDetailsDTO);
        return ResponseEntity.ok(createdProductDetails);
    }

    @GetMapping("/get")
    public ResponseEntity<List<ProductDetailsDTO>> getAll() {
        List<ProductDetailsDTO> productDetailsList = productDetailsService.getAll();

        if (productDetailsList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(productDetailsList);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ProductDetailsDTO> getById(@PathVariable Long id) {
        ProductDetailsDTO productDetailsDTO = productDetailsService.getById(id);
        if (productDetailsDTO == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(productDetailsDTO);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<ProductDetailsDTO> put(@PathVariable Long id, @RequestBody ProductDetailsDTO productDetailsDTO) {
        ProductDetailsDTO updatedProductDetails = productDetailsService.update(id, productDetailsDTO);

        if (updatedProductDetails == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedProductDetails);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (productDetailsService.delete(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
