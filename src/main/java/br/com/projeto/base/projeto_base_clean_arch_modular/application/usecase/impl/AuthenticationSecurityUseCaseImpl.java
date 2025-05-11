package br.com.projeto.base.projeto_base_clean_arch_modular.application.usecase.impl;

import br.com.projeto.base.projeto_base_clean_arch_modular.application.gateway.PasswordGateway;
import br.com.projeto.base.projeto_base_clean_arch_modular.application.gateway.TokenGateway;
import br.com.projeto.base.projeto_base_clean_arch_modular.application.gateway.UsuarioRepositoryGateway;
import br.com.projeto.base.projeto_base_clean_arch_modular.application.usecase.AuthenticationSecurityUseCase;
import br.com.projeto.base.projeto_base_clean_arch_modular.domain.entities.Usuario;
import br.com.projeto.base.projeto_base_clean_arch_modular.domain.entities.enums.AcessoRoleEnum;

public class AuthenticationSecurityUseCaseImpl implements AuthenticationSecurityUseCase {


    private PasswordGateway passwordGateway;
    private UsuarioRepositoryGateway usuarioRepositoryGateway;
    private  TokenGateway tokenService;

    public AuthenticationSecurityUseCaseImpl(PasswordGateway passwordEncoderGateway,
                                             UsuarioRepositoryGateway usuarioRepositoryGateway,
                                             TokenGateway tokenService) {
        this.passwordGateway = passwordEncoderGateway;
        this.usuarioRepositoryGateway = usuarioRepositoryGateway;
        this.tokenService = tokenService;
    }

    @Override
    public String authentication(String login, String senha){
        Usuario usuario = passwordGateway.authenticate(login, senha);
        return tokenService.generateToken(usuario.getLogin(), usuario.getPassaword());
    }

    @Override
    public void register(String login, String senha){
        usuarioRepositoryGateway.validateLogin(login);

        String senhaEncoder = passwordGateway.encoderPassword(senha);
        Usuario usuario = new Usuario(null, login, senhaEncoder, AcessoRoleEnum.USER);
        usuarioRepositoryGateway.save(usuario);
    }
}
