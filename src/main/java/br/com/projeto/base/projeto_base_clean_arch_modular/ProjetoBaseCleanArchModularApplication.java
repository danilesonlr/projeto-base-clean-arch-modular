package br.com.projeto.base.projeto_base_clean_arch_modular;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EntityScan("br.com.base")
public class ProjetoBaseCleanArchModularApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoBaseCleanArchModularApplication.class, args);
	}

}
