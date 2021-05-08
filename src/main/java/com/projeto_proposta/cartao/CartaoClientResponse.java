package com.projeto_proposta.cartao;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import com.projeto_proposta.proposta.Proposta;
import com.sun.istack.NotNull;

public class CartaoClientResponse {


    @NotBlank
    private String id;

    @NotNull
    @Positive
    private Long idProposta;


    public CartaoClientResponse(String id, Long idProposta) {
        this.id = id;
        this.idProposta = idProposta;
    }

    public String getId() {
        return id;
    }

    public Long getIdProposta() {
        return idProposta;
    }

    public Cartao toModel(Proposta proposta) {
        return new Cartao(id, proposta);
    }


}