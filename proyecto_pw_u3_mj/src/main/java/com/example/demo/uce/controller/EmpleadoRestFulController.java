package com.example.demo.uce.controller;


import java.math.BigDecimal;

import java.util.List;

import javax.websocket.server.PathParam;
import javax.xml.ws.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.RuntimeBeanNameReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
import com.example.demo.uce.service.IEmpleadoService;

@RestController
@RequestMapping("/empleados")
public class EmpleadoRestFulController {
	@Autowired
	private IEmpleadoService empleadoService;
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_XML_VALUE)
	public String crear(@RequestBody Empleado empleado) {
		String mensaje = "Empleado insertado con exito";
		try {
			this.empleadoService.crear(empleado);
		} catch (Exception e) {
			mensaje = "Error intente mas tarde";
			throw new RuntimeException();
		}

		return mensaje;
	}
	@PutMapping
	public String actualizar(@RequestBody Empleado empleado) {
		String mensaje = "Empleado actualizado con exito";
		try {
			this.empleadoService.actualizar(empleado);
		} catch (Exception e) {
			mensaje = "Error intente mas tarde";

		}

		return mensaje;
	}
	
	@GetMapping(path="/{idEmpleado}",produces=MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<Empleado> buscarEmpleado(@PathVariable("idEmpleado") Integer id) {
		Empleado empl=this.empleadoService.buscarId(id);
		
	return ResponseEntity.ok(empl);//hace referencia al 200
		
	}
	@GetMapping(path="/status/{idEmpleado}")
	public ResponseEntity<Empleado> buscarEmpleadoStatus(@PathVariable("idEmpleado") Integer id) {
		Empleado empl=this.empleadoService.buscarId(id);
		return ResponseEntity.status(HttpStatus.OK).body(empl);
	//	return ResponseEntity.ok(empl);//hace referencia al 200
		
	}
	@GetMapping(path="/headers/{idEmpleado}")
	public ResponseEntity<Empleado> buscarEmpleadoHeaders(@PathVariable("idEmpleado") Integer id) {
		HttpHeaders headers= new HttpHeaders();
		headers.add("detalleMensaje", "Esta bien pero envia un dato adicional");
		headers.add("solicitud", "recuerda consumirme mañana");
		headers.add("valor", "1");
		Empleado empl=this.empleadoService.buscarId(id);
		return  new ResponseEntity<>(empl,headers,HttpStatus.OK);
	//	return ResponseEntity.ok(empl);//hace referencia al 200
		
	}

	@DeleteMapping(path="/{idEmpleado}")
	public String eliminar(@PathVariable("idEmpleado")Integer  id) {
		this.empleadoService.eliminar(id);
		return "eliminado con exito ";
		
	}
	@GetMapping
	public List<Empleado> buscarEmpleadoSlario(@RequestParam(value="salario") BigDecimal salario, @RequestParam(value="provincia") String provincia){
		 System.out.println(provincia);
		return this.empleadoService.empleadoSalario(salario);
	}
	

}
