package com.projeto_proposta.bloqueio;



public class BloqueioResponse {

    private String status;

    public BloqueioResponse(String status) {
        this.status = status;
    }

    @Deprecated
    public BloqueioResponse() {
    }

    public String getStatus() {
        return status;
    }
}