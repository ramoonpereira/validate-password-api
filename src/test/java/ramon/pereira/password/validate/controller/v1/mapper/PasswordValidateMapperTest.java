package ramon.pereira.password.validate.controller.v1.mapper;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import ramon.pereira.password.validate.controller.v1.dtos.PasswordValidateRequestDTO;
import ramon.pereira.password.validate.model.PasswordValidateModel;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@ExtendWith(MockitoExtension.class)
class PasswordValidateMapperTest {

  @Test
  void executePasswordValidateMapperToModelIsNullExpectNullPointerException() {
    assertThatThrownBy(() -> PasswordValidateMapper.toModel(null))
        .isExactlyInstanceOf(NullPointerException.class);
  }

  @Test
  void executePasswordValidateMapperToModelIsValidExpectSuccess() {
    final var passwordDTO = PasswordValidateRequestDTO.builder()
        .password("123456789")
        .build();

    assertThat(PasswordValidateMapper.toModel(passwordDTO))
        .isNotNull()
        .isExactlyInstanceOf(PasswordValidateModel.class);
  }
}
