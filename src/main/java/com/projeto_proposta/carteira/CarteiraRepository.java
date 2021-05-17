package com.projeto_proposta.carteira;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto_proposta.cartao.Cartao;

@Repository
public interface CarteiraRepository extends JpaRepository<Carteira, Long> {

    public Optional<Carteira> findByCartaoAndIdCarteira(Cartao cartao, IdCarteira idCarteira);
}