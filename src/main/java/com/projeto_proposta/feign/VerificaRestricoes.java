package com.projeto_proposta.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import com.projeto_proposta.cartao.CartaoRequest;
import com.projeto_proposta.cartao.CartaoResponse;


@FeignClient(url = "${analises.host}", name = "analise")
public interface VerificaRestricoes {

	@PostMapping
	public CartaoResponse verificaRestricao(CartaoRequest request);
	
}
