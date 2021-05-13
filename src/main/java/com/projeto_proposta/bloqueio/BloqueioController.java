package com.projeto_proposta.bloqueio;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import com.projeto_proposta.cartao.Cartao;
import com.projeto_proposta.cartao.CartaoRepository;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.util.Optional;

@RequestMapping("bloqueio")
@RestController
public class BloqueioController {
    @Autowired
    private CartaoRepository cartaoRepository;

    @Autowired
    private BloqueioRepository bloqueioRepository;

    @PostMapping("/{id}")
    public ResponseEntity<?> bloquearCartao(@PathVariable("id")Long id,HttpServletRequest request,
                                            BloqueioRequest bloqueioRequest, UriComponentsBuilder uriComponentsBuilder){
        Optional<Cartao> cartao = cartaoRepository.findById(id);
        if(cartao.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        if(cartao.get().getBloqueio() != null){
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY,"Cartao bloqueado!");
        }
        Bloqueio bloqueio = bloqueioRequest.toModel(cartao,request);
        bloqueioRepository.save(bloqueio);
        URI uri = uriComponentsBuilder.path("/bloqueio/{id}").build(bloqueio.getId());
        return ResponseEntity.created(uri).build();
    }
}