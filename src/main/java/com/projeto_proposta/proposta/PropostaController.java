package com.projeto_proposta.proposta;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import com.projeto_proposta.cartao.CartaoRequest;
import com.projeto_proposta.cartao.RestricaoCartao;
import com.projeto_proposta.feign.VerificaRestricoes;
import com.projeto_proposta.validation.CpfOuCnpjIsPresent;

import feign.FeignException;

@RestController
@RequestMapping("/propostas")
public class PropostaController {
	
	@Autowired
	private PropostaRepository repository;
	
	@Autowired
	private CpfOuCnpjIsPresent cpfOuCnpjIsPresent;
	
	@Autowired
	private VerificaRestricoes verificaRestricoes;	

	public PropostaController(CpfOuCnpjIsPresent cpf_cnpj_IsPresent, PropostaRepository repository, VerificaRestricoes verificaRestricoes) {
		
		super();
		this.cpfOuCnpjIsPresent = cpf_cnpj_IsPresent;
		this.repository = repository;
		this.verificaRestricoes = verificaRestricoes;
		
	}
	
	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(cpfOuCnpjIsPresent);
	}

	
	@PostMapping
	@Transactional
	public ResponseEntity<PropostaResponse> createProposta(@RequestBody @Valid PropostaRequest request,
			UriComponentsBuilder uriComponentsBuilder) {
		
		Proposta proposta = request.toModel();
		repository.save(proposta);
		verificaRestricao(proposta);
		URI uri = uriComponentsBuilder.path("/propostas/{id}").build(proposta.getId());
		return ResponseEntity.created(uri).build();
	}

	private void verificaRestricao(Proposta proposta) {
		
		try {
			CartaoRequest cartaoRequest = proposta.toModelCartao();
			verificaRestricoes.verificaRestricao(cartaoRequest);
			proposta.adicionaRestricao(RestricaoCartao.ELEGIVEL);
			repository.save(proposta);
		}catch (FeignException.UnprocessableEntity e) {
			proposta.adicionaRestricao(RestricaoCartao.NAO_ELEGIVEL);		
			repository.save(proposta);
		}
		
	}

}
