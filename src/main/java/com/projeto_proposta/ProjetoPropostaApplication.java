package com.projeto_proposta;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;



@SpringBootApplication
@EnableFeignClients
@EnableScheduling
public class ProjetoPropostaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoPropostaApplication.class, args);
	}

	@PostConstruct
	void started() {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
	}
}

