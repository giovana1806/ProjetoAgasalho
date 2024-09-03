package com.projetoAgasalho.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetoAgasalho.entity.Ponto;
import com.projetoAgasalho.repository.PontoRepository; 
  
@Service 
public class PontoService { 
  
	private final PontoRepository pontoRepository; 
  
	@Autowired 
	public PontoService(PontoRepository pontoRepository) { 
		this.pontoRepository = pontoRepository; 
	} 
	public List<Ponto> buscaTodosPontos(){ 
		return pontoRepository.findAll(); 
	} 
	public Ponto buscaPontoId(Long id) { 
		Optional <Ponto> existePonto = pontoRepository.findById(id); 
		return existePonto.orElse(null); 
	} 
	public Ponto salvaPonto(Ponto ponto) { 
		return pontoRepository.save(ponto);		 
	} 
	public Ponto alterarPonto(Long id, Ponto alterarPonto) { 
		Optional <Ponto> existePonto = pontoRepository.findById(id); 
		if (existePonto.isPresent()) { 
			alterarPonto.setId(id);; 
			return pontoRepository.save(alterarPonto); 
		} 
		return null; 
	} 
	public boolean apagarPonto(Long id) { 
		Optional <Ponto> existePonto = pontoRepository.findById(id); 
		if (existePonto.isPresent()) { 
			pontoRepository.deleteById(id); 
			return true; 
		} 
		return false; 
	} 
} 
