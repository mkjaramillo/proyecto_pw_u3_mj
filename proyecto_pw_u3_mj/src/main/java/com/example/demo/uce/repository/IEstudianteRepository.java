package com.example.demo.uce.repository;

import java.math.BigDecimal;
import java.util.List;

import com.example.demo.uce.repository.modelo.Empleado;
import com.example.demo.uce.repository.modelo.Estudiante;

public interface IEstudianteRepository {
	public void crear(Estudiante estudiante);
	public void actualizar(Estudiante estudiante);
	public void eliminar(Integer id);
	public Estudiante buscar(Integer id);
	public List<Estudiante> estudianteAllSemestre(String semestre);
}
