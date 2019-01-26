package com.venta.repositorios.jpa;

import org.springframework.stereotype.Repository;

import com.venta.proy.Producto;
import com.venta.repositorios.ProductoRepository;
@Repository
public class ProductoRepositoryJPA extends GenericRepositoryJPA<Producto,Integer> implements ProductoRepository {

	public ProductoRepositoryJPA() {
		super(Producto.class);
		// TODO Auto-generated constructor stub
	}
	
}


