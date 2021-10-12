package ramon.pereira.password.validate.service.impl;

import lombok.NonNull;
import org.springframework.stereotype.Service;
import ramon.pereira.password.validate.model.PasswordValidateModel;
import ramon.pereira.password.validate.service.PasswordValidateService;

@Service
public class PasswordValidateServiceImpl implements PasswordValidateService {

    @Override
    public Boolean validatePassword(@NonNull final PasswordValidateModel passwordValidateModel) {
        return null;
    }

}
