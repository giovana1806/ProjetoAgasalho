package com.projetoAgasalho.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetoAgasalho.entity.Ponto;
import com.projetoAgasalho.services.PontoService;

import jakarta.validation.Valid; 
  
@RestController 
@RequestMapping("/ponto") 
public class PontoController { 

	private final PontoService pontoService; 
  
	@Autowired 
	public PontoController(PontoService pontoService) { 
		this.pontoService = pontoService; 
	} 
	 
	@GetMapping("/{id}") 
	public ResponseEntity<Ponto> buscaPontoControlId(@PathVariable Long id){ 
		Ponto ponto  = pontoService.buscaPontoId(id); 
		if(ponto != null) { 
			return ResponseEntity.ok(ponto); 
		} 
		else { 
			return ResponseEntity.notFound().build(); 
		} 
  
	} 
	@GetMapping 
	public ResponseEntity<List<Ponto>> buscaTodosPontosControl(){ 
		List<Ponto> pontos = pontoService.buscaTodosPontos(); 
		return ResponseEntity.ok(pontos); 
	} 
  
	@PostMapping 
	public ResponseEntity<Ponto> salvaPontosControl(@RequestBody @Valid Ponto ponto){ 
		Ponto salvaPonto = pontoService.salvaPonto(ponto); 
		return ResponseEntity.status(HttpStatus.CREATED).body(salvaPonto); 
	} 
	 
	@PutMapping("/{id}") 
	public ResponseEntity<Ponto> alteraPontoControl(@PathVariable Long id, @RequestBody @Valid Ponto ponto){ 
		Ponto alteraPonto = pontoService.alterarPonto(id, ponto); 
		if(alteraPonto != null) { 
			return ResponseEntity.ok(ponto); 
		} 
		else { 
			return ResponseEntity.notFound().build(); 
		} 
	} 
	
	@DeleteMapping("/{id}") 
	public ResponseEntity<String> apagaPontoControl(@PathVariable Long id){ 
		boolean apagar = pontoService.apagarPonto(id); 
		if (apagar) { 
			return ResponseEntity.ok().body("O Ponto foi excluido com sucesso"); 
		} 
		else { 
			return ResponseEntity.notFound().build(); 
		} 
	} 
} 