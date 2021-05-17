package com.projeto_proposta.carteira;


import com.projeto_proposta.cartao.Cartao;

public class CarteiraRequest {

    private String email;
    private IdCarteira idCarteira;

    @Deprecated
    public CarteiraRequest() {
    }

    public CarteiraRequest(String email, IdCarteira idCarteira) {
        this.email = email;
        this.idCarteira = idCarteira;
    }

    public String getEmail() {
        return email;
    }

    public IdCarteira getIdCarteira() {
        return idCarteira;
    }

    public Carteira toModel(Cartao cartao, String id) {
        return new Carteira(email, cartao, id, idCarteira);
    }
}