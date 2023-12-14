package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends BasePage {
    private final SelenideElement email = $("#email"),
    password = $("#pass"),
    signInButton = $(".primary#send2"),
    forgotYourPassword = $("a.remind"),
    messageSuccess = $("div.message-success");

    public LoginPage setEmail(String value) {
        email.setValue(value);
        return this;
    }
    public LoginPage setPassword(String value) {
        password.setValue(value);
        return this;
    }
    public LoginPage signIn() {
        signInButton.click();
        return this;
    }

    public LoginPage clickForgotYourPassword() {
        forgotYourPassword.click();
        return this;
    }

    public LoginPage verifySuccessMessage(String email) {
        messageSuccess.shouldHave(text("If there is an account associated with " + email + " you will receive an email with a" +
        " link to reset your password."));
        return this;
    }
}
