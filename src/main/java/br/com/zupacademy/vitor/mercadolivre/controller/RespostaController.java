package br.com.zupacademy.vitor.mercadolivre.controller;

import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.vitor.mercadolivre.dto.RespostasForm;
import br.com.zupacademy.vitor.mercadolivre.modelo.Respostas;
import br.com.zupacademy.vitor.mercadolivre.modelo.Usuario;
import br.com.zupacademy.vitor.mercadolivre.repository.ProdutoRepository;
import br.com.zupacademy.vitor.mercadolivre.repository.RespostaRepository;
import br.com.zupacademy.vitor.mercadolivre.repository.UsuarioRepository;

@RestController
@RequestMapping("/respostas")
public class RespostaController {
	
	@Autowired
	private RespostaRepository respostaRepository;
	
	@Autowired 
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@PostMapping
	@Transactional
	public String novaResposta(@RequestBody @Valid RespostasForm form) {
		Optional<Usuario> userLogado = usuarioRepository.findByLogin("teste@teste.com");
		Respostas aResposta = form.converter(produtoRepository, userLogado.get());
		respostaRepository.save(aResposta);
		return aResposta.toString();
	}

}
