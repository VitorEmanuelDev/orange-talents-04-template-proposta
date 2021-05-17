package com.projeto_proposta.carteira;

import javax.persistence.*;
import javax.validation.constraints.*;

import com.projeto_proposta.cartao.Cartao;

@Entity
public class Carteira {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    private String email;

    @ManyToOne
    private Cartao cartao;

    @Enumerated(EnumType.STRING)
    private IdCarteira idCarteira;

    private String assossiacaoId;

    @Deprecated
    public Carteira() {
    }


    public Carteira(String email, Cartao cartao, String id, IdCarteira idCarteira) {
        this.email = email;
        this.cartao = cartao;
        this.idCarteira = idCarteira;
        this.assossiacaoId = id;
    }


    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public IdCarteira getIdCarteira() {
        return idCarteira;
    }

    public String getAssossiacaoId() {
        return assossiacaoId;
    }
}