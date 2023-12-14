package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class HomePage extends BasePage {
    private final SelenideElement blockPromo = $(".blocks-promo"),
            content = $(".products-grid"),
            footer = $(".page-footer .content");
    private final ElementsCollection footerList = $$(".page-footer .content li");

    public HomePage openPage() {
        open("https://magento.softwaretestingboard.com");
        header.verifyLogo();

        return this;
    }

    public HomePage verifyHeader() {
       header.verifyAuthorizationLinks();
       header.verifySearchBar();
       header.verifyCart();

        header.verifyMainMenuNavigation();

        return this;
    }
    public HomePage verifyContent() {
        blockPromo.shouldBe(visible);
        content.shouldBe(visible);

        return this;
    }

    public HomePage verifyFooter() {
        footer.shouldBe(visible);

        footerList.shouldHave(size(8));
        footerList
                .shouldHave(texts("Write for us", "Subscribe to our mailing list", "Contact us", "Hire a Sofware Testing/QA Company", "Search Terms", "Privacy and Cookie Policy", "Advanced Search", "Orders and Returns"));

        return this;
    }

    public void clickCreateAnAccountLink() {
        header.clickCreateAnAccountLink();
    }

    public void clickSignInLink() {
        header.clickSignInLink();
    }
}
