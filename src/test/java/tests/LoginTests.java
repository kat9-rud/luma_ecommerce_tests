package tests;

import data.TestData;
import helpers.AdsUtils;
import org.junit.jupiter.api.Test;

public class LoginTests extends TestBase {
    final TestData data = new TestData();

    @Test
    public void newUserCanSuccessfullyLoginTest() {
        homePage.openPage()
                .clickCreateAnAccountLink();

        AdsUtils.removeAds();
        registrationPage
                .setFirstName(data.firstName)
                .setLastName(data.lastName)
                .setEmail(data.email)
                .setPassword(data.password)
                .confirmPassword(data.password)
                .submit();

        myAccountPage.clickSignOut();

        homePage.clickSignInLink();

        loginPage.setEmail(data.email)
        .setPassword(data.password)
        .signIn();

        myAccountPage.verifyPageTitle();
    }

    @Test
    public void userCanSuccessfullyRecoverHisPasswordTest() {
        homePage.openPage()
                .clickSignInLink();
        AdsUtils.removeAds();
        loginPage.clickForgotYourPassword();

        AdsUtils.removeAds();

        forgotPasswordPage.setEmail(data.email)
                .clickResetMyPassword();

        loginPage.verifySuccessMessage(data.email);
    }
}
