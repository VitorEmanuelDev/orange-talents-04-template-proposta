package com.projeto_proposta.nova_proposta;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import com.projeto_proposta.validation.CPF_CNPJ_IsPresent;

@RestController
@RequestMapping("/propostas")
public class PropostaController {
	
	@Autowired
	private PropostaRepository repository;
	
	@Autowired
	private CPF_CNPJ_IsPresent cpf_cnpj_IsPresent;
	

	public PropostaController(CPF_CNPJ_IsPresent cpf_cnpj_IsPresent, PropostaRepository repository) {
		
		super();
		this.cpf_cnpj_IsPresent = cpf_cnpj_IsPresent;
		this.repository = repository;
		
	}
	
	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(cpf_cnpj_IsPresent);
	}

	
	@PostMapping
	@Transactional
	public ResponseEntity<PropostaResponse> createProposta(@RequestBody @Valid PropostaRequest request,
			UriComponentsBuilder uriComponentsBuilder) {
		
		Proposta proposta = request.toModel();
		repository.save(proposta);
		URI uri = uriComponentsBuilder.path("/propostas/{id}").build(proposta.getId());
		return ResponseEntity.created(uri).build();
	}

}
