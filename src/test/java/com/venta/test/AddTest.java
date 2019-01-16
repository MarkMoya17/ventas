package com.venta.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.Before;
import org.junit.Test;
import com.venta.dto.Categoria;
import com.venta.dto.Producto;

public class AddTest {
	EntityManagerFactory enf;
	EntityManager en;
	@Before
	public void iniciar(){
		enf = Persistence.createEntityManagerFactory("venta");
		en = enf.createEntityManager();
	}
	@Test
	public void AddCategoria() {
		en.getTransaction().begin();
		Categoria ncat = new Categoria(1, "bebiba a");
		Categoria ncat1 = new Categoria(2, "bebiba b");
		en.persist(ncat);
		en.persist(ncat1);
		en.getTransaction().commit();
		// ********************
		Categoria c1 = en.find(Categoria.class, 1);
		Categoria c2 = en.find(Categoria.class, 2);
		en.getTransaction().begin();
		Producto p11 = new Producto("Cerveza cuzqueña", 180, c1);
		Producto p12 = new Producto("Cerveza pilsen", 200, c1);
		Producto p21 = new Producto("Cerveza cristal", 100, c2);
		Producto p22 = new Producto("Cerveza corona", 130, c2);
		en.persist(p11);
		en.persist(p12);
		en.persist(p21);
		en.persist(p22);
		en.getTransaction().commit();
	}
}
