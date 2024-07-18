package com.summerpractice.bank_product_catalogue.repository;

import com.summerpractice.bank_product_catalogue.model.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
