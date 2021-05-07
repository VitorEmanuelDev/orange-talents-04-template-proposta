package com.projeto_proposta.nova_proposta;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/proposta")
public class PropostaController {
	
	@Autowired
	private PropostaRepository repository;
	
	@PostMapping
	@Transactional
	public ResponseEntity<PropostaResponse> salvarProposta(@RequestBody @Valid PropostaRequest request,
			UriComponentsBuilder uriComponentsBuilder) {
		Proposta proposta = request.toModel();
		repository.save(proposta);
		URI uri = uriComponentsBuilder.path("/propostas/{id}").build(proposta.getId());
		return ResponseEntity.created(uri).build();
	}

}
