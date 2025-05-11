package br.com.projeto.base.projeto_base_clean_arch_modular.application.gateway;

import br.com.projeto.base.projeto_base_clean_arch_modular.domain.entities.Usuario;

public interface UsuarioRepositoryGateway {


    void validateLogin(String login);

    void save(Usuario usuario);
}
