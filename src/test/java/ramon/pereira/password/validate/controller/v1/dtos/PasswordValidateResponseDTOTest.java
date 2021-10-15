package ramon.pereira.password.validate.controller.v1.dtos;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

  @ExtendWith(MockitoExtension.class)
  class PasswordValidateResponseDTOTest {

    @Test
    void executeNewPasswordValidateResponseDTONoArgs() {
      assertThat(new PasswordValidateResponseDTO())
          .isNotNull()
          .isExactlyInstanceOf(PasswordValidateResponseDTO.class);
    }

    @Test
    void executeNewPasswordValidateResponseDTOWithArgs() {
      assertThat(new PasswordValidateResponseDTO(true))
          .isNotNull()
          .isExactlyInstanceOf(PasswordValidateResponseDTO.class);
    }

    @Test
    void executePasswordValidateResponseDTOBuilder() {
      assertThat(PasswordValidateResponseDTO.builder()
          .build())
          .isNotNull()
          .isExactlyInstanceOf(PasswordValidateResponseDTO.class);
    }
}
