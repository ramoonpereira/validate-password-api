package ramon.pereira.password.validate.validator.impl;

import lombok.RequiredArgsConstructor;
import ramon.pereira.password.validate.exception.PasswordInvalidException;
import ramon.pereira.password.validate.validator.PasswordValidateValidator;

@RequiredArgsConstructor
public class WithPasswordValidateValidatorImpl implements PasswordValidateValidator.WithPasswordValidateValidator {

    private final String password;

    @Override
    public PasswordValidateValidator.WithPasswordValidateValidator validSize() {

        if (password.isBlank() || password.length() < 9)
            throw new PasswordInvalidException();

        return this;
    }
}
