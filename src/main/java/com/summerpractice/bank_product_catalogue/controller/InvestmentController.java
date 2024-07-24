package com.summerpractice.bank_product_catalogue.controller;

import com.summerpractice.bank_product_catalogue.model.DTO.InvestmentDTO;
import com.summerpractice.bank_product_catalogue.service.InvestmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/investments/v1.0.0")
public class InvestmentController {

    private final InvestmentService investmentService;

    @Autowired
    public InvestmentController(InvestmentService investmentService) {
        this.investmentService = investmentService;
    }

    @GetMapping("/get-all")
    ResponseEntity<List<InvestmentDTO>> getAll() {
        List<InvestmentDTO> investments = investmentService.getAll();

        if (investments.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(investments);
    }
}
