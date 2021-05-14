package com.projeto_proposta.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.projeto_proposta.bloqueio.BloqueioRequest;
import com.projeto_proposta.bloqueio.BloqueioResponse;
import com.projeto_proposta.cartao.CartaoClientResponse;
import com.projeto_proposta.viagem.AvisoViagemResponse;
import com.projeto_proposta.viagem.ViagemRequest;

@FeignClient(url = "${cartoes.host}", name = "cartoes")
public interface Cartoes {

    @GetMapping
    public CartaoClientResponse cartaoParaProposta(@RequestParam(name = "idProposta") String idProposta);
    
    @PostMapping("/{id}/bloqueios")
    public BloqueioResponse bloqueioCartao(@PathVariable(name = "id") String id, @RequestBody BloqueioRequest request);
    
    @PostMapping("/{id}/avisos")
    public AvisoViagemResponse avisoViagem(@PathVariable(name = "id") String id, @RequestBody ViagemRequest request);
    
}