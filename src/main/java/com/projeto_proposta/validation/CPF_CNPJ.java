package com.projeto_proposta.validation;

import java.lang.annotation.*;

import javax.validation.*;

import org.hibernate.validator.constraints.*;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

@CPF
@CNPJ
@ConstraintComposition(CompositionType.OR) //https://docs.jboss.org/hibernate/validator/4.2/api/org/hibernate/validator/constraints/ConstraintComposition.html
@ReportAsSingleViolation //https://docs.oracle.com/javaee/7/api/javax/validation/ReportAsSingleViolation.html
@Documented //https://docs.oracle.com/javase/7/docs/api/java/lang/annotation/Documented.html
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CPF_CNPJ {
	
	String message() default "CPF ou CNPJ inválido.";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

}