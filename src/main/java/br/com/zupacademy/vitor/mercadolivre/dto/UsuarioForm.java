package br.com.zupacademy.vitor.mercadolivre.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UsuarioForm {

	@Email
	@NotBlank
	private String login;
	@NotBlank
	@Size(min = 6)
	private String senha;
	
	public String getLogin() {
		return login;
	}
	public String getSenha() {
		return senha;
	}
	
	
}
