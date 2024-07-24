package com.summerpractice.bank_product_catalogue.service;

import com.summerpractice.bank_product_catalogue.model.DTO.PlanDTO;
import com.summerpractice.bank_product_catalogue.model.entity.Plan;
import com.summerpractice.bank_product_catalogue.repository.PlanRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlanService {

    private final ModelMapper modelMapper;
    private final PlanRepository planRepository;

    @Autowired
    public PlanService(PlanRepository planRepository, ModelMapper modelMapper) {
        this.planRepository = planRepository;
        this.modelMapper = modelMapper;
    }

    public List<PlanDTO> getAll(){
        List<Plan> plans = planRepository.findAll();
        return plans.stream()
                .map(plan -> modelMapper.map(plan, PlanDTO.class))
                .collect(Collectors.toList());
    }
}
