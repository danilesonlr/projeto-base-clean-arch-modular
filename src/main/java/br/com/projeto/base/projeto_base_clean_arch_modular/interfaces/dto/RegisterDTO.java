package br.com.projeto.base.projeto_base_clean_arch_modular.interfaces.dto;

import br.com.projeto.base.projeto_base_clean_arch_modular.infrastructure.entity.enums.AcessoRoleEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RegisterDTO {
    private String login;
    private String senha;
}
