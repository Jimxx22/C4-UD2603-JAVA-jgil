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

import com.c4.ud26.dto.MaquinaRegistradora;
import com.c4.ud26.service.MaquinaRegistradoraServiceImpl;

@RestController
@RequestMapping("/api")
public class MaquinaRegistradoraController {

	@Autowired 
	MaquinaRegistradoraServiceImpl maquinaRegistradoraServiceImpl;
	
	@GetMapping("/maquinasRegistradoras")
	public List<MaquinaRegistradora> listarMaquinasRegistradoras(){
		return maquinaRegistradoraServiceImpl.listarMaquinaRegistradoras();
	}
	
	@PostMapping("/maquinasRegistradoras")
	public MaquinaRegistradora guardarMaquinaRegistradora(@RequestBody MaquinaRegistradora maquinaRegistradora) {
		return maquinaRegistradoraServiceImpl.guardarMaquinaRegistradora(maquinaRegistradora);
	}
	
	@GetMapping("/maquinasRegistradoras/{codigo}")
	public MaquinaRegistradora MaquinaRegistradoraXID(@PathVariable(name="codigo") Long id) {
		
		MaquinaRegistradora MaquinaRegistradoraXID = new MaquinaRegistradora();
		
		MaquinaRegistradoraXID=maquinaRegistradoraServiceImpl.maquinaRegistradoraXID(id);
		
		return MaquinaRegistradoraXID;
	}
	
	@PutMapping("/maquinasRegistradoras/{codigo}")
	public MaquinaRegistradora actualizarMaquinaRegistradora(@PathVariable(name="codigo") Long id, @RequestBody MaquinaRegistradora maquinaRegistradora) {
		
		MaquinaRegistradora maquinaRegistradoraSel = new MaquinaRegistradora();
		MaquinaRegistradora maquinaRegistradoraAct = new MaquinaRegistradora();
		
		maquinaRegistradoraSel=maquinaRegistradoraServiceImpl.maquinaRegistradoraXID(id);
		
		maquinaRegistradoraSel.setPiso(maquinaRegistradora.getPiso());
		
		maquinaRegistradoraAct=maquinaRegistradoraServiceImpl.actualizarMaquinaRegistradora(maquinaRegistradoraSel);
		
		return maquinaRegistradoraAct;
	}
	
	@DeleteMapping("/maquinasRegistradoras/{codigo}")
	public String eliminarMaquinaRegistradora(@PathVariable(name="codigo") Long id) {
		try {
			maquinaRegistradoraServiceImpl.eliminarMaquinaRegistradora(id);
			return "Maquina registradora eliminada";
		}catch (Exception e) {
			return "Error: no puedes borrar esta maquina registradora ya que tiene alguna vanta asiganda";
		}
	}
}
