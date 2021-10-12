package ramon.pereira.password.validate.validator;

public interface PasswordValidateValidator {

    WithPasswordValidateValidator withPassword(String password);

    interface WithPasswordValidateValidator {

        WithPasswordValidateValidator validSize();

    }
}
