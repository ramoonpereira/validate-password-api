package ramon.pereira.password.validate.validator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.junit.jupiter.MockitoExtension;
import ramon.pereira.password.validate.exception.PasswordInvalidException;
import ramon.pereira.password.validate.validator.impl.WithPasswordValidateValidatorImpl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@ExtendWith(MockitoExtension.class)
public class WithPasswordValidateValidatorImplTest {


  @ParameterizedTest
  @ValueSource(strings = {"1", "         "})
  void executePasswordValidateValidatorValidSizeNotSizeRulesExpectedPasswordInvalidException(String password) {
    WithPasswordValidateValidator passwordValidateValidator =
        new WithPasswordValidateValidatorImpl(password);

    assertThatThrownBy(passwordValidateValidator::validSize)
        .isExactlyInstanceOf(PasswordInvalidException.class);
  }

  @Test
  void executePasswordValidateValidatorValidSizeStringValidExpectedSuccess() {
    WithPasswordValidateValidator passwordValidateValidator =
        new WithPasswordValidateValidatorImpl("123456789");

    final var passwordValidate = passwordValidateValidator.validSize();

    assertThat(passwordValidate)
        .isNotNull()
        .isExactlyInstanceOf(WithPasswordValidateValidatorImpl.class);
  }

  @Test
  void executePasswordValidateValidatorValidRepeatedCharactersContainsRepeteadExpectedPasswordInvalidException() {
    WithPasswordValidateValidator passwordValidateValidator =
        new WithPasswordValidateValidatorImpl("1234456789");

    assertThatThrownBy(passwordValidateValidator::validRepeatedCharacters)
        .isExactlyInstanceOf(PasswordInvalidException.class);
  }

  @Test
  void executePasswordValidateValidatorValidRepeatedCharactersStringIsValidExpectedSuccess() {
    WithPasswordValidateValidator passwordValidateValidator =
        new WithPasswordValidateValidatorImpl("123456789");

    final var passwordValidate = passwordValidateValidator.validRepeatedCharacters();

    assertThat(passwordValidate)
        .isNotNull()
        .isExactlyInstanceOf(WithPasswordValidateValidatorImpl.class);
  }

  @Test
  void executePasswordValidateValidatorValidSpecialCharactersNotContainsSpecialExpectedPasswordInvalidException() {
    WithPasswordValidateValidator passwordValidateValidator =
        new WithPasswordValidateValidatorImpl("123456789");

    assertThatThrownBy(passwordValidateValidator::validSpecialCharacters)
        .isExactlyInstanceOf(PasswordInvalidException.class);
  }

  @Test
  void executePasswordValidateValidatorValidSpecialCharactersContainsSpecialExpectedSuccess() {
    WithPasswordValidateValidator passwordValidateValidator =
        new WithPasswordValidateValidatorImpl("123456789&");

    final var passwordValidate = passwordValidateValidator.validSpecialCharacters();

    assertThat(passwordValidate)
        .isNotNull()
        .isExactlyInstanceOf(WithPasswordValidateValidatorImpl.class);
  }

  @Test
  void executePasswordValidateValidatorValidWhitespaceContainsWhitespaceExpectedPasswordInvalidException() {
    WithPasswordValidateValidator passwordValidateValidator =
        new WithPasswordValidateValidatorImpl("123456789 &");

    assertThatThrownBy(passwordValidateValidator::validWhitespace)
        .isExactlyInstanceOf(PasswordInvalidException.class);


  }

  @Test
  void executePasswordValidateValidatorValidWhitespaceNotContainsWhitespaceExpectedSuccess() {
    WithPasswordValidateValidator passwordValidateValidator =
        new WithPasswordValidateValidatorImpl("123456789&");

    final var passwordValidate = passwordValidateValidator.validWhitespace();

    assertThat(passwordValidate)
        .isNotNull()
        .isExactlyInstanceOf(WithPasswordValidateValidatorImpl.class);

  }

  @Test
  void executePasswordValidateValidatorValidDigitsNotContainsDigitsExpectedPasswordInvalidException() {
    WithPasswordValidateValidator passwordValidateValidator =
        new WithPasswordValidateValidatorImpl("ABCDEFGHIJ");

    assertThatThrownBy(passwordValidateValidator::validDigits)
        .isExactlyInstanceOf(PasswordInvalidException.class);


  }

  @Test
  void executePasswordValidateValidatorValidDigitsContainsDigitsExpectedSuccess() {
    WithPasswordValidateValidator passwordValidateValidator =
        new WithPasswordValidateValidatorImpl("123456789&");

    final var passwordValidate = passwordValidateValidator.validDigits();

    assertThat(passwordValidate)
        .isNotNull()
        .isExactlyInstanceOf(WithPasswordValidateValidatorImpl.class);

  }

  @Test
  void executePasswordValidateValidatorValidCharacterLowerCaseNotContainsLowerCaseExpectedPasswordInvalidException() {
    WithPasswordValidateValidator passwordValidateValidator =
        new WithPasswordValidateValidatorImpl("ABCDEFGHIJ");

    assertThatThrownBy(passwordValidateValidator::validCharacterLowerCase)
        .isExactlyInstanceOf(PasswordInvalidException.class);


  }

  @Test
  void executePasswordValidateValidatorValidCharacterLowerCaseContainsLowerCaseExpectedSuccess() {
    WithPasswordValidateValidator passwordValidateValidator =
        new WithPasswordValidateValidatorImpl("abcDEFGHIJ&");

    final var passwordValidate = passwordValidateValidator.validCharacterLowerCase();

    assertThat(passwordValidate)
        .isNotNull()
        .isExactlyInstanceOf(WithPasswordValidateValidatorImpl.class);

  }

  @Test
  void executePasswordValidateValidatorValidCharacterUpperCaseNotContainsUpperCaseExpectedPasswordInvalidException() {
    WithPasswordValidateValidator passwordValidateValidator =
        new WithPasswordValidateValidatorImpl("abcdefghij");

    assertThatThrownBy(passwordValidateValidator::validCharacterUpperCase)
        .isExactlyInstanceOf(PasswordInvalidException.class);


  }

  @Test
  void executePasswordValidateValidatorValidCharacterUpperCaseContainsUpperCaseExpectedSuccess() {
    WithPasswordValidateValidator passwordValidateValidator =
        new WithPasswordValidateValidatorImpl("abcDEFGHIJ&");

    final var passwordValidate = passwordValidateValidator.validCharacterUpperCase();

    assertThat(passwordValidate)
        .isNotNull()
        .isExactlyInstanceOf(WithPasswordValidateValidatorImpl.class);

  }


}
