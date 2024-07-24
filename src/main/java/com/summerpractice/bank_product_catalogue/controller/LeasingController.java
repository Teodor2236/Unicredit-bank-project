package com.summerpractice.bank_product_catalogue.controller;

import com.summerpractice.bank_product_catalogue.model.DTO.LeasingDTO;
import com.summerpractice.bank_product_catalogue.service.LeasingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/leasings/v1.0.0")
public class LeasingController {

    private final LeasingService leasingService;

    @Autowired
    public LeasingController(LeasingService leasingService) {
        this.leasingService = leasingService;
    }

    @GetMapping("/get-all")
    ResponseEntity<List<LeasingDTO>> getAll() {
        List<LeasingDTO> leasings = leasingService.getAll();

        if (leasings.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(leasings);
    }
}
