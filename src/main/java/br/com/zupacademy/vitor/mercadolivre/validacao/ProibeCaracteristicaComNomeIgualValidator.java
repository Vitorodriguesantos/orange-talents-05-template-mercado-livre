package br.com.zupacademy.vitor.mercadolivre.validacao;

import java.util.Set;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zupacademy.vitor.mercadolivre.dto.ProdutoForm;

public class ProibeCaracteristicaComNomeIgualValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		
		return ProdutoForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		if(errors.hasErrors()) {
			return ;
		}

		ProdutoForm request = (ProdutoForm) target;
		Set<String> nomesIguais = request.buscaCaracteristicasIguais();
		if(!nomesIguais.isEmpty()) {
			errors.rejectValue("caracteristicas", null, "Olha, você tem caracteristicas iguais "+nomesIguais);
		}
		
	}

}
