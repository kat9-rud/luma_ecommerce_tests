package tests;

import data.TestData;
import helpers.AdsUtils;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class LoginTests extends TestBase {
    final TestData data = new TestData();

    @Test
    public void newUserCanSuccessfullyLoginTest() {
        step("Open home page and click 'Create An Account' link", () -> {
            homePage.openPage()
                    .clickCreateAnAccountLink();
            AdsUtils.removeAds();
        });

        step("Fill in a form on the 'Registration' page and submit it", () -> {
            registrationPage
                    .setFirstName(data.firstName)
                    .setLastName(data.lastName)
                    .setEmail(data.email)
                    .setPassword(data.password)
                    .confirmPassword(data.password)
                    .submit();
        });


        step("Sign out on 'My Account' page", () -> {
            myAccountPage.clickSignOut();
        });

        step("Click 'Sign In' link", () -> {
            homePage.clickSignInLink();
        });

        step("On 'Login' page fill in an email and a password and click 'Sign In' button", () -> {
            loginPage.setEmail(data.email)
                    .setPassword(data.password)
                    .signIn();
        });

        step("Verify that 'My Account' page is opened", () -> {
            myAccountPage.verifyPageTitle();
        });
    }

    @Test
    public void userCanSuccessfullyRecoverHisPasswordTest() {
        step("Open home page and click 'Sign In' link", () -> {
            homePage.openPage()
                    .clickSignInLink();
        });

        step("On 'Login' page click 'Forgot Your Password' link", () -> {
            AdsUtils.removeAds();
            loginPage.clickForgotYourPassword();
        });

        step("On 'Forgot Password' page fill in an email and click 'Reset My Password' button", () -> {
            AdsUtils.removeAds();

            forgotPasswordPage.setEmail(data.email)
                    .clickResetMyPassword();
        });

        step("Verify that there is a successful message containing the email is displayed", () -> {
            loginPage.verifySuccessMessage(data.email);
        });
    }
}
