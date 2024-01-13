package tests;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.WebDriverProvider;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import pages.*;

public class TestBase {
    final HomePage homePage = new HomePage();
    final RegistrationPage registrationPage = new RegistrationPage();
    final MyAccountPage myAccountPage = new MyAccountPage();
    final ProductsPage productsPage = new ProductsPage();
    final CheckoutPage checkoutPage = new CheckoutPage();
    final LoginPage loginPage = new LoginPage();
    final ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage();
    final SearchResultsPage searchResultsPage = new SearchResultsPage();

    @BeforeAll
    static void beforeAll() {
        WebDriverProvider provider = new WebDriverProvider();
    }

    @BeforeEach
    void beforeEach() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        Selenide.closeWebDriver();
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}
