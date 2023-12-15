package tests;

import data.TestData;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class RegistrationPageTests extends TestBase {
    final TestData data = new TestData();

    @Test
    public void newCustomerAccountIsSuccessfullyCreatedTest() {
        step("Open home page and click 'Create An Account' link", () -> {
            homePage.openPage()
                    .clickCreateAnAccountLink();
        });

        step("Fill in a form on 'Registration' page and submit it", () -> {
            registrationPage.setFirstName(data.firstName)
                    .setLastName(data.lastName)
                    .setEmail(data.email)
                    .setPassword(data.password)
                    .confirmPassword(data.password)
                    .submit();
        });

        step("Verify that there is a successful message on 'My Account' page and there are a dashboard visible" +
                        " displaying the correct user info, a welcome header containing the user first and last name," +
                        "and there are three links within an account dropdown list displayed",
                () -> {
            myAccountPage.verifySuccessMessage()
                    .verifyPageTitle()
                    .verifyContactInfo(data.firstName + " " + data.lastName, data.email)
                    .verifyWelcomeHeader(data.firstName + " " + data.lastName)
                    .verifyAccountDropdownLinks();

        });
    }
}
