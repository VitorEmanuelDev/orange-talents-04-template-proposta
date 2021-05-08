package com.projeto_proposta.proposta;

import java.math.BigDecimal;

import javax.persistence.*;
import javax.validation.constraints.*;

import com.projeto_proposta.cartao.Cartao;
import com.projeto_proposta.cartao.CartaoRequest;
import com.projeto_proposta.cartao.RestricaoCartao;
import com.projeto_proposta.validation.CpfOuCnpj;

@Entity
public class Proposta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@CpfOuCnpj
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
	
	@Enumerated(EnumType.STRING)
	private RestricaoCartao restricao;
	
	@OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	private Cartao cartao;
	
	
	@Deprecated
	public Proposta() {
	}
	
	public Proposta(String documento, @Email @NotNull @NotBlank String email, @NotNull @NotBlank String nome,
			@NotNull @NotBlank String endereco, @NotNull @Positive BigDecimal salario) {
		super();
		this.documento = documento;
		this.email = email;
		this.nome = nome;
		this.endereco = endereco;
		this.salario = salario;
	}
	
	public Proposta(String documento, @Email @NotNull @NotBlank String email, @NotNull @NotBlank String nome,
			@NotNull @NotBlank String endereco, @NotNull @Positive BigDecimal salario, RestricaoCartao restricao) {
		super();
		this.documento = documento;
		this.email = email;
		this.nome = nome;
		this.endereco = endereco;
		this.salario = salario;
		this.restricao = restricao;
	}
	
	public Long getId() {
		return id;
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
	
	public RestricaoCartao getRestricao() {
		return restricao;
	}

	public CartaoRequest toModelCartao() {
		return new CartaoRequest(documento, nome, id.toString());
	}

	public void adicionaRestricao(RestricaoCartao elegivel) {
		this.restricao = elegivel;

	}
	
	public Cartao getCartao() {
		return cartao;
	}

	public void adicionaCartao(Cartao cartao){
		this.cartao = cartao;
	}

}
