package com.projeto_proposta.viagem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.projeto_proposta.cartao.Cartao;
import com.projeto_proposta.cartao.CartaoRepository;
import com.projeto_proposta.cartao.StatusCartao;
import com.projeto_proposta.feign.Cartoes;

import feign.FeignException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/viagem")
public class ViagemController {

    @Autowired
    private CartaoRepository cartaoRepository;
    
    @Autowired
    private Cartoes cartoes;
    @PostMapping("/{id}")
    public ResponseEntity<AvisoViagemResponse> avisoViagem(@PathVariable("id") Long id, @Valid @RequestBody ViagemRequest request,
                                         HttpServletRequest servlet){
        Optional<Cartao> cartao = cartaoRepository.findById(id);
        if(cartao.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cartao nao existe");
        }
        if(cartao.get().getStatusCartao() == StatusCartao.BLOQUEADO){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cartao bloqueado");
        }
        if(cartao.get().getStatusCartao() == StatusCartao.VIAJANDO){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Status(ERRO): viajando");
        }
        try{
            AvisoViagemResponse aviso = cartoes.avisoViagem(cartao.get().getNumero(),request);
            cartao.get().adicionaViagem(request.toModel(servlet));
            cartaoRepository.save(cartao.get());
            return ResponseEntity.ok(aviso);
        }catch (FeignException.UnprocessableEntity e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Nao armazenado!");
        }

    }
}