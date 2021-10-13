package ramon.pereira.password.validate.validator;

public interface PasswordValidateValidator {

    WithPasswordValidateValidator withPassword(String password);

    interface WithPasswordValidateValidator {

        WithPasswordValidateValidator validSize();

        WithPasswordValidateValidator validRepeatedCharacters();

        WithPasswordValidateValidator validSpecialCharacters();

        WithPasswordValidateValidator validWhitespace();

        WithPasswordValidateValidator validDigits();

        WithPasswordValidateValidator validCharacterLowerCase();

        WithPasswordValidateValidator validCharacterUpperCase();
    }
}
