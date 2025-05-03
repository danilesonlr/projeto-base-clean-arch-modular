package br.com.projeto.base.projeto_base_clean_arch_modular.infrastructure.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaAuditing
@EnableJpaRepositories(basePackages = "br.com.projeto.base")
@EntityScan(basePackages = "br.com.projeto.base")
public class JpaConfig {
}
