package com.summerpractice.bank_product_catalogue.controller;

import com.summerpractice.bank_product_catalogue.model.entity.Plan;
import com.summerpractice.bank_product_catalogue.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/plans/v1.0.0")
public class PlanController {

    private final PlanService planService;

    @Autowired
    public PlanController(PlanService planService) {
        this.planService = planService;
    }

    @GetMapping("/get-all")
    ResponseEntity<List<Plan>> getAll() {
        List<Plan> plans = planService.getAll();

        if (plans.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(plans);
    }
}
