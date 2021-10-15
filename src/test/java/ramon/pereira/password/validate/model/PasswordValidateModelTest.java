package ramon.pereira.password.validate.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PasswordValidateModelTest {

  @Test
  void executeNewPPasswordValidateModelNoArgs() {
    assertThat(new PasswordValidateModel())
        .isNotNull()
        .isExactlyInstanceOf(PasswordValidateModel.class);
  }

  @Test
  void executeNewPasswordValidateModelWithArgs() {
    assertThat(new PasswordValidateModel("1234"))
        .isNotNull()
        .isExactlyInstanceOf(PasswordValidateModel.class);
  }

  @Test
  void executePasswordValidateModelBuilder() {
    assertThat(PasswordValidateModel.builder()
        .build())
        .isNotNull()
        .isExactlyInstanceOf(PasswordValidateModel.class);
  }

}