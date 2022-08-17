package com.c4.ud26.service;

import java.util.List;

import com.c4.ud26.dto.Producto;

public interface IProductoService {

	public List<Producto> listarProductos();
	
	public Producto guardarProducto(Producto producto);
	
	public Producto productoXID(Long id);
	
	public Producto actulizarProducto(Producto producto);
	
	public void eliminarProducto(Long id);
}
