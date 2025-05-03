package br.com.projeto.base.projeto_base_clean_arch_modular.infrastructure.entity.converter;

import br.com.projeto.base.projeto_base_clean_arch_modular.infrastructure.entity.enums.AcessoRoleEnum;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class AcessoConverter  implements AttributeConverter<AcessoRoleEnum, String> {

    @Override
    public String convertToDatabaseColumn(AcessoRoleEnum role) {
        return role != null ? role.name() : null;
    }

    @Override
    public AcessoRoleEnum convertToEntityAttribute(String dbData) {
        if (dbData == null) return null;
        try {
            return AcessoRoleEnum.valueOf(dbData);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Invalid value for Role enum: " + dbData);
        }
    }
}
