package com.projeto_proposta.carteira;

import com.fasterxml.jackson.annotation.JsonCreator;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public enum IdCarteira {

    PAYPAL;

    @JsonCreator IdCarteira fromString(String value) {
    	
        if (value == null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Valor inválido");
        
        for (var idCarteira : values()) {
            if (value.equalsIgnoreCase(idCarteira.toString())) {
                return idCarteira;
            }
        }
        
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Valor inválido");
    }
}