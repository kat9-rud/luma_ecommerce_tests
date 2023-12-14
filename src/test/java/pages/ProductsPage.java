package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class ProductsPage extends BasePage {
    private final SelenideElement productFirst = $(".products .list li:nth-child(1)"),
    sizeFirst = $(".products .list li:nth-child(1) .size " + ".swatch-option:nth" +
            "-child(2)"),
            addToCartButton = $(".products .list li:nth-child(1) button"),
            colorFirst = $(".products .list li:nth-child(1) .color .color:nth-child(2)"),
            pageTitle = $("#page-title-heading");


    public void addFirstProductToTheCart() {
        productFirst.hover();
        sizeFirst.click();
        colorFirst.click();
        addToCartButton.click();
        addToCartButton.shouldHave(text("Added"));
        header.verifyCartQuantity(1);
    }

    public void checkout() {
        header.clickCart();
        header.clickProceedToCheckoutButton();
    }

    public void verifyPageTitle(String value) {
        pageTitle.shouldHave(text(value));
    }
}
