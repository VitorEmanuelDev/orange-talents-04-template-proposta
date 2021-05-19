package com.projeto_proposta.schedule;


import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.projeto_proposta.cartao.CartaoClientResponse;
import com.projeto_proposta.cartao.RestricaoCartao;
import com.projeto_proposta.feign.Cartoes;
import com.projeto_proposta.proposta.Proposta;
import com.projeto_proposta.proposta.PropostaRepository;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class ConsultaPropostas {

    @Autowired
    private PropostaRepository propostaRepository;

    @Autowired
    private Cartoes cartao;

    public ConsultaPropostas(PropostaRepository propostaRepository, Cartoes cartao) {
        this.propostaRepository = propostaRepository;
        this.cartao = cartao;
    }
   
   @Scheduled(fixedDelayString = "${periodicidade.tentativa-numero-cartao}")
   //@Transactional
    public void consultaPropostasElegiveis() {
    	
	   List<Proposta> proposta = propostaRepository.findByRestricaoAndCartao(RestricaoCartao.ELEGIVEL, null);
       
      try{
    	  
           for (Proposta lista: proposta ) {
        	   
               CartaoClientResponse novoCartao = cartao.cartaoParaProposta(lista.getId().toString());
               lista.adicionaCartao(novoCartao.toModel(lista));
               //lista.adicionaRestricao(RestricaoCartao.NAO_ELEGIVEL);
               propostaRepository.save(lista);
           }
           
       }catch (FeignException.UnprocessableEntity e){
    	   e.printStackTrace();
      }
      
    }
    
}