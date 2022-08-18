package com.c4.ud26.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.c4.ud26.dao.IProductoDAO;
import com.c4.ud26.dto.Producto;

@Service
public class ProductoServiceImpl implements IProductoService{
	
	@Autowired
	IProductoDAO iProductoDAO;

	@Override
	public List<Producto> listarProductos() {
		// TODO Auto-generated method stub
		return iProductoDAO.findAll();
	}

	@Override
	public Producto guardarProducto(Producto producto) {
		// TODO Auto-generated method stub
		return iProductoDAO.save(producto);
	}

	@Override
	public Producto productoXID(Long id) {
		// TODO Auto-generated method stub
		return iProductoDAO.findById(id).get();
	}

	@Override
	public Producto actulizarProducto(Producto producto) {
		// TODO Auto-generated method stub
		return iProductoDAO.save(producto);
	}

	@Override
	public void eliminarProducto(Long id) {
		iProductoDAO.deleteById(id);	
	}

}
