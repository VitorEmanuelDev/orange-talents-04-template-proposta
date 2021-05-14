package com.projeto_proposta.viagem;

import com.projeto_proposta.cartao.Cartao;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.*;
import java.time.LocalDate;

public class ViagemRequest {


    @NotNull
    @NotBlank
    private String destinoViagem;

    @Future
    private LocalDate terminoViagem;

    public ViagemRequest(Cartao cartao, String destinoViagem, LocalDate terminoViagem) {
        this.destinoViagem = destinoViagem;
        this.terminoViagem = terminoViagem;
    }


    public String getDestinoViagem() {
        return destinoViagem;
    }

    public LocalDate getTerminoViagem() {
        return terminoViagem;
    }

    public Viagem toModel(HttpServletRequest servlet) {
        return new Viagem(servlet, destinoViagem, terminoViagem);
    }
}