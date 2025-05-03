package br.com.projeto.base.projeto_base_clean_arch_modular.application.gateway;


public interface AuthenticationSecurityGateway {
     String authentication(String login, String senha);

     void register(String login, String senha);

}
