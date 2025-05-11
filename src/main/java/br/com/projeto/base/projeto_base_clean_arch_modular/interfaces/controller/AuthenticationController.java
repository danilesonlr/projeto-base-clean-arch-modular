package br.com.projeto.base.projeto_base_clean_arch_modular.interfaces.controller;


import br.com.projeto.base.projeto_base_clean_arch_modular.application.usecase.AuthenticationSecurityUseCase;
import br.com.projeto.base.projeto_base_clean_arch_modular.interfaces.dto.AuthenticationDTO;
import br.com.projeto.base.projeto_base_clean_arch_modular.interfaces.dto.RegisterDTO;
import br.com.projeto.base.projeto_base_clean_arch_modular.interfaces.dto.ResponseAuthenticationToken;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationSecurityUseCase authenticationSecurityUseCase;


    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO authenticationDTO){
        String token = authenticationSecurityUseCase.authentication(authenticationDTO.getLogin(),
                authenticationDTO.getSenha());
        return ResponseEntity.ok(ResponseAuthenticationToken.builder()
                .token(token)
                .build());
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void register(@RequestBody @Valid RegisterDTO registerDTO){
        authenticationSecurityUseCase.register(registerDTO.getLogin(), registerDTO.getSenha());
    }
}
