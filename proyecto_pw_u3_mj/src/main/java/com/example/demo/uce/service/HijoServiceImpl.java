package com.example.demo.uce.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.uce.repository.IEmpleadoRepository;
import com.example.demo.uce.repository.IHijoRepository;
import com.example.demo.uce.repository.modelo.Hijo;
import com.example.demo.uce.service.To.EmpleadoTo;
import com.example.demo.uce.service.To.HijoTo;
@Service
public class HijoServiceImpl implements IHijoService {
	@Autowired
	private IHijoRepository hijoRepository;
	@Override
	public List<HijoTo> consultarHijo(Integer idEmpleado) {
		// TODO Auto-generated method stub
		List<Hijo> lista =this.hijoRepository.consultarHijo(idEmpleado);
		List<HijoTo> lista2 = lista.stream().map(hijo -> this.convertir(hijo)).collect(Collectors.toList());
		return lista2;
	}
	
private HijoTo convertir(Hijo hijo) {
	HijoTo hijoTo= new HijoTo();
	hijoTo.setId(hijo.getId());
	hijoTo.setNombre(hijo.getNombre());
	hijoTo.setGenero(hijo.getGenero());
	return hijoTo;
}
}
