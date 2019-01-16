package com.venta.test;

import java.util.Date;
import java.util.Formatter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Before;
import org.junit.Test;

import com.venta.dto.Cliente;
import com.venta.dto.Detalle;
import com.venta.dto.Factura;
import com.venta.dto.Producto;

public class AddTest2 {
	EntityManagerFactory enf;
	EntityManager en;
	@Before
	public void iniciar(){
		enf = Persistence.createEntityManagerFactory("venta");
		en = enf.createEntityManager();
	}
	@Test
	public void AddCliente() {
		en.getTransaction().begin();
		Cliente c1 = new Cliente("Elmer 1", "Blas 1", "Huaraz 1", "00000001");
		en.persist(c1);
		en.getTransaction().commit();
		
		/************* FACTURA - DETALLE *************/
		en.getTransaction().begin();
		Date fecha = new Date();
		Cliente cliente_id = en.find(Cliente.class, 1);
		Factura c = new Factura(1, 2, fecha, cliente_id);
		en.persist(c);
		// DETALLE
		Producto producto_id = en.find(Producto.class, 1);
		Factura factura_id = en.find(Factura.class, 1);
		Detalle d = new Detalle(12, 10, producto_id, factura_id);
		en.persist(d);
		en.getTransaction().commit();
	}
}