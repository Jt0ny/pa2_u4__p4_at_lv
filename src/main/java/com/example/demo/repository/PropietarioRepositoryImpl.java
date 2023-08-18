package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Propietario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Repository
@Transactional
public class PropietarioRepositoryImpl implements PropietarioRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Propietario buscarPorId(Integer id) {
		return this.entityManager.find(Propietario.class, id);
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void insetar(Propietario propietario) {
		this.entityManager.persist(propietario);
		
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void actualizar(Propietario propietario) {
		this.entityManager.merge(propietario);
		
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void eliminar(Integer id) {
		Propietario a1=this.buscarPorId(id);
		this.entityManager.remove(a1);
		
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public List<Propietario> buscarTodos() {
		TypedQuery<Propietario> query=this.entityManager.createQuery("SELECT e FROM Propietario e",Propietario.class);
		
		return query.getResultList();
	}

}
