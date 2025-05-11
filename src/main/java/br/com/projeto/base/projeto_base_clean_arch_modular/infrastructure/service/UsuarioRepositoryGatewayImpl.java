package br.com.projeto.base.projeto_base_clean_arch_modular.infrastructure.service;

import br.com.projeto.base.projeto_base_clean_arch_modular.application.gateway.UsuarioRepositoryGateway;
import br.com.projeto.base.projeto_base_clean_arch_modular.domain.entities.Usuario;
import br.com.projeto.base.projeto_base_clean_arch_modular.domain.exception.BusinessValidateException;
import br.com.projeto.base.projeto_base_clean_arch_modular.domain.exception.enums.ErroCodeEnum;
import br.com.projeto.base.projeto_base_clean_arch_modular.infrastructure.mapper.UsuarioMapper;
import br.com.projeto.base.projeto_base_clean_arch_modular.infrastructure.repository.UsuarioEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UsuarioRepositoryGatewayImpl implements UsuarioRepositoryGateway {

    private final UsuarioEntityRepository usuarioEntityRepository;
    private final UsuarioMapper usuarioMapper;

    @Override
    public void validateLogin(String login) {
        if(this.usuarioEntityRepository.findByLogin(login).isPresent()){
            throw new BusinessValidateException(ErroCodeEnum.AUT0001.getMessage(), ErroCodeEnum.AUT0001.getCode());
        }
    }

    @Override
    public void save(Usuario usuario) {
        usuarioEntityRepository.save(usuarioMapper.usuarioToUsuarioEntity(usuario));
    }
}
