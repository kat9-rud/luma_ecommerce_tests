package pages.components;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class Header {
    private final SelenideElement logo = $(".logo"),
            searchBar = $("#search"),
            headerCart = $("[data-block = 'minicart'] a"),
            mainMenuNavigation = $(".navigation"),
    proceedToCheckoutButton = $("#top-cart-btn-checkout"),
    customerMenuDropdown = $(".page-header .customer-welcome button"),
    signOut = $(".page-header .customer-menu .authorization-link a");

    private final ElementsCollection authorizationLinks = $$(".header .links a"),
            mainMenuNavigationList = $$(
            ".navigation > ul > li");

    public void verifyLogo() {
        logo.shouldBe(visible);
    }

    public void verifyAuthorizationLinks() {
        authorizationLinks.shouldHave(texts("Sign In", "Create an Account"));
    }

    public void verifySearchBar() {
        searchBar.shouldBe(visible);
    }

    public void verifyCart() {
        headerCart.shouldBe(visible);
    }

    public void verifyCartQuantity(Integer value) {
        headerCart.shouldHave(text(value.toString()));
    }

    public void verifyMainMenuNavigation() {
        mainMenuNavigation.shouldBe(visible);
        mainMenuNavigationList.shouldHave(size(6));
        mainMenuNavigationList
                .shouldHave(texts("What's New", "Women", "Men", "Gear", "Training", "Sale"));
    }

    public void clickCreateAnAccountLink() {
        authorizationLinks.findBy(text("Create an Account")).click();
    }

    public void clickSignInLink() {
        authorizationLinks.findBy(text("Sign In")).click();
    }

    public void clickCart() {
        headerCart.click();
    }

    public void clickProceedToCheckoutButton() {
        proceedToCheckoutButton.click();
    }

    public void clickSignOut() {
        customerMenuDropdown.click();
        signOut.click();
    }

    public void search(String searchInput) {
        searchBar.setValue(searchInput).submit();
    }
}
