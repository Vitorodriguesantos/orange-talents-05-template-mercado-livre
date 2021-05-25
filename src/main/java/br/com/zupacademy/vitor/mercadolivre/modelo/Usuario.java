package br.com.zupacademy.vitor.mercadolivre.modelo;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Email
	private String login;
	@NotNull
	@Size(min = 6)
	private String senha;
	private LocalDateTime dataCriacao = LocalDateTime.now();
	
	public Usuario() {
		
	}

	public Usuario(@Email String login, @NotNull @Size(min = 6) String senha) {
		super();
		this.login = login;
		this.senha = new BCryptPasswordEncoder().encode(senha);
	}
	
	@Override
	public String toString() {
		return "{id:"+id+", login:"+login+", senha:"+senha+", dataCriacao:"+dataCriacao+"}";
	}
	
}
