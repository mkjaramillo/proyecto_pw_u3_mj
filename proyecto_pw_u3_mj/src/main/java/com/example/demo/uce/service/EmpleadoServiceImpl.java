package com.example.demo.uce.service;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.uce.repository.EmpleadoRepositoryImpl;
import com.example.demo.uce.repository.IEmpleadoRepository;
import com.example.demo.uce.repository.modelo.Empleado;
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
	
	
}
