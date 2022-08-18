package com.c4.ud26.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="cajeros")
public class Cajero {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@Column(name="nombre_apels")
	private String nombre_apels;
	
	@OneToMany
	@JoinColumn(name="codigo_cajero")
	private List<Venta> ventas;

	public Cajero() {
	}

	public Cajero(String nombre_apels) {
		this.nombre_apels = nombre_apels;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNombre_apels() {
		return nombre_apels;
	}

	public void setNombre_apels(String nombre_apels) {
		this.nombre_apels = nombre_apels;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Venta")
	public List<Venta> getVentas() {
		return ventas;
	}

	public void setVentas(List<Venta> ventas) {
		this.ventas = ventas;
	}

	@Override
	public String toString() {
		return "Cajero [codigo=" + codigo + ", nombre_apels=" + nombre_apels + ", ventas=" + ventas + "]";
	}

	
}
