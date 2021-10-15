package ramon.pereira.password.validate.controller.v1.dtos;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PasswordValidateRequestDTOTest {

  @Test
  void executeNewPasswordValidateRequestDTONoArgs() {
    assertThat(new PasswordValidateRequestDTO())
        .isNotNull()
        .isExactlyInstanceOf(PasswordValidateRequestDTO.class);
  }

  @Test
  void executeNewPasswordValidateRequestDTOWithArgs() {
    assertThat(new PasswordValidateRequestDTO("1234"))
        .isNotNull()
        .isExactlyInstanceOf(PasswordValidateRequestDTO.class);
  }

  @Test
  void executePasswordValidateRequestDTOBuilder() {
    assertThat(PasswordValidateRequestDTO.builder()
        .build())
        .isNotNull()
        .isExactlyInstanceOf(PasswordValidateRequestDTO.class);
  }

}
