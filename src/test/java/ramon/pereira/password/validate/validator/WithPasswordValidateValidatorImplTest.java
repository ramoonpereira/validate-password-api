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
}
