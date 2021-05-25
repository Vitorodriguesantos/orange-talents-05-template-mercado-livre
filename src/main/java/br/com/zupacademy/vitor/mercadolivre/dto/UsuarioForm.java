package br.com.zupacademy.vitor.mercadolivre.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import br.com.zupacademy.vitor.mercadolivre.modelo.Usuario;
import br.com.zupacademy.vitor.mercadolivre.validacao.UnicoValor;

public class UsuarioForm {

	@Email
	@NotBlank
	@UnicoValor(aClasse = Usuario.class, oCampo = "login")
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
