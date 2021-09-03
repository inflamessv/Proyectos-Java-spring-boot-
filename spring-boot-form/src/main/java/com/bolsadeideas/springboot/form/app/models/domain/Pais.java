package com.bolsadeideas.springboot.form.app.models.domain;

import javax.validation.constraints.NotNull;

public class Pais {
	
	@NotNull
	private Integer id;
	private String nombre;
	private String codigo;
		
	public Pais() {
		
	}

	public Pais(Integer id, String nombre, String codigo) {
		this.id = id;
		this.nombre = nombre;
		this.codigo = codigo;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@Override
	public String toString() {
		return this.id.toString();
	}

	
}
