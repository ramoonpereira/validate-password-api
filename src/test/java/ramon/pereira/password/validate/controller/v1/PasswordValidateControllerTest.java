package ramon.pereira.password.validate.controller.v1;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import ramon.pereira.password.validate.controller.v1.dtos.PasswordValidateRequestDTO;
import ramon.pereira.password.validate.controller.v1.dtos.PasswordValidateResponseDTO;
import ramon.pereira.password.validate.model.PasswordValidateModel;
import ramon.pereira.password.validate.service.PasswordValidateService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PasswordValidateControllerTest {

  @Mock
  private PasswordValidateService passwordValidateService;

  @InjectMocks
  private PasswordValidateController passwordValidateController;

  @ParameterizedTest
  @ValueSource(strings = {"", "aa", "ab", "AAAbbbCc", "AbTp9!foo", "AbTp9!foA", "AbTp9 fok"})
  void executePasswordValidateServiceValidatePasswordExpectedReturnFalse(String password) {
    final var passwordDto = PasswordValidateRequestDTO.builder()
        .password(password)
        .build();

    final var passwordModel = PasswordValidateModel.builder()
        .password(password)
        .build();

    final var response = ResponseEntity.ok(PasswordValidateResponseDTO.builder()
        .valid(false)
        .build());

    when(passwordValidateService.validatePassword(passwordModel)).thenReturn(false);

    assertThat(passwordValidateController.validadePassword(passwordDto))
        .isNotNull()
        .isEqualTo(response);
  }

  @ParameterizedTest
  @ValueSource(strings = {"AbTp9!fok", "abTp9!fok", "abTp9&fok"})
  void executePasswordValidateServiceValidatePasswordExpectedReturnTrue(String password) {
    final var passwordDto = PasswordValidateRequestDTO.builder()
        .password(password)
        .build();

    final var passwordModel = PasswordValidateModel.builder()
        .password(password)
        .build();

    final var response = ResponseEntity.ok(PasswordValidateResponseDTO.builder()
        .valid(true)
        .build());

    when(passwordValidateService.validatePassword(passwordModel)).thenReturn(true);

    assertThat(passwordValidateController.validadePassword(passwordDto))
        .isNotNull()
        .isEqualTo(response);
  }
}
