package com.projeto_proposta.cartao;

public class CartaoRequest {
	

	private String documento;

	private String nome;

	private String idProposta;

	public CartaoRequest(String documento, String nome, String idProposta) {
		
		super();
		this.documento = documento;
		this.nome = nome;
		this.idProposta = idProposta;
	}

	public String getDocumento() {
		return documento;
	}

	public String getNome() {
		return nome;
	}

	public String getIdProposta() {
		return idProposta;
	}

}
