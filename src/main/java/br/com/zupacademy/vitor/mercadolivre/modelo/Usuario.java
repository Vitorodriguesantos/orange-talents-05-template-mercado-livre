package br.com.zupacademy.vitor.mercadolivre.modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
public class Usuario implements UserDetails{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Email
	private String login;
	@NotNull
	@Size(min = 6)
	private String senha;
	private LocalDateTime dataCriacao = LocalDateTime.now();
	
	@ManyToMany(fetch = FetchType.EAGER)
	private List<Perfil> perfis = new ArrayList<>();
	
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

	public Long getId() {
		return id;
	}


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.perfis;
	}

	@Override
	public String getPassword() {
		return this.senha;
	}

	@Override
	public String getUsername() {
		return this.login;
	}
	
	public List<Perfil> getPerfis() {
		return this.perfis;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
}
