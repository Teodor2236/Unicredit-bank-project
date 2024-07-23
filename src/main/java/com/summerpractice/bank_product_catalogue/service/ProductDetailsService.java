package com.summerpractice.bank_product_catalogue.service;

import com.summerpractice.bank_product_catalogue.model.DTO.ProductDetailsDTO;
import com.summerpractice.bank_product_catalogue.model.entity.ProductDetails;
import com.summerpractice.bank_product_catalogue.repository.ProductDetailsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductDetailsService {

    private final ProductDetailsRepository productDetailsRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ProductDetailsService(ProductDetailsRepository productDetailsRepository, ModelMapper modelMapper) {
        this.productDetailsRepository = productDetailsRepository;
        this.modelMapper = modelMapper;
    }

    public ProductDetailsDTO create(ProductDetailsDTO productDetailsDTO) {
        ProductDetails productDetails = modelMapper.map(productDetailsDTO, ProductDetails.class);
        ProductDetails savedProductDetails = productDetailsRepository.save(productDetails);
        return modelMapper.map(savedProductDetails, ProductDetailsDTO.class);
    }

    public List<ProductDetailsDTO> getAll() {
        List<ProductDetails> productDetailsList = productDetailsRepository.findAll();
        return productDetailsList.stream()
                .map(productDetails -> modelMapper.map(productDetails, ProductDetailsDTO.class))
                .collect(Collectors.toList());
    }


    public ProductDetailsDTO getById(Long id) {
        Optional<ProductDetails> productDetails = productDetailsRepository.findById(id);
        return productDetails.map(pd -> modelMapper.map(pd, ProductDetailsDTO.class)).orElse(null);
    }

    public ProductDetailsDTO update(Long id, ProductDetailsDTO productDetailsDTO) {
        Optional<ProductDetails> existingProductDetails = productDetailsRepository.findById(id);
        if (existingProductDetails.isPresent()) {
            ProductDetails productDetails = existingProductDetails.get();
            modelMapper.map(productDetailsDTO, productDetails);
            ProductDetails updatedProductDetails = productDetailsRepository.save(productDetails);
            return modelMapper.map(updatedProductDetails, ProductDetailsDTO.class);
        }
        return null;
    }

    public boolean delete(Long id) {
        Optional<ProductDetails> productDetails = productDetailsRepository.findById(id);
        if (productDetails.isPresent()) {
            productDetailsRepository.delete(productDetails.get());
            return true;
        }
        return false;
    }
}
