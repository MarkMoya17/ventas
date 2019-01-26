package com.venta.proy;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

@Entity
@Table(name="producto")
public class Producto{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@NotNull
	@Size(min=6,max=20)
	private String nombre;
	//@Min(1)
	private int stock;
	
	
	//Uno a uno
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="categoria_id", nullable = false)
	
	private Categoria categoria;

	public Producto(String nombre, int stock, Categoria categoria) {
		super();
		this.nombre = nombre;
		this.stock = stock;
		this.categoria = categoria;
	}
	
	
	public Producto(int id) {
		super();
		this.id = id;
	}


	public Producto() {
		super();
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

}
