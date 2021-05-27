package br.com.zupacademy.vitor.mercadolivre.seguraca;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import br.com.zupacademy.vitor.mercadolivre.modelo.Usuario;
import br.com.zupacademy.vitor.mercadolivre.repository.UsuarioRepository;

@Component
public class ServicoAutenticacao implements UserDetailsService{
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Usuario> possivelUsuario = usuarioRepository.findByLogin(username);
		if(possivelUsuario.isPresent()) {
			return possivelUsuario.get();

		}
		throw new UsernameNotFoundException("Dados inválidos");
	}

}
