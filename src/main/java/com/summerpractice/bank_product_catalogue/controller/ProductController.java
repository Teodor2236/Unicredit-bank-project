package com.summerpractice.bank_product_catalogue.controller;

import com.summerpractice.bank_product_catalogue.model.DTO.ProductDTO;
import com.summerpractice.bank_product_catalogue.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products/v1.0.0")
@CrossOrigin(origins = "http://127.0.0.1:5501")
public class ProductController implements Controller<ProductDTO> {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/create")
    @Override
    public ResponseEntity<?> create(ProductDTO entity) {
        ProductDTO createdProduct = productService.create(entity);
        return ResponseEntity.ok(createdProduct);
    }

    @GetMapping("/get")
    @Override
    public ResponseEntity<List<ProductDTO>> getAll() {
        List<ProductDTO> products = productService.getAll();

        if (products.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(products);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ProductDTO> getById(@PathVariable Long id) {
        ProductDTO productDTO = productService.getById(id);
        if (productDTO == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(productDTO);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<ProductDTO> put(@PathVariable Long id, @RequestBody ProductDTO productDTO) {
        ProductDTO updatedProduct = productService.update(id, productDTO);

        if (updatedProduct == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedProduct);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ProductDTO> delete(@PathVariable Long id) {

        if (productService.delete(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
