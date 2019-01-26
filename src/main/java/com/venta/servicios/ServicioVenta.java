package com.venta.servicios;

import com.venta.proy.Categoria;
import com.venta.proy.Cliente;
import com.venta.proy.Producto;
import com.venta.repositorios.CategoriaRepository;
import com.venta.repositorios.ClienteRepository;
import com.venta.repositorios.ProductoRepository;

public interface ServicioVenta {

	ProductoRepository getRepoproducto();

	void setRepoproducto(ProductoRepository repoproducto);

	CategoriaRepository getRepocategoria();

	void setRepocategoria(CategoriaRepository repocategoria);
	
	ClienteRepository getRepocliente();

	void setRepocliente(ClienteRepository repocliente);

	Producto findOneProd(Integer id);

	Iterable<Producto> findAllProd();

	void saveProd(Producto producto);
	
	void updateProd(Producto producto);

	void deleteProd(Producto producto);

	Categoria findOneCat(Integer id);

	Iterable<Categoria> findAllCat();

	void saveCat(Categoria categoria);
	
	void updateCat(Categoria categoria);

	void deleteCat(Categoria categoria);
	
	Cliente findOneCli(Integer id);

	Iterable<Cliente> findAllCli();

	void saveCli(Cliente cliente);
	
	void updateCli(Cliente cliente);

	void deleteCli(Cliente cliente);

}