package br.com.projeto.base.projeto_base_clean_arch_modular.interfaces.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v2")
public class ControllerTeste {

    @GetMapping
    public String getTeste(){
        return "Aplicação está funcionando corretamente com autenticação";
    }
}
