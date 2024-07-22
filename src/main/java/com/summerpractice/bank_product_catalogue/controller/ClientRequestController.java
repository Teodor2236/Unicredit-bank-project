package com.summerpractice.bank_product_catalogue.controller;

import com.summerpractice.bank_product_catalogue.model.DTO.ClientRequestDTO;
import com.summerpractice.bank_product_catalogue.service.ClientRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client-requests/v1.0.0")
public class ClientRequestController {

    private final ClientRequestService clientRequestService;

    @Autowired
    public ClientRequestController(ClientRequestService clientRequestService) {
        this.clientRequestService = clientRequestService;
    }

    @PostMapping("/create")
    public ResponseEntity<ClientRequestDTO> create(@RequestBody ClientRequestDTO clientRequestDTO) {
        ClientRequestDTO createdClientRequest = clientRequestService.create(clientRequestDTO);
        return ResponseEntity.ok(createdClientRequest);
    }

    @GetMapping("/get")
    public ResponseEntity<List<ClientRequestDTO>> getAll() {
        List<ClientRequestDTO> clientRequests = clientRequestService.getAll();

        if (clientRequests.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(clientRequests);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ClientRequestDTO> getById(@PathVariable Long id) {
        ClientRequestDTO clientRequestDTO = clientRequestService.getById(id);
        if (clientRequestDTO == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(clientRequestDTO);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<ClientRequestDTO> put(@PathVariable Long id, @RequestBody ClientRequestDTO clientRequestDTO) {
        ClientRequestDTO updatedClientRequest = clientRequestService.update(id, clientRequestDTO);

        if (updatedClientRequest == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedClientRequest);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (clientRequestService.delete(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/by-client/{clientId}")
    public ResponseEntity<List<ClientRequestDTO>> getByClientId(@PathVariable Long clientId) {
        List<ClientRequestDTO> clientRequests = clientRequestService.getByClientId(clientId);
        if (clientRequests.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(clientRequests);
    }

    @GetMapping("/by-product-details/{productDetailsId}")
    public ResponseEntity<List<ClientRequestDTO>> getByProductDetailsId(@PathVariable Long productDetailsId) {
        List<ClientRequestDTO> clientRequests = clientRequestService.getByProductDetailsId(productDetailsId);
        if (clientRequests.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(clientRequests);
    }

    @GetMapping("/by-client-and-product-details")
    public ResponseEntity<List<ClientRequestDTO>> getByClientIdAndProductDetailsId(
            @RequestParam Long clientId,
            @RequestParam Long productDetailsId) {
        List<ClientRequestDTO> clientRequests = clientRequestService.getByClientIdAndProductDetailsId(clientId, productDetailsId);
        if (clientRequests.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(clientRequests);
    }
}
