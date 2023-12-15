package tests;

import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class SearchTests extends TestBase {
    @Test
    public void customerCanSuccessfullySearchForAProductTest() {
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
