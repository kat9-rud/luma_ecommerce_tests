package tests;

import org.junit.jupiter.api.Test;

public class SearchTests extends TestBase {
    @Test
    public void customerCanSuccessfullySearchForAProductTest() {
        String searchInput = "yellow tank";

        homePage.openPage()
                .search(searchInput);

        searchResultsPage.verifySearchResults(searchInput);
    }
}
