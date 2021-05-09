package com.projeto_proposta.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.projeto_proposta.cartao.CartaoClientResponse;

@FeignClient(url = "${cartoes.host}", name = "cartoes")
public interface Cartoes {

    @GetMapping
    public CartaoClientResponse cartaoParaProposta(@RequestParam(name = "idProposta") String idProposta);
    
}