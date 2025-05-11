package br.com.projeto.base.projeto_base_clean_arch_modular.infrastructure.service;

import br.com.projeto.base.projeto_base_clean_arch_modular.application.gateway.PasswordGateway;
import br.com.projeto.base.projeto_base_clean_arch_modular.domain.entities.Usuario;
import br.com.projeto.base.projeto_base_clean_arch_modular.infrastructure.entity.UsuarioEntity;
import br.com.projeto.base.projeto_base_clean_arch_modular.infrastructure.mapper.UsuarioMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PasswordGatewayImpl implements PasswordGateway {

    private final AuthenticationManager authenticationManager;
    private final UsuarioMapper usuarioMapper;

    public Usuario authenticate(String login, String senha) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(login, senha);
        var auth = authenticationManager.authenticate(usernamePassword);
        UsuarioEntity user = (UsuarioEntity) auth.getPrincipal();
        return usuarioMapper.entityToUsuario(user);
    }

    public String encoderPassword(String senha) {
        return new BCryptPasswordEncoder().encode(senha);
    }
}
