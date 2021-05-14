package com.projeto_proposta.cartao;

import java.util.*;

import javax.persistence.*;

import com.projeto_proposta.biometria.Biometria;
import com.projeto_proposta.proposta.Proposta;
import com.projeto_proposta.viagem.Viagem;


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
    private StatusCartao statusCartao;
    
    @OneToMany(cascade = CascadeType.MERGE)
    private Set<Viagem> viagem = new HashSet<>();

    
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

    public StatusCartao getStatusCartao() {
        return statusCartao;
    }

    public void adicionaBloqueio(){
        this.statusCartao = StatusCartao.BLOQUEADO;
    }
    
    public void adicionaViagem(Viagem viagem){
        this.viagem.add(viagem);
    }
    
    public Set<Viagem> getViagem() {
        return viagem;
    }
    
    
}
