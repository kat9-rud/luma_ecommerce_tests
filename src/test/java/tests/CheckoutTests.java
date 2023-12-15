package tests;

import data.TestData;
import helpers.AdsUtils;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class CheckoutTests extends TestBase {
    @Test
    public void guestUserCanSuccessfullyCheckout() {
    TestData data = new TestData();

    step("Open home page and select 'women tees' category from the menu navigation", () -> {
        homePage
                .openPage()
                .selectMenuItem("Women", "Tees");
        AdsUtils.removeAds();
    });

    step("Add a first product in first available size and color to the shopping cart", () -> {
        productsPage.addFirstProductToTheCart();
    });

    step("Proceed to checkout", () -> {
        productsPage.checkout();
    });

    step("Fill in the 'Shipping Address' and 'Payments' forms and submit the order", () -> {
        checkoutPage
                .setEmail(data.email)
                .setFirstName(data.firstName)
                .setLastName(data.lastName)
                .setStreetAddress(data.streetAddress)
                .setCity(data.city)
                .setState(data.state)
                .setZip(data.zip)
                .setCountry(data.country)
                .setPhoneNumber(data.phoneNumber)
                .selectShippingMethod()
                .clickNextButton()
                .clickPlaceOrderButton();
    });

    step("Verify that a successful purchase message is displayed", () -> {
        checkoutPage.verifyCheckoutResult();
    });
    }
}
