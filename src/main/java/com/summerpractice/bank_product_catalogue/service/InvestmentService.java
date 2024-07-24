package com.summerpractice.bank_product_catalogue.service;

import com.summerpractice.bank_product_catalogue.model.DTO.InvestmentDTO;
import com.summerpractice.bank_product_catalogue.model.entity.Investment;
import com.summerpractice.bank_product_catalogue.repository.InvestmentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InvestmentService {

    private final ModelMapper modelMapper;
    private final InvestmentRepository investmentRepository;

    @Autowired
    public InvestmentService(ModelMapper modelMapper, InvestmentRepository investmentRepository) {
        this.modelMapper = modelMapper;
        this.investmentRepository = investmentRepository;
    }

    public List<InvestmentDTO> getAll() {
        List<Investment> investments = investmentRepository.findAll();
        return investments.stream()
                .map(investment -> modelMapper.map(investment, InvestmentDTO.class))
                .collect(Collectors.toList());
    }
}
