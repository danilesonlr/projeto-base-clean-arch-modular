package br.com.projeto.base.projeto_base_clean_arch_modular.domain.entities;


import br.com.projeto.base.projeto_base_clean_arch_modular.domain.entities.enums.AcessoRoleEnum;

import java.util.Objects;

public class Usuario {

    private Long id;
    private String login;
    private String passaword;
    private AcessoRoleEnum role;

    public Usuario() {
    }

    public Usuario(Long id, String login, String passaword, AcessoRoleEnum role) {
        this.id = id;
        this.login = login;
        this.passaword = passaword;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassaword() {
        return passaword;
    }

    public void setPassaword(String passaword) {
        this.passaword = passaword;
    }

    public AcessoRoleEnum getRole() {
        return role;
    }

    public void setRole(AcessoRoleEnum role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(id, usuario.id) && Objects.equals(login, usuario.login) && Objects.equals(passaword, usuario.passaword) && Objects.equals(role, usuario.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, passaword, role);
    }
}
