package com.projeto_proposta.bloqueio;


import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import com.projeto_proposta.cartao.Cartao;
import com.projeto_proposta.cartao.CartaoRepository;
import com.projeto_proposta.cartao.StatusCartao;
import com.projeto_proposta.feign.Cartoes;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RequestMapping("/bloqueio")
@RestController
public class BloqueioController {
    @Autowired
    private CartaoRepository cartaoRepository;

    @Autowired
    private BloqueioRepository bloqueioRepository;

    @Autowired
    private Cartoes cartoes;

    @PostMapping("/{id}")
    @Transactional
    public ResponseEntity<?> bloquearCartao(@PathVariable("id")Long id, HttpServletRequest httpRequest,
                                            @RequestBody @Valid BloqueioRequest bloqueioRequest, UriComponentsBuilder uriComponentsBuilder){
        Optional<Cartao> cartao = cartaoRepository.findById(id);
        if(cartao.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        if(cartao.get().getStatusCartao() == StatusCartao.BLOQUEADO){
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY,"Cartao bloqueado");
        }
        return solicitarBloqueio(cartao.get(), bloqueioRequest,httpRequest,uriComponentsBuilder);
    }

    public ResponseEntity<?> solicitarBloqueio(Cartao cartao, @RequestBody @Valid BloqueioRequest request, HttpServletRequest httpRequest, UriComponentsBuilder uriComponentsBuilder) {
        try {
            Bloqueio bloqueio = new Bloqueio(cartao, httpRequest.getLocalAddr(), httpRequest.getHeader("User-Agent"));
            bloqueio.bloquearCartao(cartao);
            bloqueio = bloqueioRepository.save(bloqueio);
            cartoes.bloqueioCartao(cartao.getNumero(), new BloqueioRequest(request));
            URI uri = uriComponentsBuilder.path("/bloqueio/{id}").build(bloqueio.getId());
            return ResponseEntity.created(uri).build();
        } catch (FeignException.UnprocessableEntity e) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY,"Não foi possível bloquear.");
        }
    }
}
