package br.com.zupacademy.vitor.mercadolivre.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import br.com.zupacademy.vitor.mercadolivre.modelo.Categoria;
import br.com.zupacademy.vitor.mercadolivre.modelo.Produto;
import br.com.zupacademy.vitor.mercadolivre.repository.CategoriaRepository;

public class ProdutoForm {
	
	@NotBlank
	private String nome;
	@Positive
	private BigDecimal preco;
	@Positive
	private Long quantidade;
	@Size(min=3)
	@Valid
	private List<CaracteristicasForm> caracteristicas = new ArrayList<>();
	@NotBlank
	private String descricao;
	@Positive
	private Long idCategoria;
	
	public ProdutoForm() {
		
	}
	
	public ProdutoForm(@NotBlank String nome, @Positive BigDecimal preco, @Positive Long quantidade,
			@NotBlank String descricao, @Positive Long idCategoria,List<CaracteristicasForm> caracteristicas) {
		super();
		this.nome = nome;
		this.preco = preco;
		this.quantidade = quantidade;
		this.descricao = descricao;
		this.idCategoria = idCategoria;
		this.caracteristicas.addAll(caracteristicas);
	}
	
	public String getNome() {
		return nome;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public Long getQuantidade() {
		return quantidade;
	}

	public List<CaracteristicasForm> getCaracteristicas() {
		return caracteristicas;
	}

	public String getDescricao() {
		return descricao;
	}

	public Long getIdCategoria() {
		return idCategoria;
	}

	public Produto toModel(CategoriaRepository categoriaRepository) {
		Optional<Categoria> possivelCategoria = categoriaRepository.findById(idCategoria);
		if(possivelCategoria.isEmpty()) {
			throw new IllegalArgumentException("Id da categoria invalido");
		}
		return new Produto(nome, preco, quantidade, descricao, possivelCategoria.get(), caracteristicas);
	}

}
