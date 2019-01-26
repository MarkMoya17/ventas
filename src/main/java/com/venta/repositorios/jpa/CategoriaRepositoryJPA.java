package com.venta.repositorios.jpa;

import org.springframework.stereotype.Repository;

import com.venta.proy.Categoria;
import com.venta.repositorios.CategoriaRepository;

@Repository
public class CategoriaRepositoryJPA extends GenericRepositoryJPA<Categoria,Integer> implements CategoriaRepository {

	public CategoriaRepositoryJPA() {
		super(Categoria.class);
		// TODO Auto-generated constructor stub
	}
	
}


