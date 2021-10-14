package com.project.kirihub.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.kirihub.ResponseDTO.ProdutoResponseDTO;
import com.project.kirihub.ResponseDTO.RetornoDeDadosDeCompra;
import com.project.kirihub.requestDTO.ProdutoRequestDTO;
import com.project.kirihub.service.ProdutoService;

import io.swagger.annotations.Api;
import javassist.NotFoundException;

@RestController
@RequestMapping(value = "/produtos")
@Api(value = "API REST Produto")
@CrossOrigin(origins = "*")
public class ProdutoController {
	
	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping(value = "/find-all")
	public ResponseEntity<List<ProdutoResponseDTO>> findAll(){
		List<ProdutoResponseDTO> list = produtoService.findAll().stream().map((obj) -> new ProdutoResponseDTO(obj)).collect(Collectors.toList());
		return new ResponseEntity<List<ProdutoResponseDTO>>(list, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ProdutoResponseDTO> findById(@PathVariable Long id) throws NotFoundException{
		ProdutoResponseDTO dto = produtoService.findById(id);
		return ResponseEntity.ok().body(dto);
	}
	
	@GetMapping(value = "/nome")
	public ResponseEntity<ProdutoResponseDTO> findByName(@RequestParam String name) throws NotFoundException{
		ProdutoResponseDTO dto = produtoService.findByName(name);
		return ResponseEntity.ok().body(dto);
	}
	
	@PostMapping(value = "/parcelamento")
	public ResponseEntity<RetornoDeDadosDeCompra> compraParcelada(@RequestBody ProdutoRequestDTO produtoDTO) throws NotFoundException{
		return ResponseEntity.ok(produtoService.compraParcelada(produtoDTO));
	}
}
