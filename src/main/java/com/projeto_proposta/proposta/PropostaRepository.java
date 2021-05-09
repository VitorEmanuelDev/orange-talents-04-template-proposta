package com.projeto_proposta.proposta;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto_proposta.cartao.Cartao;
import com.projeto_proposta.cartao.RestricaoCartao;

@Repository
public interface PropostaRepository extends JpaRepository<Proposta, Long>{

	Optional<Proposta> findByDocumento(String documento);
	
	List<Proposta> findByRestricaoAndCartao(RestricaoCartao restricao, Cartao cartao);

}