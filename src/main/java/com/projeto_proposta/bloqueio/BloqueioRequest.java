package com.projeto_proposta.bloqueio;


import javax.validation.constraints.NotNull;

import com.projeto_proposta.cartao.Cartao;


public class BloqueioRequest {

	 @NotNull
	 private String sistemaResponsavel;

	 @Deprecated
	 public BloqueioRequest() {
	 
	 }

	 public BloqueioRequest(String sistemaResponsavel) {
	        this.sistemaResponsavel = sistemaResponsavel;
	 }
	 
	 public BloqueioRequest(BloqueioRequest request) {
	        this.sistemaResponsavel = request.getSistemaResponsavel();
	 }
	 
	 public String getSistemaResponsavel() {
	        return sistemaResponsavel;
	 }

	 public Bloqueio toModel(Cartao cartao, String ip, String userAgent) {
	        return new Bloqueio(cartao, ip, userAgent);
	  }
}