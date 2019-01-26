package com.venta.repositorios.jpa;

import org.springframework.stereotype.Repository;

import com.venta.proy.Cliente;
import com.venta.repositorios.ClienteRepository;

@Repository
public class ClienteRepositoryJPA extends GenericRepositoryJPA<Cliente,Integer> implements ClienteRepository {

	public ClienteRepositoryJPA() {
		super(Cliente.class);
		// TODO Auto-generated constructor stub
	}
	
}


