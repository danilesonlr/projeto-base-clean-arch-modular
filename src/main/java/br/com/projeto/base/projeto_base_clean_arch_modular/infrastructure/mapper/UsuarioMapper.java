package br.com.projeto.base.projeto_base_clean_arch_modular.infrastructure.mapper;

import br.com.projeto.base.projeto_base_clean_arch_modular.domain.entities.Usuario;
import br.com.projeto.base.projeto_base_clean_arch_modular.infrastructure.entity.UsuarioEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    Usuario entityToUsuario(UsuarioEntity usuarioEntity);
    UsuarioEntity usuarioToUsuarioEntity(Usuario usuario);
}
