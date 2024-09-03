package com.projetoAgasalho.entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PontosTest {

	private Ponto ponto;
	
	@BeforeEach
	void setUp() {
		//Arrange
		ponto = new Ponto(1L, "Escola Alegria", "Moletom");
	}

	@Test
	@DisplayName("Testando o getter e setter do id")
	void testId() {
		//Act
		ponto.setId(2L);
		//Assert
		assertEquals(2L, ponto.getId());
	}
	
	@Test
	@DisplayName("Testando o getter e setter do pontoColeta")
	void testPonto() {
		//Act
		ponto.setPontoColeta("Postinho Villa Arruda");
		//Assert
		assertEquals("Postinho Villa Arruda", ponto.getPontoColeta());
	}
	
	@Test
	@DisplayName("Testando o getter e setter do itemFalta")
	void testEmail() {
		//Act
		ponto.setArtigosFalta("cobertor");
		//Assert
		assertEquals("cobertor", ponto.getArtigosFalta());
	}
	
	@Test
	@DisplayName("Testando o construtor com todos os argumentos")
	void testConstrutorAll() {
		//Act
		Ponto novoPonto = new Ponto(3L, "Hospital Cure", "Calça");
		//Assert
		assertAll("novoPonto",
				()-> assertEquals(3L, novoPonto.getId()),
				()-> assertEquals("Hospital Cure", novoPonto.getPontoColeta()),
				()-> assertEquals("Calça", novoPonto.getArtigosFalta()));
	}
	

}
