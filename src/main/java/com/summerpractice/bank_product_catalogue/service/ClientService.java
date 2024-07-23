package com.summerpractice.bank_product_catalogue.service;

import com.summerpractice.bank_product_catalogue.model.DTO.ClientDTO;
import com.summerpractice.bank_product_catalogue.model.entity.Client;
import com.summerpractice.bank_product_catalogue.repository.ClientRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClientService {

    private final ClientRepository clientRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ClientService(ClientRepository clientRepository, ModelMapper modelMapper) {
        this.clientRepository = clientRepository;
        this.modelMapper = modelMapper;
    }

    public ClientDTO create(ClientDTO clientDTO) {
        Client client = modelMapper.map(clientDTO, Client.class);
        Client savedClient = clientRepository.save(client);
        return modelMapper.map(savedClient, ClientDTO.class);
    }

    public List<ClientDTO> getAll() {
        List<Client> clients = clientRepository.findAll();
        return clients.stream()
                .map(client -> modelMapper.map(client, ClientDTO.class))
                .collect(Collectors.toList());
    }

    public ClientDTO getByClientNumber(String clientNumber) {
        Optional<Client> clientOptional = clientRepository.findByClientNumber(clientNumber);
        return clientOptional.map(client -> modelMapper.map(client, ClientDTO.class)).orElse(null);
    }

    public ClientDTO getByEGN(String EGN) {
        Optional<Client> clientOptional = clientRepository.findByEGN(EGN);
        return clientOptional.map(client -> modelMapper.map(client, ClientDTO.class)).orElse(null);
    }

    public ClientDTO updateByClientNumber(String clientNumber, ClientDTO clientDTO) {
        Optional<Client> existingClientOptional = clientRepository.findByClientNumber(clientNumber);

        if (existingClientOptional.isEmpty()) {
            return null;
        }
        Client existingClient = existingClientOptional.get();
        modelMapper.map(clientDTO, existingClient);
        Client updatedClient = clientRepository.save(existingClient);
        return modelMapper.map(updatedClient, ClientDTO.class);
    }

    public boolean deleteByClientNumber(String clientNumber) {
        Optional<Client> existingClientOptional = clientRepository.findByClientNumber(clientNumber);

        if (existingClientOptional.isPresent()) {
            clientRepository.delete(existingClientOptional.get());
            return true;
        }
        return false;
    }
}
