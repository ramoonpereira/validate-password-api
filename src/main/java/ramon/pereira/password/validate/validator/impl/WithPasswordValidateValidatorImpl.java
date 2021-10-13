package ramon.pereira.password.validate.validator.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.util.StringUtils;
import ramon.pereira.password.validate.exception.PasswordInvalidException;
import ramon.pereira.password.validate.validator.PasswordValidateValidator;

import java.util.Arrays;

@RequiredArgsConstructor
public class WithPasswordValidateValidatorImpl implements PasswordValidateValidator.WithPasswordValidateValidator {

    private final String password;
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()+-";

    @Override
    public PasswordValidateValidator.WithPasswordValidateValidator validSize() {

        if (password.isBlank() || password.length() < 9)
            throw new PasswordInvalidException();

        return this;
    }

    @Override
    public PasswordValidateValidator.WithPasswordValidateValidator validRepeatedCharacters() {
        for (int a = 0; a < password.length(); a++) {
            for (int b = a + 1; b < password.length(); b++) {
                if (password.charAt(a) == password.charAt(b)) {
                    throw new PasswordInvalidException();
                }
            }
        }
        return this;
    }

    @Override
    public PasswordValidateValidator.WithPasswordValidateValidator validSpecialCharacters() {
        if (Arrays.stream(SPECIAL_CHARACTERS.split("")).anyMatch(password::contains))
            return this;

        throw new PasswordInvalidException();
    }

    @Override
    public PasswordValidateValidator.WithPasswordValidateValidator validWhitespace() {
        if (StringUtils.containsWhitespace(password))
            throw new PasswordInvalidException();

        return this;
    }

    @Override
    public PasswordValidateValidator.WithPasswordValidateValidator validDigits() {
        for (int i = 0; i < password.length(); i++) {
            if (Character.isDigit(password.charAt(i))) {
                return this;
            }
        }

        throw new PasswordInvalidException();
    }

    @Override
    public PasswordValidateValidator.WithPasswordValidateValidator validCharacterLowerCase() {
        for (int i = 0; i < password.length(); i++) {
            if (Character.isLowerCase(password.charAt(i))) {
                return this;
            }
        }

        throw new PasswordInvalidException();
    }

    @Override
    public PasswordValidateValidator.WithPasswordValidateValidator validCharacterUpperCase() {
        for (int i = 0; i < password.length(); i++) {
            if (Character.isUpperCase(password.charAt(i))) {
                return this;
            }
        }

        throw new PasswordInvalidException();
    }
}
