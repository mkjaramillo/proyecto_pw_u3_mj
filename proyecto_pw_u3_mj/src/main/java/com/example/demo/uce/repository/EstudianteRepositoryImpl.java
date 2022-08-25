package com.example.demo.uce.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.demo.uce.repository.modelo.Estudiante;

@Repository
@Transactional
public class EstudianteRepositoryImpl implements IEstudianteRepository {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void crear(Estudiante estudiante) {
		this.entityManager.persist(estudiante);
	}

	@Override
	public void actualizar(Estudiante estudiante) {
		this.entityManager.merge(estudiante);
	}

	@Override
	public Estudiante buscar(Integer id) {
		return this.entityManager.find(Estudiante.class, id);
	}

	@Override
	public void eliminar(Integer id) {
		this.entityManager.remove(this.buscar(id));
	}

	@Override
	public List<Estudiante> estudianteAllSemestre(String semestre) {
		TypedQuery<Estudiante>query=this.entityManager.createQuery("SELECT e from Estudiante e WHERE e.semestre=:semestreDato",Estudiante.class);
		query.setParameter("semestreDato", semestre);
		return  query.getResultList();
	}

}
