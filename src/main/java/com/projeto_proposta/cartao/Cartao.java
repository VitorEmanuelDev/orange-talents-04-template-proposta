package com.projeto_proposta.cartao;

import java.util.List;

import javax.persistence.*;

import com.projeto_proposta.biometria.Biometria;
import com.projeto_proposta.bloqueio.Bloqueio;
import com.projeto_proposta.bloqueio.BloqueioCartao;
import com.projeto_proposta.proposta.Proposta;


@Entity
public class Cartao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numero;

    @OneToOne(mappedBy = "cartao")
    private Proposta proposta;
    
    @OneToMany(mappedBy = "cartao")
    private List<Biometria> biometrias;
    
    @Enumerated(EnumType.STRING)
    private BloqueioCartao statusCartao;

    
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

    public BloqueioCartao getStatusCartao() {
        return statusCartao;
    }

    public void adicionaBloqueio(){
        this.statusCartao = BloqueioCartao.BLOQUEADO;
    }
    
    
}
