package com.summerpractice.bank_product_catalogue.controller;

import com.summerpractice.bank_product_catalogue.model.DTO.EmployeeDTO;
import com.summerpractice.bank_product_catalogue.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees/v1.0.0")
public class EmployeeController implements Controller<EmployeeDTO> {

    private final EmployeeService employeeService;

    @Autowired
    EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/create")
    @Override
    public ResponseEntity<EmployeeDTO> create(@RequestBody EmployeeDTO employeeDTO) {
        EmployeeDTO createdEmployee = employeeService.create(employeeDTO);
        return ResponseEntity.ok(createdEmployee);
    }

    @GetMapping("/get")
    @Override
    public ResponseEntity<List<EmployeeDTO>> getAll() {
        List<EmployeeDTO> employees = employeeService.getAll();
        if (employees.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/get/{employeeNumber}")
    public ResponseEntity<EmployeeDTO> getByEmployeeNumber(@PathVariable String employeeNumber) {
        EmployeeDTO employee = employeeService.getByEmployeeNumber(employeeNumber);
        if (employee == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(employee);
    }

    @GetMapping("/get/{EGN}")
    public ResponseEntity<EmployeeDTO> getByEGN(@PathVariable String EGN) {
        EmployeeDTO employee = employeeService.getByEGN(EGN);
        if (employee == null){
            return ResponseEntity.notFound().build();
        }
        return  ResponseEntity.ok(employee);
    }

    @PutMapping("/put/{employeeNumber}")
    public ResponseEntity<EmployeeDTO> updateByEmployeeNumber(@RequestBody EmployeeDTO employeeDTO, @PathVariable String employeeNumber) {
        EmployeeDTO updatedEmployee = employeeService.updateByEmployeeNumber(employeeNumber, employeeDTO);
        if (updatedEmployee == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedEmployee);
    }

    @DeleteMapping("/delete/{employeeNumber}")
    public ResponseEntity<EmployeeDTO> deleteByEmployeeNumber(@PathVariable String employeeNumber) {
        if (employeeService.deleteByEmployeeNumber(employeeNumber)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
