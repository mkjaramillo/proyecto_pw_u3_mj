package com.example.demo.uce.service;

import com.example.demo.uce.repository.modelo.Hijo;
import com.example.demo.uce.service.To.HijoTo;

public interface IHijoService {
	public java.util.List<HijoTo> consultarHijo(Integer idEmpleado);
}
