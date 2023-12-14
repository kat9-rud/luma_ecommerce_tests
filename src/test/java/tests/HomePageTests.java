package tests;

import org.junit.jupiter.api.Test;

public class HomePageTests extends TestBase {
    @Test
    public void homePageIsSuccessfullyDisplayedTest() {
        homePage.openPage()
                .verifyHeader()
                .verifyContent()
                .verifyFooter();
    }
}
