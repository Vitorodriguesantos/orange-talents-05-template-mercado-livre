package br.com.zupacademy.vitor.mercadolivre.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Respostas {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Min(value = 1)
	@Max(value = 5)
	private Integer nota;
	@NotBlank
	private String titulo;
	@NotBlank
	private String descricao;
	@ManyToOne
	@NotNull
	private Usuario usuario;
	@ManyToOne
	@NotNull
	private Produto produto;
	
	public Respostas(@Min(1) @Max(5) Integer nota, @NotBlank String titulo, @NotBlank String descricao, Usuario usuario,
			Produto produto) {
		super();
		this.nota = nota;
		this.titulo = titulo;
		this.descricao = descricao;
		this.usuario = usuario;
		this.produto = produto;
	}
	
	@Override
	public String toString() {
		return "{id:"+id+", titulo:"+titulo+", nota:"+nota+", descricao:"+descricao+", usuario:"+usuario+", produto:"+produto+"}";
	}
	
	
}
