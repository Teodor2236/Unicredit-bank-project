package com.summerpractice.bank_product_catalogue.service;

import com.summerpractice.bank_product_catalogue.model.entity.Plan;
import com.summerpractice.bank_product_catalogue.repository.PlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlanService {

    private final PlanRepository planRepository;
    @Autowired
    public PlanService(PlanRepository planRepository) {
        this.planRepository = planRepository;
    }

    public List<Plan> getAll(){
        return planRepository.findAll();
    }
}
