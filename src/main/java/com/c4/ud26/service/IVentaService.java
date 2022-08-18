package com.c4.ud26.service;

import java.util.List;

import com.c4.ud26.dto.Venta;

public interface IVentaService {

	public List<Venta> listarVentas();
	
	public Venta guardarVenta(Venta venta);
	
	public Venta ventaXID (Long id);
	
	public Venta actualitzarVenta(Venta venta);
	
	public void eliminarVenta(Long id);
}
