package com.summerpractice.bank_product_catalogue.service;

import com.summerpractice.bank_product_catalogue.model.DTO.EmployeeDTO;
import com.summerpractice.bank_product_catalogue.model.entity.Employee;
import com.summerpractice.bank_product_catalogue.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
        Employee employee = employeeRepository.findByEmployeeNumber(employeeNumber);
        return modelMapper.map(employee, EmployeeDTO.class);
    }

    public EmployeeDTO getByEGN(String EGN) {
        Employee employee = employeeRepository.findByEGN(EGN);
        return modelMapper.map(employee, EmployeeDTO.class);
    }

    public EmployeeDTO updateByEmployeeNumber(String employeeNumber, EmployeeDTO employeeDTO) {
        Employee existingEmployee = employeeRepository.findByEmployeeNumber(employeeNumber);

        if (existingEmployee != null) {
            modelMapper.map(employeeDTO, existingEmployee);
            Employee updatedEmployee = employeeRepository.save(existingEmployee);
            return modelMapper.map(updatedEmployee, EmployeeDTO.class);
        }
        return null;
    }

    public boolean deleteByEmployeeNumber(String employeeNumber) {
        Employee existingEmployee = employeeRepository.findByEmployeeNumber(employeeNumber);

        if (existingEmployee != null) {
            employeeRepository.delete(existingEmployee);
            return true;
        }
        return false;
    }

}
