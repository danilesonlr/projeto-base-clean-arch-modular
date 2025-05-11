package br.com.projeto.base.projeto_base_clean_arch_modular.domain.entities.enums;

public enum AcessoRoleEnum {
    ADMIN("admin"),
    USER("user");

    private String role;

    AcessoRoleEnum(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
