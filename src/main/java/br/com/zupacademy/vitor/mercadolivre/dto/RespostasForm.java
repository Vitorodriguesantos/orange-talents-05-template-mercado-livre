package br.com.zupacademy.vitor.mercadolivre.dto;

import java.util.Optional;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import br.com.zupacademy.vitor.mercadolivre.modelo.Produto;
import br.com.zupacademy.vitor.mercadolivre.modelo.Respostas;
import br.com.zupacademy.vitor.mercadolivre.modelo.Usuario;
import br.com.zupacademy.vitor.mercadolivre.repository.ProdutoRepository;

public class RespostasForm {
	
	@Min(value = 1)
	@Max(value = 5)
	private Integer nota;
	@NotBlank
	private String titulo;
	@NotBlank
	@Size(max = 500)
	private String descricao;
	@Positive
	private Long idProduto;
	
	public RespostasForm(@Min(1) @Max(5) Integer nota, @NotBlank String titulo, @NotBlank String descricao,
				@Positive Long idProduto) {
		super();
		this.nota = nota;
		this.titulo = titulo;
		this.descricao = descricao;
		this.idProduto = idProduto;
	}
	
	public Integer getNota() {
		return nota;
	}
	public String getTitulo() {
		return titulo;
	}
	public String getDescricao() {
		return descricao;
	}

	public Long getIdProduto() {
		return idProduto;
	}

	public Respostas converter(ProdutoRepository produtoRepository, Usuario usuarioLogado) {
		Optional<Produto> oProduto = produtoRepository.findById(idProduto);
		if(oProduto.isEmpty()) {
			throw new IllegalArgumentException("Produto invalido");
		}
		
		return new Respostas(nota, titulo, descricao, usuarioLogado, oProduto.get());
	}

}
