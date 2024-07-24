package com.summerpractice.bank_product_catalogue.service;

import com.summerpractice.bank_product_catalogue.model.DTO.LoanDTO;
import com.summerpractice.bank_product_catalogue.model.entity.Loan;
import com.summerpractice.bank_product_catalogue.repository.LoanRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LoanService {

    private final ModelMapper modelMapper;
    private final LoanRepository loanRepository;

    @Autowired
    public LoanService(ModelMapper modelMapper, LoanRepository loanRepository) {
        this.modelMapper = modelMapper;
        this.loanRepository = loanRepository;
    }


    public List<LoanDTO> getAll() {
        List<Loan> loans = loanRepository.findAll();
        return loans.stream().
                map(loan -> modelMapper.map(loan, LoanDTO.class))
                .collect(Collectors.toList());
    }

    public LoanDTO getByType(String type){
        Optional<Loan> loanOptional = loanRepository.findByType(type);
        return loanOptional.map(loan -> modelMapper.map(loan, LoanDTO.class)).orElse(null);
    }
}
