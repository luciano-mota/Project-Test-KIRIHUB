package com.project.kirihub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.kirihub.entity.TaxaSelic;
import com.project.kirihub.service.SelicService;

@RestController
@RequestMapping(path = "/dados")
public class TaxaSelicController {

	@Autowired
	private SelicService service;
	
	@GetMapping(path = "/{dias}")
	public ResponseEntity<?> buscarDadosSelic(@PathVariable String dias) { 
		return service.getTaxaSelicPorDias(dias);
	}
}
