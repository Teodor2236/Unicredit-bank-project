package com.summerpractice.bank_product_catalogue.service;

import com.summerpractice.bank_product_catalogue.model.DTO.LeasingDTO;
import com.summerpractice.bank_product_catalogue.model.entity.Leasing;
import com.summerpractice.bank_product_catalogue.repository.LeasingRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LeasingService {


    private final ModelMapper modelMapper;
    private final LeasingRepository leasingRepository;

    @Autowired
    public LeasingService(ModelMapper modelMapper, LeasingRepository leasingRepository) {
        this.modelMapper = modelMapper;
        this.leasingRepository = leasingRepository;
    }

    public List<LeasingDTO> getAll() {
        List<Leasing> leasings = leasingRepository.findAll();
        return leasings.stream()
                .map(leasing -> modelMapper.map(leasing, LeasingDTO.class))
                .collect(Collectors.toList());
    }
}