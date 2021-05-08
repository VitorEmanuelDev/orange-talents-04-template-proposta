package com.projeto_proposta.cartao;

import javax.persistence.*;

import com.projeto_proposta.proposta.Proposta;


@Entity
public class Cartao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numero;

    @OneToOne(mappedBy = "cartao")
    private Proposta proposta;
    
    @Deprecated
    public Cartao() {
    }

    public Cartao(Proposta proposta) {
        this.proposta = proposta;
    }


    public Cartao(String id, Proposta proposta) {
        this.numero = id;
        this.proposta = proposta;
    }

    public Long getId() {
        return id;
    }

    public String getNumero() {
        return numero;
    }

    public Proposta getProposta() {
        return proposta;
    }
    
    
}
