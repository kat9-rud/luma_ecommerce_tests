package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class ForgotPasswordPage extends BasePage {
    private final SelenideElement email = $("#email_address"),
            resetMyPasswordButton = $("button.submit");

    public ForgotPasswordPage setEmail(String value) {
        email.setValue(value);
        return this;
    }

    public ForgotPasswordPage clickResetMyPassword() {
        resetMyPasswordButton.click();
        return this;
    }
}
