package com.example.demo.uce.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.demo.uce.repository.modelo.Hijo;
@Repository
@Transactional
public class HijoRepositoryImpl implements IHijoRepository{
	@PersistenceContext
	private EntityManager entityManager;
	@Override
	public java.util.List<Hijo> consultarHijo(Integer idEmpleado) {
	TypedQuery<Hijo> query=this.entityManager.createQuery( "SELECT e from Hijo e Where e.empleado.id=:idEmpleado",Hijo.class);
	query.setParameter("idEmpleado", idEmpleado);
	return query.getResultList();
	}
	

}
