package com.projeto_proposta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableFeignClients
@EnableJpaRepositories(enableDefaultTransactions = false)
public class ProjetoPropostaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoPropostaApplication.class, args);
	}

}
