package com.projeto_proposta.viagem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.projeto_proposta.bloqueio.BloqueioCartao;
import com.projeto_proposta.cartao.Cartao;
import com.projeto_proposta.cartao.CartaoRepository;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/viagem")
public class ViagemController {

    @Autowired
    private CartaoRepository cartaoRepository;

    @PostMapping("/{id}")
    public ResponseEntity<?> avisoViagem(@PathVariable("id") Long id, @Valid @RequestBody ViagemRequest request,
                                         HttpServletRequest servlet){
        Optional<Cartao> cartao = cartaoRepository.findById(id);
        if(cartao.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cartao nao consta");
        }
        if(cartao.get().getStatusCartao() == BloqueioCartao.BLOQUEADO){
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Cartao bloqueado");
        }
        cartao.get().adicionaViagem(request.toModel(servlet));
        cartaoRepository.save(cartao.get());
        return ResponseEntity.ok("Aviso da viagem cadastrado com sucesso!");
    }
}