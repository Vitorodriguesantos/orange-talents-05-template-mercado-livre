package br.com.zupacademy.vitor.mercadolivre.controller;

import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.zupacademy.vitor.mercadolivre.dto.ImagensForm;
import br.com.zupacademy.vitor.mercadolivre.modelo.Produto;
import br.com.zupacademy.vitor.mercadolivre.modelo.Usuario;
import br.com.zupacademy.vitor.mercadolivre.repository.ProdutoRepository;
import br.com.zupacademy.vitor.mercadolivre.repository.UsuarioRepository;

@RestController
@RequestMapping("/imagens")
public class ImagemController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired 
	private ProdutoRepository produtoRepository;
	
	@PostMapping
	@Transactional
	public String novaImagem(@RequestBody @Valid ImagensForm form) {
		
		Optional<Usuario> dono = usuarioRepository.findByLogin("teste@teste.com");
		Optional<Produto> produto = produtoRepository.findById(form.getIdProduto());
		if(!produto.get().gepertenceAoUsuario(dono)) {
			throw new ResponseStatusException(HttpStatus.FORBIDDEN);
		}
		
		produto.get().associaImagens(form.getBase64());
		produtoRepository.save(produto.get());
		return produto.toString();
	}

}
