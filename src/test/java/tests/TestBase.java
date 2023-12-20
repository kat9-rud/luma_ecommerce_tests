package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.*;

import java.util.Map;

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
        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.browserSize = System.getProperty("resolution", "1920x1080");

        Configuration.browserVersion = System.getProperty("browser_version", "100.0");
        String login = System.getProperty("remote_login", "");
        String pass = System.getProperty("remote_pass", "");
        String remote = System.getProperty("remote", "");

        Configuration.remote =  remote.replace("//", "//" + login + ":" + pass + "@") + "/wd/hub";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));

        Configuration.browserCapabilities = capabilities;
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
