package com.example.demo.uce.repository;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.demo.uce.repository.modelo.Empleado;
import com.example.demo.uce.repository.modelo.Hijo;

import antlr.collections.List;
@Repository
@Transactional
public class EmpleadoRepositoryImpl implements IEmpleadoRepository {
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void crear(Empleado empleado) {
		this.entityManager.persist(empleado);
	}

	@Override
	public void actualizar(Empleado empleado) {
		this.entityManager.merge(empleado);
		
	}
	@Override
	public Empleado buscar(Integer id) {
		return 		this.entityManager.find(Empleado.class, id);

	}
	@Override
	public void eliminar(Integer id) {
		this.entityManager.remove(this.buscar(id));
	}
	{
		
	}
	@Override
	public java.util.List<Empleado> empleadoSalario(BigDecimal salario) {
	TypedQuery<Empleado> query=this.entityManager.createQuery( "SELECT e from Empleado e WHERE e.salario>:salarioDato ",Empleado.class);
	query.setParameter("salarioDato", salario);	
	return query.getResultList();
	}
	@Override
	public java.util.List<Empleado> buscarTodos() {
	TypedQuery<Empleado> query=this.entityManager.createQuery( "SELECT e from Empleado e",Empleado.class);
	return query.getResultList();
	}
	@Override
	public java.util.List<Hijo> consultarHijo(Integer idEmpleado) {
	TypedQuery<Hijo> query=this.entityManager.createQuery( "SELECT e from Hijo e Where e.empleado.id=:idEmpleado",Hijo.class);
	query.setParameter("idEmpleado", idEmpleado);
	return query.getResultList();
	}
	
	

}
