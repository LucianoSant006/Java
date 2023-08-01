package com.controlproduct.controlproduct.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.controlproduct.controlproduct.domain.Client;
import com.controlproduct.controlproduct.service.ClientService;


@RestController
@RequestMapping("/client")
public class ClientController {
	
	private ClientService clientService;
	
	@Autowired
	public ClientController(ClientService clientService) {
		this.clientService = clientService;
	}
	
	@GetMapping("/all")
	public List<Client> getAllClients(){
		return clientService.getAllClients();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Client> getClientById(@PathVariable Long id){
		Optional<Client> client = clientService.getClientById(id);
		return client.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<Client> createClient(@RequestBody Client client){
		Client createClient = clientService.createClient(client);
		return new ResponseEntity<>(createClient, HttpStatus.CREATED);	
	}
	
	@PutMapping("/up/{id}")
	public ResponseEntity<Void> updateClient(@PathVariable Long id, @RequestBody Client client){
		Optional<Client> existClient =clientService.getClientById(id);
		if (existClient.isPresent()) {
			clientService.updateClient(id, client);
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/dl/{id}")
	public ResponseEntity<Void> deleteClient(@PathVariable Long id){
		Optional<Client> existClient =clientService.getClientById(id);
		if (existClient.isPresent()) {
			clientService.deleteClient(id);
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
	

