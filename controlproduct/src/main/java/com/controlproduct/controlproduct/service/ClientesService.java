package com.controlproduct.controlproduct.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.controlproduct.controlproduct.domain.Clientes;
import com.controlproduct.controlproduct.domain.ClientesRespository;
import com.controlproduct.controlproduct.domain.Product;
import com.controlproduct.controlproduct.domain.ProductRepository;


@Service
public class ClientesService {
	
	private ClientesRespository clientesRepository;
	
	@Autowired
	public ClientesService(ClientesRespository clientesRepository) {
		this.clientesRepository = clientesRepository;
	}
	public Optional<Clientes> getProductById(Long id){
		return clientesRepository.findById(id);
	}
	
	public Clientes createClientes(Clientes clientes) {
		return clientesRepository.save(clientes);
	}
	
	
	public void deleteProduct(Long id) {
		clientesRepository.deleteById(id);
	}
	
	
	
	public void updateClientes(Long id, Clientes clientes) {
		clientes.setId(id);
		clientesRepository.save(clientes);
	}
	
		
	
	

	
}
