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

import com.c4.ud26.dto.Cajero;
import com.c4.ud26.service.CajeroServiceImpl;

@RestController
@RequestMapping("/api")
public class CajeroController {

	@Autowired
	CajeroServiceImpl cajeroServiceImpl;
	
	@GetMapping("/cajeros")
	public List<Cajero> listarCajeros(){
		return cajeroServiceImpl.listarCajeros();
	}
	
	@PostMapping("/cajeros")
	public Cajero guardarCajero(@RequestBody Cajero cajero) {
		return cajeroServiceImpl.guardarCajero(cajero);
	}
	
	@GetMapping("/cajeros/{codigo}")
	public Cajero CajeroXID(@PathVariable(name="codigo") Long id) {
		return cajeroServiceImpl.cajeroXID(id);
	}
	
	@PutMapping("/cajeros/{codigo}")
	public Cajero actualizarCajero(@PathVariable(name="codigo") Long id, @RequestBody Cajero cajero) {
		Cajero cajeroSel= new Cajero();
		Cajero cajeroAct= new Cajero();
		
		cajeroSel=cajeroServiceImpl.cajeroXID(id);
		
		cajeroSel.setNombre_apels(cajero.getNombre_apels());
		
		cajeroAct= cajeroServiceImpl.actulizarCajero(cajeroSel);
		
		return cajeroAct;
	}
	
	@DeleteMapping("/cajeros/{codigo}")
	public String eliminarCajero(@PathVariable(name="codigo") Long id) {
		try {
			cajeroServiceImpl.eliminarCajero(id);
			return "Cajero eliminado";
		}catch (Exception e) {
			return "Error: no puedes borrar este cajero ya que tiene ventas asignadas";
		}
		
	}
}
