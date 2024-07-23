package com.summerpractice.bank_product_catalogue.repository;

import com.summerpractice.bank_product_catalogue.model.entity.ClientRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRequestRepository extends JpaRepository<ClientRequest, Long> {
    List<ClientRequest> findByClientId(Long clientId);
    List<ClientRequest> findByProductDetailsId(Long productDetailsId);
    List<ClientRequest> findByClientIdAndProductDetailsId(Long clientId, Long productDetailsId);
}