package com.summerpractice.bank_product_catalogue.service;

import com.summerpractice.bank_product_catalogue.model.DTO.EmployeeDTO;
import com.summerpractice.bank_product_catalogue.model.DTO.LoginRequest;
import com.summerpractice.bank_product_catalogue.model.entity.Employee;
import com.summerpractice.bank_product_catalogue.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    public EmployeeDTO create(EmployeeDTO employeeDTO) {
        Employee employee = modelMapper.map(employeeDTO, Employee.class);
        Employee savedEmployee = employeeRepository.save(employee);
        return modelMapper.map(savedEmployee, EmployeeDTO.class);
    }

    public List<EmployeeDTO> getAll() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream()
                .map(employee -> modelMapper.map(employee, EmployeeDTO.class))
                .collect(Collectors.toList());
    }

    public EmployeeDTO getByEmployeeNumber(String employeeNumber) {
        Optional<Employee> employeeOptional = employeeRepository.findByEmployeeNumber(employeeNumber);
        return employeeOptional.map(employee -> modelMapper.map(employee, EmployeeDTO.class)).orElse(null);
    }

    public EmployeeDTO getByEGN(String EGN) {
        Optional<Employee> employeeOptional = employeeRepository.findByEGN(EGN);
        return employeeOptional.map(employee -> modelMapper.map(employee, EmployeeDTO.class)).orElse(null);
    }

    public EmployeeDTO updateByEmployeeNumber(String employeeNumber, EmployeeDTO employeeDTO) {
        Optional<Employee> existingEmployeeOptional = employeeRepository.findByEmployeeNumber(employeeNumber);

        if (existingEmployeeOptional.isEmpty()) {
            return null;
        }
        Employee existingEmployee = existingEmployeeOptional.get();
        modelMapper.map(employeeDTO, existingEmployee);
        Employee updatedEmployee = employeeRepository.save(existingEmployee);
        return modelMapper.map(updatedEmployee, EmployeeDTO.class);
    }

    public boolean deleteByEmployeeNumber(String employeeNumber) {
        Optional<Employee> existingEmployeeOptional = employeeRepository.findByEmployeeNumber(employeeNumber);

        if (existingEmployeeOptional.isEmpty()) {
            employeeRepository.delete(existingEmployeeOptional.get());
            return true;
        }
        return false;
    }

    public EmployeeDTO login(LoginRequest loginRequest) {
        Employee employee = employeeRepository.findByEmployeeNumberAndPassword(loginRequest.getEmployeeNumber(), loginRequest.getPassword())
                .orElseThrow(() -> new RuntimeException("Could not find employee by given number and password"));

        return modelMapper.map(employee, EmployeeDTO.class);
    }
}
