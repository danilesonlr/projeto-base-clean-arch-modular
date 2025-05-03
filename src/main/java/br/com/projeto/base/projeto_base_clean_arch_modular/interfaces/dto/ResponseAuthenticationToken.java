package br.com.projeto.base.projeto_base_clean_arch_modular.interfaces.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ResponseAuthenticationToken {
    String token;
}
