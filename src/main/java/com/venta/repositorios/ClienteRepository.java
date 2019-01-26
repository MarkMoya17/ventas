package com.venta.repositorios;
import com.venta.proy.Cliente;

public interface ClienteRepository {
	
	public Cliente findOne(Integer id);
	public Iterable<Cliente> findAll();
	public void save(Cliente cliente);
	public void update(Cliente cliente);
	public void delete(Cliente cliente);
}

