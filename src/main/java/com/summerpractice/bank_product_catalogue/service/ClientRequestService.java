package com.summerpractice.bank_product_catalogue.service;

import com.summerpractice.bank_product_catalogue.model.DTO.ClientRequestDTO;
import com.summerpractice.bank_product_catalogue.model.entity.Client;
import com.summerpractice.bank_product_catalogue.model.entity.ClientRequest;
import com.summerpractice.bank_product_catalogue.model.entity.ProductDetails;
import com.summerpractice.bank_product_catalogue.model.enums.ActionType;
import com.summerpractice.bank_product_catalogue.repository.ClientRepository;
import com.summerpractice.bank_product_catalogue.repository.ClientRequestRepository;
import com.summerpractice.bank_product_catalogue.repository.ProductDetailsRepository;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClientRequestService {

	private final ClientRequestRepository clientRequestRepository;
	private final ClientRepository clientRepository;
	private final ProductDetailsRepository productDetailsRepository;
	private final ModelMapper modelMapper;

	public ClientRequestService(ClientRequestRepository clientRequestRepository, ModelMapper modelMapper,
			ClientRepository clientRepository, ProductDetailsRepository productDetailsRepository) {
		this.clientRequestRepository = clientRequestRepository;
		this.modelMapper = modelMapper;
		this.clientRepository = clientRepository;
		this.productDetailsRepository = productDetailsRepository;
	}

	public ClientRequestDTO create(ClientRequestDTO clientRequestDTO) {
		Client client = clientRepository.getReferenceById(clientRequestDTO.getClientId());
		ProductDetails productDetails = productDetailsRepository
				.getReferenceById(clientRequestDTO.getProductDetailsId());
		ClientRequest clientRequest = new ClientRequest();
		clientRequest.setActionType(clientRequestDTO.getActionType().toString());
		clientRequest.setClient(client);
		clientRequest.setInvestmentAmount(clientRequestDTO.getInvestmentAmount());
		clientRequest.setInvestmentTermInMonths(clientRequestDTO.getInvestmentTermInMonths());
		clientRequest.setLoanAmount(clientRequestDTO.getLoanAmount());
		clientRequest.setLoanTermInMonths(clientRequestDTO.getLoanTermInMonths());
		clientRequest.setProductDetails(productDetails);

		ClientRequest savedClientRequest = clientRequestRepository.save(clientRequest);
		return modelMapper.map(savedClientRequest, ClientRequestDTO.class);
	}

	public List<ClientRequestDTO> getAll(String customerNumber, ActionType actionType, String fromDate, String toDate) {
		Client client = clientRepository.findByClientNumber(customerNumber)
				.orElseThrow(() -> new RuntimeException("Could not find client with number: ".concat(customerNumber)));

		List<ClientRequest> clientRequests;

		if (actionType != null && actionType.equals(ActionType.ALL)) {
			clientRequests = clientRequestRepository.findByClientIdOrderByCreatedDateAsc(client.getId());
		} else {
			clientRequests = clientRequestRepository.findByClientIdAndActionTypeOrderByCreatedDateAsc(client.getId(),
					actionType.name());
		}

		return clientRequests.stream().map(clientRequest -> modelMapper.map(clientRequest, ClientRequestDTO.class))
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
		return clientRequests.stream().map(clientRequest -> modelMapper.map(clientRequest, ClientRequestDTO.class))
				.collect(Collectors.toList());
	}

	public List<ClientRequestDTO> getByProductDetailsId(Long productDetailsId) {
		List<ClientRequest> clientRequests = clientRequestRepository.findByProductDetailsId(productDetailsId);
		return clientRequests.stream().map(clientRequest -> modelMapper.map(clientRequest, ClientRequestDTO.class))
				.collect(Collectors.toList());
	}

	public List<ClientRequestDTO> getByClientIdAndProductDetailsId(Long clientId, Long productDetailsId) {
		List<ClientRequest> clientRequests = clientRequestRepository.findByClientIdAndProductDetailsId(clientId,
				productDetailsId);
		return clientRequests.stream().map(clientRequest -> modelMapper.map(clientRequest, ClientRequestDTO.class))
				.collect(Collectors.toList());
	}
}
