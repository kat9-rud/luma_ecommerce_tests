package tests;

import data.TestData;
import org.junit.jupiter.api.Test;

public class RegistrationPageTests extends TestBase {
    final TestData data = new TestData();

    @Test
    public void newCustomerAccountIsSuccessfullyCreatedTest() {
        homePage.openPage()
                .clickCreateAnAccountLink();

        registrationPage.setFirstName(data.firstName)
                .setLastName(data.lastName)
                .setEmail(data.email)
                .setPassword(data.password)
                .confirmPassword(data.password)
                .submit();

        myAccountPage.verifySuccessMessage()
                .verifyPageTitle()
                .verifyContactInfo(data.firstName + " " + data.lastName, data.email)
                .verifyWelcomeHeader(data.firstName + " " + data.lastName)
                .verifyAccountDropdownLinks();
    }
}
