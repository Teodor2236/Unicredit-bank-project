package com.summerpractice.bank_product_catalogue.repository;

import com.summerpractice.bank_product_catalogue.model.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    Optional<Client> findByClientNumber(String clientNumber);
    Optional<Client> findByEGN(String EGN);
}
