package br.com.zupacademy.vitor.mercadolivre.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.vitor.mercadolivre.dto.ProdutoForm;
import br.com.zupacademy.vitor.mercadolivre.modelo.Produto;
import br.com.zupacademy.vitor.mercadolivre.repository.CategoriaRepository;
import br.com.zupacademy.vitor.mercadolivre.repository.ProdutoRepository;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@PostMapping
	@Transactional
	public String novoProduto(@RequestBody @Valid ProdutoForm form) {
		Produto novoProduto = form.toModel(categoriaRepository);
		produtoRepository.save(novoProduto);
		return novoProduto.toString();
	}
}
