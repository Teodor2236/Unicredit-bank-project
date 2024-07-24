package com.summerpractice.bank_product_catalogue.controller;

import com.summerpractice.bank_product_catalogue.model.DTO.LoanDTO;
import com.summerpractice.bank_product_catalogue.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loans/v1.0.0")
public class LoanController {

    private final LoanService loanService;

    @Autowired
    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @GetMapping("/get-all")
    ResponseEntity<List<LoanDTO>> getAll() {
        List<LoanDTO> loans = loanService.getAll();

        if (loans.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(loans);
    }

    @GetMapping("/get/{type}")
    ResponseEntity<LoanDTO> get(@PathVariable String type) {
        LoanDTO loan = loanService.getByType(type);
        if (loan == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(loan);
    }
}
