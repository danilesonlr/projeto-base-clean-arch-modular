package br.com.projeto.base.projeto_base_clean_arch_modular.infrastructure.service;


import br.com.projeto.base.projeto_base_clean_arch_modular.application.usecase.AuthenticationSecurityUseCase;
import br.com.projeto.base.projeto_base_clean_arch_modular.domain.exception.BusinessValidateException;
import br.com.projeto.base.projeto_base_clean_arch_modular.domain.exception.enums.ErroCodeEnum;
import br.com.projeto.base.projeto_base_clean_arch_modular.infrastructure.entity.UsuarioEntity;
import br.com.projeto.base.projeto_base_clean_arch_modular.infrastructure.entity.enums.AcessoRoleEnum;
import br.com.projeto.base.projeto_base_clean_arch_modular.infrastructure.repository.UsuarioEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationSecurityServiceUseCaseImpl implements AuthenticationSecurityUseCase {

    private final AuthenticationManager authenticationManager;
    private final UsuarioEntityRepository usuarioEntityRepository;
    private final TokenServiceImpl tokenService;

    @Override
    public String authentication(String login, String senha){
        var usernamePassword = new UsernamePasswordAuthenticationToken(login, senha);
        var auth = authenticationManager.authenticate(usernamePassword);
        UsuarioEntity user = (UsuarioEntity) auth.getPrincipal();
        return tokenService.generateToken(user.getUsername(), user.getPassword());
    }

    @Override
    public void register(String login, String passaword) {
        if(this.usuarioEntityRepository.findByLogin(login).isPresent()){
            throw new BusinessValidateException(ErroCodeEnum.AUT0001.getMessage(), ErroCodeEnum.AUT0001.getCode());
        }
        String encryptePassword = new BCryptPasswordEncoder().encode(passaword);
        UsuarioEntity acesso = UsuarioEntity.builder()
                .login(login)
                .passaword(encryptePassword)
                .role(AcessoRoleEnum.USER)
                .build();
        usuarioEntityRepository.save(acesso);
    }
}
