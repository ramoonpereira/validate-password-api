package ramon.pereira.password.validate.validator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import ramon.pereira.password.validate.validator.impl.PasswordValidateValidatorImpl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@ExtendWith(MockitoExtension.class)
public class PasswordValidateValidatorImplTest {

  @InjectMocks
  private PasswordValidateValidatorImpl passwordValidateValidator;

  @Test
  void executePasswordValidateValidatorWithPasswordNullExpectNullPointException() {
    assertThatThrownBy(() -> passwordValidateValidator.withPassword(null))
        .isExactlyInstanceOf(NullPointerException.class);
  }

  @Test
  void executePasswordValidateValidatorWithPasswordValidExpectSuccess() {
    assertThat(passwordValidateValidator.withPassword("123456789"))
        .isNotNull();
  }
}
