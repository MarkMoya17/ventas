package com.venta.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.venta.proy.Categoria;
import com.venta.proy.Producto;
import com.venta.repositorios.jpa.CategoriaRepositoryJPA;
import com.venta.repositorios.jpa.ProductoRepositoryJPA;
import com.venta.servicios.jpa.ServicioVentaJPA;

public class ServicioProducto {
	ProductoRepositoryJPA repoprod;
	CategoriaRepositoryJPA repocat;
	ServicioVentaJPA servprod;
	
	//NoticiaRepositoryJPA repositorio;
		
		@Before
		public void setup() {
			
			repoprod= new ProductoRepositoryJPA();
			repocat= new CategoriaRepositoryJPA();
			servprod= new ServicioVentaJPA();
		}
		
		
			
			
		}
		


