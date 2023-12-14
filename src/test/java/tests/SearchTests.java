package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class SearchTests extends TestBase {
    @Test
    public void customerCanSuccessfullySearchForAProductTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        String searchInput = "yellow tank";
        step("Open home page and search for a product using a search bar", () -> {
            homePage.openPage()
                    .search(searchInput);
        });

        step("Verify that on 'Search Results' page there is a first found product that matched the search",
                () -> {
            searchResultsPage.verifySearchResults(searchInput);
        });
    }
}
