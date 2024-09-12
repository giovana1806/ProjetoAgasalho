package com.projetoAgasalho.entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ItemTest {

	private Item item;

	@BeforeEach
	void setUp() {
		// Arrange
		item = new Item(1L, "Blusa", "Blusa de moletom");
	}

	@Test
	@DisplayName("Testando o getter e setter do id")
	void testId() {
		// Act
		item.setId(2L);
		// Assert
		assertEquals(2L, item.getId());
	}
	
	@Test
	@DisplayName("Testando o getter e setter do nome")
	void testNome() {
		// Act
		item.setNome("Camiseta");
		// Assert
		assertEquals("Camiseta", item.getNome());
	}
	
	@Test
	@DisplayName("Testando o getter e setter da descricao")
	void testDescricao() {
		// Act
		item.setDescricao("Manga longa");
		// Assert
		assertEquals("Manga longa", item.getDescricao());
	}

	@Test
	@DisplayName("Testando o construtor com todos argumentos")
	void testConstrutorAll() {
		// Act
		Item novoItem = new Item(3L, "Cobertor", "Cobertor Infantil");
		// Assert
		assertAll("novoItem", () -> assertEquals(3L, novoItem.getId()),
				() -> assertEquals("Cobertor", novoItem.getNome()),
				() -> assertEquals("Cobertor Infantil", novoItem.getDescricao()));
	}

}
