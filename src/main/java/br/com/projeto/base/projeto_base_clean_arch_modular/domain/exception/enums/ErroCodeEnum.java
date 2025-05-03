package br.com.projeto.base.projeto_base_clean_arch_modular.domain.exception.enums;

public enum ErroCodeEnum {
    /**
     * VALIDAÇÃO DE NEGOCIO
     */
    BUS0001("Nome é obrigatório.","BUS-0001"),
    BUS0002("Telefone é obrigatório.","BUS-0002"),
    BUS0003("CPF é obrigatório.","BUS-0003"),
    BUS0004("Data de nascimento é obrigatória.","BUS-0004"),
    BUS0005("CEP é obrigatório.","BUS-0005"),
    BUS0006("Funcionário deve ser maior de 18 anos.","BUS-0006"),

    /**
     * VALIDAÇÃO DE CASOS DE USO
     */
    UC0001("Endereço não encontrado.","UC-0001"),
    UC0002("Erro ao buscar endereço.","UC-0002") ,



    /**
     * VALIDAÇÃO DE AUTENTICAÇÃO
     */
    AUT0001("Usuário já existente", "AUT-0001"),
    AUT0002("Erro ao gerar token", "AUT-0002");
    private String message;
    private String code;

    ErroCodeEnum(String message, String code) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
