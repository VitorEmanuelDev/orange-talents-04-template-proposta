package com.projeto_proposta.cartao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
public interface CartaoRepository extends JpaRepository<Cartao, Long> {
	
	
}