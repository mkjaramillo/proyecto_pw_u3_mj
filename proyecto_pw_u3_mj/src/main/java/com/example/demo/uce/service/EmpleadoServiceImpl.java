package com.example.demo.uce.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.uce.repository.EmpleadoRepositoryImpl;
import com.example.demo.uce.repository.IEmpleadoRepository;
import com.example.demo.uce.repository.modelo.Empleado;
import com.example.demo.uce.service.To.EmpleadoTo;

@Service
public class EmpleadoServiceImpl implements IEmpleadoService {
	@Autowired
	private IEmpleadoRepository empleadoRepository;

	@Override
	public void crear(Empleado empleado) {
		this.empleadoRepository.crear(empleado);
	}

	@Override
	public void actualizar(Empleado empleado) {
		this.empleadoRepository.actualizar(empleado);
	}

	@Override
	public Empleado buscarId(Integer id) {

		return this.empleadoRepository.buscar(id);
	}

	@Override
	public void eliminar(Integer id) {
		this.empleadoRepository.eliminar(id);
	}

	@Override
	public List<Empleado> empleadoSalario(BigDecimal salario) {
		// TODO Auto-generated method stub
		return this.empleadoRepository.empleadoSalario(salario);
	}

	@Override
	public List<EmpleadoTo> buscarTodos() {
		List<Empleado> lista = this.empleadoRepository.buscarTodos();
		List<EmpleadoTo> lista2 = lista.stream().map(empleado -> this.convertir(empleado)).collect(Collectors.toList());
		return lista2;
	}

	private EmpleadoTo convertir(Empleado empl) {
		EmpleadoTo empleado = new EmpleadoTo();
		empleado.setId(empl.getId());
		empleado.setNombre(empl.getNombre());
		empleado.setApellido(empl.getApellido());
		empleado.setFechaNacimiento(empl.getFechaNacimiento());
		return empleado;

	}

}
