package br.com.projeto.base.projeto_base_clean_arch_modular.application.gateway;

public interface TokenGateway {
    String generateToken(String login, String senha);

    String validateToken(String token);
}
