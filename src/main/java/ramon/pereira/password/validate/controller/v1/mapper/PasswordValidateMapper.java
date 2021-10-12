package ramon.pereira.password.validate.controller.v1.mapper;

import lombok.experimental.UtilityClass;
import ramon.pereira.password.validate.controller.v1.dtos.PasswordValidateRequestDTO;
import ramon.pereira.password.validate.model.PasswordValidateModel;

import javax.validation.constraints.NotNull;

@UtilityClass
public class PasswordValidateMapper {

    public PasswordValidateModel toModel(@NotNull final PasswordValidateRequestDTO dto) {
        return PasswordValidateModel.builder()
                .password(dto.getPassword())
                .build();
    }

}
