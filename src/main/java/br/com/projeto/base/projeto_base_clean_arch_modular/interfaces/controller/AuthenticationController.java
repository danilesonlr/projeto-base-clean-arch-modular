package br.com.projeto.base.projeto_base_clean_arch_modular.interfaces.controller;


import br.com.projeto.base.projeto_base_clean_arch_modular.infrastructure.service.AuthenticationSecurityServiceImpl;
import br.com.projeto.base.projeto_base_clean_arch_modular.interfaces.dto.AuthenticationDTO;
import br.com.projeto.base.projeto_base_clean_arch_modular.interfaces.dto.RegisterDTO;
import br.com.projeto.base.projeto_base_clean_arch_modular.interfaces.dto.ResponseAuthenticationToken;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationSecurityServiceImpl authenticationSecurityService;


    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO authenticationDTO){
        String token = authenticationSecurityService.authentication(authenticationDTO.getLogin(),
                authenticationDTO.getSenha());
        return ResponseEntity.ok(ResponseAuthenticationToken.builder()
                .token(token)
                .build());
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO registerDTO){
        authenticationSecurityService.register(registerDTO.getLogin(), registerDTO.getSenha());
        return ResponseEntity.ok().build();
    }
}
