package br.com.projeto.base.projeto_base_clean_arch_modular.infrastructure.service;

import br.com.projeto.base.projeto_base_clean_arch_modular.infrastructure.repository.UsuarioEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthorizationService implements UserDetailsService {

    private final UsuarioEntityRepository usuarioEntityRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return usuarioEntityRepository.findByLogin(username)
                .orElse(null);
    }
}
