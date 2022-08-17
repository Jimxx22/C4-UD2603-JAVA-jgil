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

import com.c4.ud26.dto.Venta;
import com.c4.ud26.service.VentaServiceImpl;

@RestController
@RequestMapping("/api")
public class VentaController {
	
	@Autowired 
	VentaServiceImpl ventaServiceImpl;
	
	@GetMapping("/ventas")
	public List<Venta> listarVantas(){
		return ventaServiceImpl.listarVentas();
	}
	
	@PostMapping("/ventas")
	public Venta guardarVenta(@RequestBody Venta venta) {
		return ventaServiceImpl.guardarVenta(venta);
	}
	
	@GetMapping("/ventas/{id}")
	public Venta asignadoAXID(@PathVariable(name="id") Long id) {
		
		Venta asignadoAXID = new Venta();
		
		asignadoAXID=ventaServiceImpl.ventaXID(id);
		
		return asignadoAXID;
	}

	@PutMapping("/ventas/{id}")
	public Venta actualizarVenta(@PathVariable(name="id") Long id, @RequestBody Venta venta) {
		
		Venta ventaSel = new Venta();
		Venta ventaAct = new Venta();
		
		ventaSel=ventaServiceImpl.ventaXID(id);
		
		ventaSel.setProductos(venta.getProductos());
		ventaSel.setCajero(venta.getCajero());
		ventaSel.setMaquinaRegistradora(venta.getMaquinaRegistradora());
		
		ventaAct = ventaServiceImpl.actualitzarVenta(ventaSel);
		
		return ventaAct;		
	}
	
	@DeleteMapping("/ventas/{id}")
	public void eliminsarVenta(@PathVariable(name="id") Long id) {
		ventaServiceImpl.eliminarVenta(id);
	}
}
