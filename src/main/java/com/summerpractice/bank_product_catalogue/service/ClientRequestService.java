package com.summerpractice.bank_product_catalogue.service;

import com.summerpractice.bank_product_catalogue.model.DTO.ClientRequestDTO;
import com.summerpractice.bank_product_catalogue.model.entity.ClientRequest;
import com.summerpractice.bank_product_catalogue.repository.ClientRequestRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClientRequestService {

    private final ClientRequestRepository clientRequestRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ClientRequestService(ClientRequestRepository clientRequestRepository, ModelMapper modelMapper) {
        this.clientRequestRepository = clientRequestRepository;
        this.modelMapper = modelMapper;
    }

    public ClientRequestDTO create(ClientRequestDTO clientRequestDTO) {
        ClientRequest clientRequest = modelMapper.map(clientRequestDTO, ClientRequest.class);
        ClientRequest savedClientRequest = clientRequestRepository.save(clientRequest);
        return modelMapper.map(savedClientRequest, ClientRequestDTO.class);
    }

    public List<ClientRequestDTO> getAll() {
        List<ClientRequest> clientRequests = clientRequestRepository.findAll();
        return clientRequests.stream()
                .map(clientRequest -> modelMapper.map(clientRequest, ClientRequestDTO.class))
                .collect(Collectors.toList());
    }
    public ClientRequestDTO getById(Long id) {
        Optional<ClientRequest> clientRequest = clientRequestRepository.findById(id);
        return clientRequest.map(cr -> modelMapper.map(cr, ClientRequestDTO.class)).orElse(null);
    }

    public ClientRequestDTO update(Long id, ClientRequestDTO clientRequestDTO) {
        Optional<ClientRequest> existingClientRequest = clientRequestRepository.findById(id);
        if (existingClientRequest.isPresent()) {
            ClientRequest clientRequest = existingClientRequest.get();
            modelMapper.map(clientRequestDTO, clientRequest);
            ClientRequest updatedClientRequest = clientRequestRepository.save(clientRequest);
            return modelMapper.map(updatedClientRequest, ClientRequestDTO.class);
        }
        return null;
    }

    public boolean delete(Long id) {
        Optional<ClientRequest> clientRequest = clientRequestRepository.findById(id);
        if (clientRequest.isPresent()) {
            clientRequestRepository.delete(clientRequest.get());
            return true;
        }
        return false;
    }

    public List<ClientRequestDTO> getByClientId(Long clientId) {
        List<ClientRequest> clientRequests = clientRequestRepository.findByClientId(clientId);
        return clientRequests.stream()
                .map(clientRequest -> modelMapper.map(clientRequest, ClientRequestDTO.class))
                .collect(Collectors.toList());
    }

    public List<ClientRequestDTO> getByProductDetailsId(Long productDetailsId) {
        List<ClientRequest> clientRequests = clientRequestRepository.findByProductDetailsId(productDetailsId);
        return clientRequests.stream()
                .map(clientRequest -> modelMapper.map(clientRequest, ClientRequestDTO.class))
                .collect(Collectors.toList());
    }

    public List<ClientRequestDTO> getByClientIdAndProductDetailsId(Long clientId, Long productDetailsId) {
        List<ClientRequest> clientRequests = clientRequestRepository.findByClientIdAndProductDetailsId(clientId, productDetailsId);
        return clientRequests.stream()
                .map(clientRequest -> modelMapper.map(clientRequest, ClientRequestDTO.class))
                .collect(Collectors.toList());
    }
}
