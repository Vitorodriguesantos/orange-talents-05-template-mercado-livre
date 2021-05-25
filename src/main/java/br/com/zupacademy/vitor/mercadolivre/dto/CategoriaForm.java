package br.com.zupacademy.vitor.mercadolivre.dto;

import java.util.Optional;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import br.com.zupacademy.vitor.mercadolivre.modelo.Categoria;
import br.com.zupacademy.vitor.mercadolivre.repository.CategoriaRepository;
import br.com.zupacademy.vitor.mercadolivre.validacao.UnicoValor;

public class CategoriaForm {
	
	@NotBlank
	@UnicoValor(aClasse = Categoria.class, oCampo = "nome")
	private String nome;
	@Positive
	private Long idCategoriaMae;
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setCategoriaMae(Long categoriaMae) {
		this.idCategoriaMae = categoriaMae;
	}
	
	public Categoria converter(CategoriaRepository categoriaRepository) {
		Categoria categoria = new Categoria(nome);
		
		Optional<Categoria> categoriaMae = categoriaRepository.findByCategoriaMae(idCategoriaMae);
		
		if(categoriaMae.isPresent()) {
			categoria.setCategoriaMae(categoriaMae.get());
		}
		
		return categoria;
		
	}
	
	
}
