package ramon.pereira.password.validate.service.impl;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ramon.pereira.password.validate.exception.PasswordInvalidException;
import ramon.pereira.password.validate.model.PasswordValidateModel;
import ramon.pereira.password.validate.service.PasswordValidateService;
import ramon.pereira.password.validate.validator.PasswordValidateValidator;

@Service
@AllArgsConstructor(access = AccessLevel.PACKAGE, onConstructor = @__(@Autowired))
public class PasswordValidateServiceImpl implements PasswordValidateService {

    private final PasswordValidateValidator passwordValidateValidator;

    @Override
    public Boolean validatePassword(@NonNull final PasswordValidateModel passwordValidateModel) {
        try {
            passwordValidateValidator.withPassword(passwordValidateModel.getPassword())
                    .validSize()
                    .validWhitespace()
                    .validDigits()
                    .validCharacterLowerCase()
                    .validCharacterUpperCase()
                    .validSpecialCharacters()
                    .validRepeatedCharacters();

            return Boolean.TRUE;

        } catch (PasswordInvalidException ex) {
            return Boolean.FALSE;
        }

    }
}
