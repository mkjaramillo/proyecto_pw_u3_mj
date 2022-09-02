package com.example.demo.uce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.uce.service.IHijoService;
import com.example.demo.uce.service.To.HijoTo;

@RestController
@RequestMapping("/hijos")
public class HijosRestFulController {
	@Autowired
	private IHijoService hijoService;
	@GetMapping
	public List<HijoTo> buscarTodos(){
		return null;
	}
}
