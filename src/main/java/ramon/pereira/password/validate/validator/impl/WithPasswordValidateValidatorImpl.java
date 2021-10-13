package ramon.pereira.password.validate.validator.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.util.StringUtils;
import ramon.pereira.password.validate.exception.PasswordInvalidException;
import ramon.pereira.password.validate.validator.WithPasswordValidateValidator;

import java.util.Arrays;

@RequiredArgsConstructor
public class WithPasswordValidateValidatorImpl implements WithPasswordValidateValidator {

    private final String password;
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()+-";

    @Override
    public WithPasswordValidateValidator validSize() {

        if (password.isBlank() || password.length() < 9)
            throw new PasswordInvalidException();

        return this;
    }

    @Override
    public WithPasswordValidateValidator validRepeatedCharacters() {
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
    public WithPasswordValidateValidator validSpecialCharacters() {
        if (Arrays.stream(SPECIAL_CHARACTERS.split("")).anyMatch(password::contains))
            return this;

        throw new PasswordInvalidException();
    }

    @Override
    public WithPasswordValidateValidator validWhitespace() {
        if (StringUtils.containsWhitespace(password))
            throw new PasswordInvalidException();

        return this;
    }

    @Override
    public WithPasswordValidateValidator validDigits() {
        for (int i = 0; i < password.length(); i++) {
            if (Character.isDigit(password.charAt(i))) {
                return this;
            }
        }

        throw new PasswordInvalidException();
    }

    @Override
    public WithPasswordValidateValidator validCharacterLowerCase() {
        for (int i = 0; i < password.length(); i++) {
            if (Character.isLowerCase(password.charAt(i))) {
                return this;
            }
        }

        throw new PasswordInvalidException();
    }

    @Override
    public WithPasswordValidateValidator validCharacterUpperCase() {
        for (int i = 0; i < password.length(); i++) {
            if (Character.isUpperCase(password.charAt(i))) {
                return this;
            }
        }

        throw new PasswordInvalidException();
    }
}
