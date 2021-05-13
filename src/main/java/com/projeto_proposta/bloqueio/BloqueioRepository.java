package com.projeto_proposta.bloqueio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto_proposta.cartao.Cartao;

import java.util.Optional;

@Repository
public interface BloqueioRepository extends JpaRepository<Bloqueio, Long> {

    Optional<Bloqueio> findByCartao(Cartao cartao);
    
}