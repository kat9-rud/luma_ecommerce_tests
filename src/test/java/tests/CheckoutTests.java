package tests;

import data.TestData;
import helpers.AdsUtils;
import org.junit.jupiter.api.Test;

public class CheckoutTests extends TestBase {
    @Test
    public void guestUserCanSuccessfullyCheckout() {
    TestData data = new TestData();

    homePage.openPage().selectMenuItem("Women", "Tees");
        AdsUtils.removeAds();


    productsPage.addFirstProductToTheCart();
    productsPage.checkout();

    checkoutPage.setEmail(data.email)
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
        .clickPlaceOrderButton()
        .verifyCheckoutResult();
    }
}
