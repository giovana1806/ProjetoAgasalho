package com.projetoAgasalho.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Ponto")
public class Ponto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name = "pontoColeta", nullable = false, length = 255)
	private String pontoColeta;

	@ManyToOne
	@JoinColumn(name = "item", nullable = false)
	private Item item;

	public Ponto(Long id, String pontoColeta) {
		
		this.id = id;
		this.pontoColeta = pontoColeta;
		
	}


}
