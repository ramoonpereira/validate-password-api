package ramon.pereira.password.validate.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.junit.jupiter.MockitoExtension;
import ramon.pereira.password.validate.model.PasswordValidateModel;
import ramon.pereira.password.validate.service.impl.PasswordValidateServiceImpl;
import ramon.pereira.password.validate.validator.impl.PasswordValidateValidatorImpl;

import static org.assertj.core.api.Assertions.assertThat;


@ExtendWith(MockitoExtension.class)
public class PasswordValidateServiceImplTest {

    private PasswordValidateServiceImpl passwordValidateService;

    @BeforeEach
    void setUp() {
        final var passwordValidateValidator = new PasswordValidateValidatorImpl();
        this.passwordValidateService =
                new PasswordValidateServiceImpl(passwordValidateValidator);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "aa", "ab", "AAAbbbCc", "AbTp9!foo", "AbTp9!foA", "AbTp9 fok"})
    void executePasswordValidateServiceValidatePasswordExpectedReturnFalse(String password) {
        final var passwordModel = PasswordValidateModel.builder()
                .password(password)
                .build();

        assertThat(passwordValidateService.validatePassword(passwordModel))
                .isFalse();
    }

    @ParameterizedTest
    @ValueSource(strings = {"AbTp9!fok", "abTp9!fok", "abTp9&fok"})
    void executePasswordValidateServiceValidatePasswordExpectedReturnTrue(String password) {
        final var passwordModel = PasswordValidateModel.builder()
                .password(password)
                .build();

        assertThat(passwordValidateService.validatePassword(passwordModel))
                .isTrue();
    }
}
