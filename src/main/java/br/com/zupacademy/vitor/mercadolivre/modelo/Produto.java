package br.com.zupacademy.vitor.mercadolivre.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.Size;

import br.com.zupacademy.vitor.mercadolivre.dto.CaracteristicasForm;

@Entity
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private BigDecimal preco;
	private Long quantidade;
	@Size(min=3)
	@Valid
	@OneToMany(mappedBy = "produto",cascade = CascadeType.PERSIST)
	private Set<Caracteristicas> caracteristicas = new HashSet<>();
	private String descricao;
	@OneToMany(mappedBy = "produto", cascade = CascadeType.MERGE)
	private List<Imagens> imagens;
	@ManyToOne
	private Usuario dono;
	@ManyToOne
	private Categoria categoria;
	private LocalDateTime dataCriacao = LocalDateTime.now();
	
	public Produto() {
		
	}
	
	public Produto(String nome, BigDecimal preco, Long quantidade, String descricao, Categoria categoria,
			Collection<CaracteristicasForm> caracteristicas, Usuario usuario) {
		super();
		this.nome = nome;
		this.preco = preco;
		this.quantidade = quantidade;
		Set<Caracteristicas> novasCaracteristicas = caracteristicas.stream().
				map(caracteristica -> caracteristica.converter(this)).collect(Collectors.toSet());
		this.caracteristicas.addAll(novasCaracteristicas);
		this.descricao = descricao;
		this.categoria = categoria;
		this.dono = usuario;
	}
	
	public void setImagens(List<Imagens> imagens) {
		this.imagens = imagens;
	}

	@Override
	public String toString() {
		return "{ id:"+id+", nome:"+nome+", preco:"+preco+", quantidade:"+quantidade+", descricao: "+descricao
				+", categoria:"+categoria+", caracteristicas:"+caracteristicas.toString()+", dataCriacao:"+dataCriacao
				+", dono:"+dono+", iamgens:"+imagens+"}";
	}

	public Usuario getDono() {
		return dono;
	}

	public void associaImagens(List<String> base64) {
		Set<Imagens> imagensFim = base64.stream().map(bases64 -> new Imagens(bases64,this)).collect(Collectors.toSet()); 
		this.imagens.addAll(imagensFim);
	}

	public boolean gepertenceAoUsuario(Optional<Usuario> possivelDono) {
		return this.dono.equals(possivelDono.get());
	}
	
	
	
	
}
