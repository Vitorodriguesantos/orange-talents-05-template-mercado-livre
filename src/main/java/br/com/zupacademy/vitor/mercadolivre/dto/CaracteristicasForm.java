package br.com.zupacademy.vitor.mercadolivre.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.vitor.mercadolivre.modelo.Caracteristicas;
import br.com.zupacademy.vitor.mercadolivre.modelo.Produto;

public class CaracteristicasForm {
	
	@NotBlank
	private String nome;
	@NotBlank
	private String descricao;
	
	public CaracteristicasForm() {
		
	}
	
	public CaracteristicasForm(@NotBlank String nome, @NotBlank String descricao) {
		super();
		this.nome = nome;
		this.descricao = descricao;
	}

	public Caracteristicas converter(@NotNull @Valid Produto produto) {
		return new Caracteristicas(nome, descricao, produto);
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}
	
	
	
}
