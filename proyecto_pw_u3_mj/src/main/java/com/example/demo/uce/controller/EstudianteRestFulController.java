package com.example.demo.uce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.uce.repository.modelo.Empleado;
import com.example.demo.uce.repository.modelo.Estudiante;
import com.example.demo.uce.service.IEstudianteService;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteRestFulController {
	@Autowired
private IEstudianteService estudianteService;
@PostMapping
public String crearEstudiante(@RequestBody Estudiante estudiante) {
	String mensaje = "Estudiante insertado con exito";
	try {
		this.estudianteService.crear(estudiante);
	} catch (Exception e) {
		mensaje = "Error intente mas tarde";

	}

	return mensaje;
}
@PutMapping
public String actualizarEstudiante(@RequestBody Estudiante estudiante) {
	String mensaje = "Empleado actualizado con exito";
	try {
		this.estudianteService.actualizar(estudiante);
	} catch (Exception e) {
		mensaje = "Error intente mas tarde";

	}

	return mensaje;
}
@GetMapping(path="/{idEstudiante}")
public ResponseEntity<Estudiante>buscarEstudiante(@PathVariable("idEstudiante") Integer id){
	Estudiante est=this.estudianteService.buscarId(id);
	
	return ResponseEntity.ok(est);
}
@DeleteMapping(path="/{idEstudiante}")
public String eliminarEstudiante(@PathVariable("idEstudiante")Integer idEst) {
	String mensaje = "Estudiante eliminado con exito";
	try {
		this.estudianteService.eliminar(idEst);
	} catch (Exception e) {
		mensaje = "Error intente mas tarde";

	}

	return mensaje;
}
@GetMapping
public List<Estudiante> estudianteAllSemestre(@RequestParam(value="semes")String semestre){
	return this.estudianteService.estudianteAllSemestre(semestre);
}

}
