package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class RegistrationPage extends BasePage {
    private final SelenideElement
            firstName = $("#firstname"),
            lastName = $("#lastname"),
            email = $("#email_address"),
            password = $("#password"),
            passwordConfirmation = $("#password-confirmation"),
            submit = $("#form-validate button");

    public RegistrationPage setFirstName(String value) {
        firstName.setValue(value);
        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastName.setValue(value);
        return this;
    }

    public RegistrationPage setEmail(String value) {
        email.setValue(value);
        return this;
    }

    public RegistrationPage setPassword(String value) {
        password.setValue(value);
        return this;
    }

    public RegistrationPage confirmPassword(String value) {
        passwordConfirmation.setValue(value);
        return this;
    }

    public RegistrationPage submit() {
        submit.click();
        return this;
    }
}
