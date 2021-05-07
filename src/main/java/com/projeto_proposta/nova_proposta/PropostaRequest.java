package com.projeto_proposta.nova_proposta;

import java.math.BigDecimal;

import javax.validation.constraints.*;

import com.projeto_proposta.validation.CPF_CNPJ;



public class PropostaRequest {


	@CPF_CNPJ
	private String documento;
	
	@Email
	@NotNull
	@NotBlank
	private String email;
	
	@NotNull
	@NotBlank
	private String nome;
	
	@NotNull
	@NotBlank
	private String endereco;
	
	@NotNull
	@Positive
	private BigDecimal salario;
	
	
	@Deprecated
	public PropostaRequest() {
	}



	public PropostaRequest(String documento, @Email @NotNull @NotBlank String email, @NotNull @NotBlank String nome,
			@NotNull @NotBlank String endereco, @NotNull @NotBlank @Positive BigDecimal salario) {
		this.documento = documento;
		this.email = email;
		this.nome = nome;
		this.endereco = endereco;
		this.salario = salario;
	}

	public String getDocumento() {
		return documento;
	}

	public String getEmail() {
		return email;
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



	public Proposta toModel() {
		return new Proposta(documento, email, nome, endereco, salario);
	}
	
	
}