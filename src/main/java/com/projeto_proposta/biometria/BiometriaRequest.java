package com.projeto_proposta.biometria;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.projeto_proposta.cartao.Cartao;

import java.util.Base64;
import java.util.Optional;

public class BiometriaRequest {

    @NotNull
    @NotBlank
    private String impressaoDigital;

    public Biometria toModel(Optional<Cartao> cartao) {
        byte[] biometria64 = Base64.getEncoder().encode(impressaoDigital.getBytes());
        return new Biometria(cartao.get(), biometria64);
    }

    public String getImpressaoDigital() {
        return impressaoDigital;
    }
}