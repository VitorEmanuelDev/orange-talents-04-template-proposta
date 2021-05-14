package com.projeto_proposta.viagem;

import javax.persistence.*;
import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Entity
public class Viagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    private String destinoViagem;

    @Future
    private LocalDate terminoViagem;

    @NotNull
    private LocalDate instanteAvisoViagem;


    @NotNull
    @NotBlank
    private String ipCliente;

    @NotNull
    @NotBlank
    private String userAgente;

    @Deprecated
    public Viagem() {
    }

    public Viagem(HttpServletRequest servlet, String destinoViagem, LocalDate terminoViagem) {
    	
        this.destinoViagem = destinoViagem;
        this.terminoViagem = terminoViagem;
        this.instanteAvisoViagem = LocalDate.now();
        this.ipCliente = servlet.getRemoteAddr();
        this.userAgente = servlet.getHeader("User-Agent");
       
    }


    public String getDestinoViagem() {
        return destinoViagem;
    }

    public LocalDate getTerminoViagem() {
        return terminoViagem;
    }

    public LocalDate getInstanteAvisoViagem() {
        return instanteAvisoViagem;
    }


    public String getIpCliente() {
        return ipCliente;
    }

    public String getUserAgente() {
        return userAgente;
    }

}