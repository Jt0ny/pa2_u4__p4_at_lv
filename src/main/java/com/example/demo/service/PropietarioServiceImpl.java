package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.PropietarioRepository;
import com.example.demo.repository.modelo.Propietario;

import jakarta.transaction.Transactional;import jakarta.transaction.Transactional.TxType;

@Service
public class PropietarioServiceImpl implements PropietarioService {

	@Autowired
	private PropietarioRepository propietarioRepository;
	
	@Override
	public Propietario buscarPorId(Integer id) {
		
		return this.propietarioRepository.buscarPorId(id);
	}

	@Override
	public void guardar(Propietario propietario) {
		this.propietarioRepository.insetar(propietario);
		
	}

	@Override
	public void actualizar(Propietario propietario) {
		this.propietarioRepository.actualizar(propietario);
		
	}

	@Override
	public void borrar(Integer id) {
		this.propietarioRepository.eliminar(id);
		
	}

	@Override
	public List<Propietario> buscarTodos() {
		
		return this.propietarioRepository.buscarTodos();
	}

}
