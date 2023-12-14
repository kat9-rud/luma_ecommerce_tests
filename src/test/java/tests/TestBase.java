package tests;

import com.codeborne.selenide.Selenide;
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

    @BeforeEach
    public void beforeEach() {
        Selenide.closeWebDriver();
    }
}
