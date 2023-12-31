package tests;

import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class HomePageTests extends TestBase {
    @Test
    public void homePageIsSuccessfullyDisplayedTest() {
        step("Open home page", () -> {
            homePage.openPage();
        });
        step("Verify that a header has authorization links, a search bar," +
                " a shopping cart, and a navigation menu", () -> {
            homePage.verifyHeader();
        });

        step("Verify that a promo block and a product block are visible on the page", () -> {
            homePage.verifyContent();
        });

        step("Verify that a footer is visible and has all the links", () -> {
            homePage.verifyFooter();
        });
    }
}
