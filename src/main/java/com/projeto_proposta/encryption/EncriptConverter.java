package com.projeto_proposta.encryption;


import org.springframework.security.crypto.encrypt.Encryptors;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class EncriptConverter implements AttributeConverter<String, String> {

    @SuppressWarnings("deprecation")
	@Override
    public String convertToDatabaseColumn(String documento) {
        try {
            return Encryptors.queryableText("${proposta.ofuscamento.texto}", "12345678").encrypt(documento);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @SuppressWarnings("deprecation")
	@Override
    public String convertToEntityAttribute(String documento) {
        try {
            return Encryptors.queryableText("${proposta.ofuscamento.texto}", "12345678").decrypt(documento);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}