package com.venta.test;

import static org.junit.Assert.assertNotNull;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.*;

import com.venta.proy.Categoria;
import com.venta.proy.Producto;

public class AddTest extends JPAUnitTest{
	
	
	@Test
	public void entityManagerFactoryOK() {
		assertNotNull(emf);
	}
	
	
	@Test 
	public void insertar() {
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
