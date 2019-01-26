package com.venta.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.venta.config.ConfiguracionSpring;
import com.venta.proy.*;
import com.venta.repositorios.CategoriaRepository;
import com.venta.repositorios.ProductoRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ConfiguracionSpring.class)
public class ServicioProductoSpring {

	@Autowired
	ProductoRepository repoprod;

	@Autowired
	CategoriaRepository repocat;
	
	@Test
	public void inyectarRepositorio() {

		assertNotNull(repoprod);

	}

	@Test
	public void seleccionarTodasLosProductos() {

		Producto p = repoprod.findAll().iterator().next();
		assertEquals(1, p.getId());
	}

	@Test

	public void insertarProducto() {

		// em.getTransaction().begin();
		Categoria c =repocat.findOne(1);
		Producto prodNuevo = new Producto("Queso Freso", 123, c);
		repoprod.save(prodNuevo);
	

	}
}
