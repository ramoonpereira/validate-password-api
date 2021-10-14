package ramon.pereira.password.validate.service;

import ramon.pereira.password.validate.model.PasswordValidateModel;

public interface PasswordValidateService {

  Boolean validatePassword(PasswordValidateModel passwordValidateModel);
}
