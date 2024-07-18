package com.summerpractice.bank_product_catalogue.repository;

import com.summerpractice.bank_product_catalogue.model.entity.ClientRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRequestRepository extends JpaRepository<ClientRequest, Long> {
}