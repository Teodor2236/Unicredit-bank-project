package com.summerpractice.bank_product_catalogue.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public interface Controller<T> {

    @GetMapping("/get")
    ResponseEntity<List<T>> getAll();

    @PostMapping("/create")
    ResponseEntity<?> create(@RequestBody T entity);
}
