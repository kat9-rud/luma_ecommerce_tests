package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SearchResultsPage extends BasePage {
    private final SelenideElement pageTitle = $("h1.page-title");
    private final ElementsCollection productsList = $$(".main div.search .product-items li");

    public void verifySearchResults(String searchInput) {
        pageTitle.shouldHave(text(searchInput));

        String text = productsList.first().find(".details a").getText();
        String[] searchWords = searchInput.toLowerCase().split("\\s+");
        String[] tmpWords = text.toLowerCase().split("\\s+");

        Set<String> searchSet = new HashSet<>(Arrays.asList(searchWords));
        Set<String> tmpSet = new HashSet<> (Arrays.asList(tmpWords));

        boolean haveCommonWord = !Collections.disjoint(searchSet, tmpSet);
        Assertions.assertTrue(haveCommonWord);
    }
}
