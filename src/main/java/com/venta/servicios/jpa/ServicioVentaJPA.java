package com.venta.servicios.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.venta.proy.Categoria;
import com.venta.proy.Cliente;
import com.venta.proy.Producto;
import com.venta.repositorios.CategoriaRepository;
import com.venta.repositorios.ClienteRepository;
import com.venta.repositorios.ProductoRepository;
import com.venta.servicios.ServicioVenta;

@Service
public class ServicioVentaJPA implements ServicioVenta {
	@Autowired
	private ProductoRepository repoproducto;
	@Autowired
	private CategoriaRepository repocategoria;
	@Autowired
	private ClienteRepository repocliente;

	
	public ProductoRepository getRepoproducto() {
		return repoproducto;
	}
	
	public void setRepoproducto(ProductoRepository repoproducto) {
		this.repoproducto = repoproducto;
	}

	public CategoriaRepository getRepocategoria() {
		return repocategoria;
	}

	
	public void setRepocategoria(CategoriaRepository repocategoria) {
		this.repocategoria = repocategoria;
	}
	
	public ClienteRepository getRepocliente() {
		return repocliente;
	}

	
	public void setRepocliente(ClienteRepository repocliente) {
		this.repocliente = repocliente;
	}

	
	public Producto findOneProd(Integer id) {
		return repoproducto.findOne(id);
	}

	
	public Iterable<Producto> findAllProd() {
		return repoproducto.findAll();
	}

	 @Transactional
	public void saveProd(Producto producto) {
		repoproducto.save(producto);
	}
	
	 @Transactional
	public void updateProd(Producto producto){
		 repoproducto.update(producto);
	}
	

	 @Transactional
	public void deleteProd(Producto producto) {
		repoproducto.delete(producto);
	}

	
	public Categoria findOneCat(Integer id) {
		return repocategoria.findOne(id);
	}

	
	public Iterable<Categoria> findAllCat() {
		return repocategoria.findAll();
	}

	 @Transactional
	public void saveCat(Categoria categoria) {
		repocategoria.save(categoria);
	}
	 @Transactional
	public void deleteCat(Categoria categoria) {
		repocategoria.delete(categoria);
	}
	 
	public Cliente findOneCli(Integer id) {
		return repocliente.findOne(id);
	}
	
	public Iterable<Cliente> findAllCli() {
		return repocliente.findAll();
	}

	 @Transactional
	public void saveCli(Cliente cliente) {
		repocliente.save(cliente);
	}
	 @Transactional
	public void deleteCli(Cliente cliente) {
		repocliente.delete(cliente);
	}

	 @Transactional
	public void updateCat(Categoria categoria) {
		 repocategoria.update(categoria);
	}
	 @Transactional
	public void updateCli(Cliente cliente) {
		repocliente.update(cliente);
		
	}


}
