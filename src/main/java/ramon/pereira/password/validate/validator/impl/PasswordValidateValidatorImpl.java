package ramon.pereira.password.validate.validator.impl;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ramon.pereira.password.validate.validator.PasswordValidateValidator;
import ramon.pereira.password.validate.validator.WithPasswordValidateValidator;

@Component
@RequiredArgsConstructor
public class PasswordValidateValidatorImpl implements PasswordValidateValidator {

    @Override
    public WithPasswordValidateValidator withPassword(@NonNull final String password) {
        return new WithPasswordValidateValidatorImpl(password);
    }

}
