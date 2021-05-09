package com.projeto_proposta.biometria;

import javax.persistence.*;
import javax.validation.constraints.*;

import com.projeto_proposta.cartao.Cartao;

import java.time.LocalDateTime;

@Entity
public class Biometria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    private Cartao cartao;

    private LocalDateTime dataCadastroBiometria;

    @NotNull
    private byte[] impressaoDigital;

    public Biometria(Long id, Cartao cartao, LocalDateTime dataCadastroBiometria, byte[] impressaoDigital) {
        this.id = id;
        this.cartao = cartao;
        this.dataCadastroBiometria = LocalDateTime.now();
        this.impressaoDigital = impressaoDigital;
    }

    public Biometria(Cartao cartao, byte[] impressaoDigital) {
        this.cartao = cartao;
        this.impressaoDigital = impressaoDigital;
        this.dataCadastroBiometria = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public LocalDateTime getDataCadastroBiometria() {
        return dataCadastroBiometria;
    }

    public byte[] getImpressaoDigital() {
        return impressaoDigital;
    }
}