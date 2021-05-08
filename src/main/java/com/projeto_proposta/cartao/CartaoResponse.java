package com.projeto_proposta.cartao;

public class CartaoResponse {
	
	private String documento;

	private String nome;

	private String idProposta;

	private String resultado;

	public CartaoResponse(String cpfCnpj, String nome, String idProposta, String restricao) {
		super();
		this.documento = cpfCnpj;
		this.nome = nome;
		this.idProposta = idProposta;
		this.resultado = restricao;
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


	public String getResultado() {
		return resultado;
	}


	@Override
	public String toString() {
		return "CartaoResponse [documento=" + documento + ", nome=" + nome + ", idProposta=" + idProposta
				+ ", restricao=" + resultado + "]";
	}



}
