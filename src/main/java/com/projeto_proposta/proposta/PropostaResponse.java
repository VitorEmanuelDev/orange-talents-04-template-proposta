package com.projeto_proposta.proposta;

import java.math.BigDecimal;
import java.util.Optional;


public class PropostaResponse {

	private Long id;
	private String documento;
	private String nome;
	private String endereco;
	private BigDecimal salario;
	private String status;

	
	@Deprecated
	public PropostaResponse() {

	}

	public PropostaResponse(Long id, String documento, String nome, String endereco, BigDecimal salario, String status) {
		this.id = id;
		this.documento = documento;
		this.nome = nome;
		this.endereco = endereco;
		this.salario = salario;
		this.status = status;
	
	}

	public PropostaResponse(Optional<Proposta> proposta) {
		
		this.id = proposta.get().getId();
		this.documento = proposta.get().getDocumento();
		this.nome = proposta.get().getNome();
		this.endereco = proposta.get().getEndereco();
		this.salario = proposta.get().getSalario();
		this.status = proposta.get().getRestricao().toString();
	
	}

	public Long getIdProposta() {
		return id;
	}

	public String getDocumento() {
		return documento;
	}

	public String getNome() {
		return nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public BigDecimal getSalario() {
		return salario;
	}
	
	public String getStatus() {
		return status;
	}

}