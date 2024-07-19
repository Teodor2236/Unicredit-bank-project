package com.summerpractice.bank_product_catalogue.service;

import com.summerpractice.bank_product_catalogue.model.DTO.ProductDTO;
import com.summerpractice.bank_product_catalogue.model.entity.Product;
import com.summerpractice.bank_product_catalogue.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ProductService(ProductRepository productRepository, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }

    public ProductDTO create(ProductDTO productDTO) {
        Product product = modelMapper.map(productDTO, Product.class);
        Product savedProduct = productRepository.save(product);
        return modelMapper.map(savedProduct, ProductDTO.class);
    }

    public List<ProductDTO> getAll() {
        List<Product> products = productRepository.findAll();

        return products.stream()
                .map(product -> modelMapper.map(product, ProductDTO.class))
                .collect(Collectors.toList());
    }

    public ProductDTO getById(Long id) {
        Product product = productRepository.findById(id).orElse(null);
        return modelMapper.map(product, ProductDTO.class);
    }

    public ProductDTO update(Long id, ProductDTO productDTO) {
        Product product = productRepository.findById(id).orElse(null);
        modelMapper.map(productDTO, product);
        return modelMapper.map(product, ProductDTO.class);
    }

    public boolean delete(Long id) {
        Product product = productRepository.findById(id).orElse(null);

        if (product != null) {
            productRepository.delete(product);
            return true;
        }
        return false;
    }
}
