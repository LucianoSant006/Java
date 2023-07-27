package com.controlproduct.controlproduct.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.controlproduct.controlproduct.domain.Clientes;
import com.controlproduct.controlproduct.domain.Product;
import com.controlproduct.controlproduct.service.ClientesService;
import com.controlproduct.controlproduct.service.ProductService;

@RestController
@RequestMapping("/clientes")
public class ClientesController {
	
	private ClientesService clientesService;
	
	@Autowired
	public ClientesController(ClientesService clientesService) {
		this.clientesService = clientesService;
	}
	
	@PostMapping
	public ResponseEntity<Clientes> createCliente(@RequestBody Clientes clientes){
		Clientes createCliente = clientesService.createClientes(clientes);
		return new ResponseEntity<>(createCliente, HttpStatus.CREATED);	
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Clientes> getClientesById(@PathVariable Long id){
		Optional<Clientes> clientes = clientesService.getProductById(id);
		return clientes.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}
	
	/*@DeleteMapping("/Dl/{id}")
	
	public ResponseEntity<Void> deleteClientes(@PathVariable Long id)
	
	{
		Optional<Clientes> existClientes =clientesService.getClientesById(id);
		
		if (existClientes.isPresent()) {
			clientesService.createClientes(id);
			return ResponseEntity.notFound().build();
		}
		
		else {
			return ResponseEntity.notFound().build();
			
		}
		
	}
*/
}
