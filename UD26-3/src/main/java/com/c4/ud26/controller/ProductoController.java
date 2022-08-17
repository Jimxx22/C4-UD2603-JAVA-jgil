package com.c4.ud26.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.c4.ud26.dto.Producto;
import com.c4.ud26.service.ProductoServiceImpl;

@RestController
@RequestMapping("/api")
public class ProductoController {

	@Autowired
	ProductoServiceImpl productoServiceImpl;
	
	@GetMapping("/productos")
	public List<Producto> listarProductos(){
		return productoServiceImpl.listarProductos();
	}
	
	@PostMapping("/productos")
	public Producto guardarProducto(@RequestBody Producto producto) {
		return productoServiceImpl.guardarProducto(producto);
	}
	
	@GetMapping("/productos/{codigo}")
	public Producto ProductoXID(@PathVariable(name="codigo") Long id) {
		return productoServiceImpl.productoXID(id);
	}
	
	@PutMapping("/productos/{codigo}")
	public Producto actualizarProducto(@PathVariable(name="codigo") Long id, @RequestBody Producto producto) {
		Producto productoSel= new Producto();
		Producto productoAct= new Producto();
		
		productoSel=productoServiceImpl.productoXID(id);
		
		productoSel.setNombre(producto.getNombre());
		productoSel.setPrecio(producto.getPrecio());
		
		productoAct= productoServiceImpl.actulizarProducto(productoSel);
		
		return productoAct;
		
	}
	
	@DeleteMapping("/productos/{codigo}")
	public String eliminarProducto(@PathVariable(name="codigo") Long id) {
		try {
			productoServiceImpl.eliminarProducto(id);
			return "Producto eliminado";
		}catch (Exception e) {
			return "Error: no puedes borrar este producto ya que tiene ventas asignadas";
		}
		
	}
}
