package br.com.zupacademy.vitor.mercadolivre.validacao;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = {UnicoValorValidator.class})
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UnicoValor {
	
	String message() default "Tentativa de registro duplicados";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
	
	String oCampo();
	Class<?> aClasse();

}
