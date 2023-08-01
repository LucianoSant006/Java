package com.controlproduct.controlproduct.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.controlproduct.controlproduct.domain.ClientRepository;
import com.controlproduct.controlproduct.domain.Client;

@Service
public class ClientService {
	
	private ClientRepository clientRepository;
	
	@Autowired
	public ClientService(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}
	
	public List<Client> getAllClients(){
		return clientRepository.findAll();
	}
	
	public Optional<Client> getClientById(Long id){
		return clientRepository.findById(id);
	}
	
	public Client createClient(Client client) {
		return clientRepository.save(client);
	}
	
	public void updateClient(Long id, Client client) {
		client.setId(id);
		clientRepository.save(client);
	}
	
	public void deleteClient(Long id) {
		clientRepository.deleteById(id);
	}
	
}

