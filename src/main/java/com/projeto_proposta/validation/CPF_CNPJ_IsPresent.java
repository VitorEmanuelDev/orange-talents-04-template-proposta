package com.projeto_proposta.validation;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.server.ResponseStatusException;

import com.projeto_proposta.nova_proposta.Proposta;
import com.projeto_proposta.nova_proposta.PropostaRepository;
import com.projeto_proposta.nova_proposta.PropostaRequest;



@Component
public class CPF_CNPJ_IsPresent implements Validator{

	@Autowired
	private PropostaRepository repository;

	@Override
	public boolean supports(Class<?> clazz) {
		return PropostaRequest.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(errors.hasErrors()) {
			return;
		}

		PropostaRequest request = (PropostaRequest) target;

		Optional<Proposta> proposta = repository.findByDocumento(request.getDocumento());

		if(proposta.isPresent()) {
			throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "CPF OU CNPJ não podem ser repetidos.");
		}

	}

}
