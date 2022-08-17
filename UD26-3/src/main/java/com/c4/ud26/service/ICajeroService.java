package com.c4.ud26.service;

import java.util.List;

import com.c4.ud26.dto.Cajero;

public interface ICajeroService {

	public List<Cajero> listarCajeros();
	
	public Cajero guardarCajero(Cajero Cajero);
	
	public Cajero cajeroXID(Long id);
	
	public Cajero actulizarCajero(Cajero Cajero);
	
	public void eliminarCajero(Long id);
}
