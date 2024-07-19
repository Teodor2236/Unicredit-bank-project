package com.summerpractice.bank_product_catalogue.service;

import com.summerpractice.bank_product_catalogue.model.DTO.ClientDTO;
import com.summerpractice.bank_product_catalogue.model.entity.Client;
import com.summerpractice.bank_product_catalogue.repository.ClientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
        Client client = clientRepository.findByClientNumber(clientNumber);
        return modelMapper.map(client, ClientDTO.class);
    }

    public ClientDTO getByEGN(String EGN){
        Client client = clientRepository.findByEGN(EGN);
        return modelMapper.map(client, ClientDTO.class);
    }

    public ClientDTO updateByClientNumber(String clientNumber, ClientDTO clientDTO) {
        Client existingClient = clientRepository.findByClientNumber(clientNumber);

        if (existingClient != null) {
            modelMapper.map(clientDTO, existingClient);
            Client updatedClient = clientRepository.save(existingClient);
            return modelMapper.map(updatedClient, ClientDTO.class);
        }
        return null;
    }

    public boolean deleteByClientNumber(String clientNumber) {
        Client existingClient = clientRepository.findByClientNumber(clientNumber);

        if (existingClient != null) {
            clientRepository.delete(existingClient);
            return true;
        }
        return false;
    }
}
