package com.c4.ud26.service;

import java.util.List;

import com.c4.ud26.dto.MaquinaRegistradora;

public interface IMaquinaRegistradoraServeice {
	
	public List<MaquinaRegistradora> listarMaquinaRegistradoras();
	
	public MaquinaRegistradora guardarMaquinaRegistradora(MaquinaRegistradora MaquinaRegistradora);
	
	public MaquinaRegistradora maquinaRegistradoraXID(Long id);
	
	public MaquinaRegistradora actualizarMaquinaRegistradora(MaquinaRegistradora MaquinaRegistradora);
	
	public void eliminarMaquinaRegistradora(Long id);

}
