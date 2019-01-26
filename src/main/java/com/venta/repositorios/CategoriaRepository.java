package com.venta.repositorios;
import com.venta.proy.Categoria;

public interface CategoriaRepository {
	
	public Categoria findOne(Integer id);
	public Iterable<Categoria> findAll();
	public void save(Categoria categoria);
	public void update(Categoria categoria);
	public void delete(Categoria categoria);
}

