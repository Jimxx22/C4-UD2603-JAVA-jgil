package com.c4.ud26.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.c4.ud26.dao.IMaquinaRegistradoraDAO;
import com.c4.ud26.dto.MaquinaRegistradora;

@Service
public class MaquinaRegistradoraServiceImpl implements IMaquinaRegistradoraServeice{
	
	@Autowired
	IMaquinaRegistradoraDAO iMaquinaRegistradoraDAO;

	@Override
	public List<MaquinaRegistradora> listarMaquinaRegistradoras() {
		// TODO Auto-generated method stub
		return iMaquinaRegistradoraDAO.findAll();
	}

	@Override
	public MaquinaRegistradora guardarMaquinaRegistradora(MaquinaRegistradora MaquinaRegistradora) {
		// TODO Auto-generated method stub
		return iMaquinaRegistradoraDAO.save(MaquinaRegistradora);
	}

	@Override
	public MaquinaRegistradora maquinaRegistradoraXID(Long id) {
		// TODO Auto-generated method stub
		return iMaquinaRegistradoraDAO.findById(id).get();
	}

	@Override
	public MaquinaRegistradora actualizarMaquinaRegistradora(MaquinaRegistradora MaquinaRegistradora) {
		// TODO Auto-generated method stub
		return iMaquinaRegistradoraDAO.save(MaquinaRegistradora);
	}

	@Override
	public void eliminarMaquinaRegistradora(Long id) {
		// TODO Auto-generated method stub
		iMaquinaRegistradoraDAO.deleteById(id);
	}

}
