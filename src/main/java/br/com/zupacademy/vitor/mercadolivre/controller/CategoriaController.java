package br.com.zupacademy.vitor.mercadolivre.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.vitor.mercadolivre.dto.CategoriaForm;
import br.com.zupacademy.vitor.mercadolivre.modelo.Categoria;
import br.com.zupacademy.vitor.mercadolivre.repository.CategoriaRepository;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	@PostMapping
	@Transactional
	public String novaCategoria(@RequestBody @Valid CategoriaForm form) {
		Categoria categoria = form.converter(categoriaRepository);
		categoriaRepository.save(categoria);
		
		return categoria.toString();
	}
}
