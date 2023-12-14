package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MyAccountPage extends BasePage {
    private final String TITLE = "My Account";
    private final String MESSAGE_SUCCESS = "Thank you for registering with Main Website Store.";
    private final SelenideElement
            title = $(".page-title"),
            dashboard = $(".block-dashboard-info"),
            messageSuccess = $(".message-success"),
            welcomeMessage = $(".page-header .welcome");
    private final ElementsCollection
            accountHeaderDropdownList = $$(".header .header.links .header.links li");

    public MyAccountPage verifySuccessMessage() {
        messageSuccess.shouldHave(text(MESSAGE_SUCCESS));
        return this;
    }

    public MyAccountPage verifyPageTitle() {
        title.shouldHave(text(TITLE));
        return this;
    }

    public MyAccountPage verifyContactInfo(String value, String email) {
        dashboard.shouldHave(text(value +" " + email));
        return this;
    }

    public MyAccountPage verifyWelcomeHeader(String value) {
        welcomeMessage.shouldHave(text(value));
        return this;
    }

    public MyAccountPage verifyAccountDropdownLinks() {
        accountHeaderDropdownList.shouldHave(texts("My Account", "My Wish List", "Sign Out"));
        return this;
    }
}
