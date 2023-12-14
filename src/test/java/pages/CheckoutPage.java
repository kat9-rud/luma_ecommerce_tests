package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class CheckoutPage extends BasePage {
    private final String SUCCESSFUL_CHECKOUT_TITLE = "Thank you for your purchase!";
    private final SelenideElement
            email = $("#checkout-step-shipping #customer-email"),
            firstName = $("[name='firstname']"),
            lastName = $("[name='lastname']"),
            streetAddress = $("[name='street[0]']"),
            city = $("[name='city']"),
            state = $("[name='region_id']"),
            zip = $("[name='postcode']"),
            country = $("[name='country_id']"),
            phoneNumber = $("[name='telephone']"),
            nextButton = $("#shipping-method-buttons-container button"),
            placeOrderButton = $(".payment-method button[type='submit']"),
            resultPageTitle = $("[data-ui-id='page-title-wrapper']"),
            shippingMethod = $("#checkout-shipping-method-load tbody tr:nth-child(1)");


    public CheckoutPage setEmail(String value) {
        email.setValue(value);
        return this;
    }
    public CheckoutPage setFirstName(String value) {
        firstName.setValue(value);
        return this;
    }

    public CheckoutPage setLastName(String value) {
        lastName.setValue(value);
        return this;
    }
    public CheckoutPage setStreetAddress(String value) {
        streetAddress.setValue(value);
        return this;
    }

    public CheckoutPage setCity(String value) {
        city.setValue(value);
        return this;
    }

    public CheckoutPage setState(String value) {
        state.selectOption(value);
        return this;
    }

    public CheckoutPage setZip(String value) {
        zip.setValue(value);
        return this;
    }

    public CheckoutPage setCountry(String value) {
        country.selectOption(value);
        return this;
    }

    public CheckoutPage setPhoneNumber(String value) {
        phoneNumber.setValue(value);
        return this;
    }

    public CheckoutPage selectShippingMethod() {
        shippingMethod.click();
        return this;
    }

    public CheckoutPage clickNextButton() {
        nextButton.click();
        return this;
    }

    public CheckoutPage clickPlaceOrderButton() {
        placeOrderButton.click();
        return this;
    }

    public void verifyCheckoutResult() {
        resultPageTitle.shouldHave(text(SUCCESSFUL_CHECKOUT_TITLE));
    }
}
