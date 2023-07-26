package com.controlproduct.controlproduct.domain;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientesRespository extends JpaRepository <Clientes, Long>{

	
	
}
