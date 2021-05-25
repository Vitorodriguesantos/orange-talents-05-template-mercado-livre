package br.com.zupacademy.vitor.mercadolivre.validacao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.Assert;

public class UnicoValorValidator implements ConstraintValidator<UnicoValor, Object>{

	private String campo;
	private Class<?> classe;
	@PersistenceContext
	private EntityManager entidade;
	
	public void initialize(UnicoValor parametros) {
		campo = parametros.oCampo();
		classe = parametros.aClasse();
	}
	
	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {

		Query query = entidade.createQuery("Select 1 from "+ classe.getName() +" where "+ campo +" =:valor");
		query.setParameter("valor", value);
		List<?> lista = query.getResultList();
		Assert.state(lista.size() <= 1, "Foi encontrado mais de um "+classe+" com o atributo "+campo+" = "+value);
		return lista.isEmpty();
	}

}
