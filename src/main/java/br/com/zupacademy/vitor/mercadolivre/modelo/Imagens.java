package br.com.zupacademy.vitor.mercadolivre.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Imagens {

	@Id
	@GeneratedValue
	private Long id;
	@NotBlank
	private String base64;
	@ManyToOne
	@Valid
	@NotNull
	private Produto produto;
	
	public Imagens() {
		
	}
	
	public Imagens(@NotBlank String base64, Produto produto) {
		super();
		this.base64 = base64;
		this.produto = produto;
	}
	
	@Override
	public String toString() {
		return "{ id:"+id+", base64:"+base64+"}";
	}
	
}
