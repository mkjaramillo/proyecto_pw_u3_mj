package com.example.demo.uce.service;

import java.math.BigDecimal;
import java.util.List;

import com.example.demo.uce.repository.modelo.Empleado;
import com.example.demo.uce.service.To.EmpleadoTo;

public interface IEmpleadoService {
	public void crear(Empleado empleado);
	public void actualizar(Empleado empleado);
	public Empleado buscarId(Integer id);
	public void eliminar(Integer id);
	public List<Empleado> empleadoSalario(BigDecimal salario);
	public java.util.List<EmpleadoTo> buscarTodos();

}
