package br.com.zupacademy.vitor.mercadolivre.controller;

import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.vitor.mercadolivre.dto.ProdutoForm;
import br.com.zupacademy.vitor.mercadolivre.modelo.Produto;
import br.com.zupacademy.vitor.mercadolivre.modelo.Usuario;
import br.com.zupacademy.vitor.mercadolivre.repository.CategoriaRepository;
import br.com.zupacademy.vitor.mercadolivre.repository.ProdutoRepository;
import br.com.zupacademy.vitor.mercadolivre.repository.UsuarioRepository;
import br.com.zupacademy.vitor.mercadolivre.validacao.ProibeCaracteristicaComNomeIgualValidator;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@InitBinder
	public void init(WebDataBinder webDataBinder) {
		webDataBinder.addValidators(new ProibeCaracteristicaComNomeIgualValidator());
	}
	
	@PostMapping
	@Transactional
	public String novoProduto(@RequestBody @Valid ProdutoForm form) {
		Optional<Usuario> dono = usuarioRepository.findByLogin("teste@teste.com");
		if(dono.isEmpty()) {
			throw new IllegalArgumentException("Usuario nao cadastrado");
		}
		Produto novoProduto = form.converter(categoriaRepository,dono.get());
		produtoRepository.save(novoProduto);
		return novoProduto.toString();
	}
}
