package br.com.projeto.base.projeto_base_clean_arch_modular.infrastructure.repository;

import br.com.projeto.base.projeto_base_clean_arch_modular.infrastructure.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioEntityRepository extends JpaRepository<UsuarioEntity, Long> {
    Optional<UsuarioEntity> findByLogin(String login);
}
