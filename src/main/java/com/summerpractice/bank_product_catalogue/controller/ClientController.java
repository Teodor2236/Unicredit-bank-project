package com.summerpractice.bank_product_catalogue.controller;

import com.summerpractice.bank_product_catalogue.model.DTO.ClientDTO;
import com.summerpractice.bank_product_catalogue.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients/v1.0.0")
public class ClientController implements Controller<ClientDTO> {

    private final ClientService clientService;

    @Autowired
    ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/create")
    @Override
    public ResponseEntity<ClientDTO> create(@RequestBody ClientDTO clientDTO) {

        ClientDTO createdClient = clientService.create(clientDTO);
        return ResponseEntity.ok(createdClient);
    }

    @GetMapping("/get")
    @Override
    public ResponseEntity<List<ClientDTO>> getAll() {
        List<ClientDTO> clients = clientService.getAll();

        if (clients.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(clients);
    }

    @GetMapping("/get/client-number/{clientNumber}")
    public ResponseEntity<ClientDTO> getByClientNumber(@PathVariable String clientNumber) {
        ClientDTO client = clientService.getByClientNumber(clientNumber);

        if (client == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(client);
    }

    @GetMapping("/get/EGN/{EGN}")
    public ResponseEntity<ClientDTO> getByEGN(@PathVariable String EGN) {
        ClientDTO client = clientService.getByEGN(EGN);

        if (client == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(client);
    }

    @PutMapping("/put/client-number/{clientNumber}")
    public ResponseEntity<ClientDTO> updateByClientNumber(@RequestBody ClientDTO clientDTO, @PathVariable String clientNumber) {
        ClientDTO updatedClient = clientService.updateByClientNumber(clientNumber, clientDTO);
        if (updatedClient == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedClient);
    }

    @DeleteMapping("/delete/{clientNumber}")
    public ResponseEntity<ClientDTO> deleteByClientNumber(@PathVariable String clientNumber) {
        if (clientService.deleteByClientNumber(clientNumber)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
