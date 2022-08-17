package com.c4.ud26.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ventas")
public class Venta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="codigo_producto")
	private Producto productos;
	
	@ManyToOne
	@JoinColumn(name="codigo_cajero")
	private Cajero cajero;
	
	@ManyToOne
	@JoinColumn(name="codigo_maquina_registradora")
	private MaquinaRegistradora maquinaRegistradora;
	
	public Venta() {
	}

	public Venta(Producto productos, Cajero cajero, MaquinaRegistradora maquinaRegistradora) {
		this.productos = productos;
		this.cajero = cajero;
		this.maquinaRegistradora = maquinaRegistradora;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Producto getProductos() {
		return productos;
	}

	public void setProductos(Producto productos) {
		this.productos = productos;
	}

	public Cajero getCajero() {
		return cajero;
	}

	public void setCajero(Cajero cajero) {
		this.cajero = cajero;
	}

	public MaquinaRegistradora getMaquinaRegistradora() {
		return maquinaRegistradora;
	}

	public void setMaquinaRegistradora(MaquinaRegistradora maquinaRegistradora) {
		this.maquinaRegistradora = maquinaRegistradora;
	}

	@Override
	public String toString() {
		return "Venta [id=" + id + ", productos=" + productos + ", cajero=" + cajero + ", maquinaRegistradora="
				+ maquinaRegistradora + "]";
	}	
}
