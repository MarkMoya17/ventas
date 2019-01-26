package com.venta.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.venta.proy.Categoria;
import com.venta.proy.Producto;
import com.venta.repositorios.jpa.ProductoRepositoryJPA;

public class VentaRepositoryTest extends JPAUnitTest{
	ProductoRepositoryJPA repoprod;
	
//NoticiaRepositoryJPA repositorio;
	
	@Before
	public void setup() {
		super.setup();
		repoprod= new ProductoRepositoryJPA();
		repoprod.setEm(em);
	}
	
	@Test
	public void inyectarEntityManager() {
		
		assertEquals(em,repoprod.getEm());
		
	}
	@Test
	public void seleccionarTodasLasNoticias() {
		
		Producto p=repoprod.findAll().iterator().next();
		assertEquals(1,p.getId());
	}
	@Test
	public void insertarproducto() {
		em.getTransaction().begin();
		Categoria ncat = new Categoria("Quesos");
		Categoria ncat1 = new Categoria("Gaseosa");
	
		em.persist(ncat);
		em.persist(ncat1);
		em.getTransaction().commit();
	
	
	Categoria c = em.find(Categoria.class, 1);
	Categoria c1 = em.find(Categoria.class, 2);
		em.getTransaction().begin();
		Producto p = new Producto("Chedar",100,c);
		Producto p1 = new Producto("Coca Cola",200,c1);
		Producto p3 = new Producto("Inka Cola",200,c1);
		em.persist(p);
		em.persist(p1);
		em.persist(p3);
		em.getTransaction().commit();
		
		
	}
	
	
	

}
