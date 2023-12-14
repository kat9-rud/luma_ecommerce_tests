package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import data.MenuItemConstants;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class NavigationTests extends TestBase {

    @Test
    public void userCanSuccessfullyNavigateThroughCategories() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        step("Open home page and select 'What's New' category from the navigation menu, and verify that 'What's New' " +
                        "page is opened",
                () -> {
            homePage.openPage()
                    .selectMenuItem(MenuItemConstants.WHATS_NEW);

            productsPage.verifyPageTitle(MenuItemConstants.WHATS_NEW);
        });

        step("Select 'Women' category, and verify that 'Women' page is opened", () -> {
            productsPage.selectMenuItem(MenuItemConstants.WOMEN);
            productsPage.verifyPageTitle(MenuItemConstants.WOMEN);
        });

        step("Select 'Women-Tops' category, and verify that 'Women Tops' page is opened",
                () -> {
            productsPage.selectMenuItem(MenuItemConstants.WOMEN, MenuItemConstants.WOMEN_TOPS);
            productsPage.verifyPageTitle(MenuItemConstants.WOMEN_TOPS);
        });

        step("Select 'Women-Bottoms' category, and verify that 'Women Bottoms' page is opened",
                () -> {
            productsPage.selectMenuItem(MenuItemConstants.WOMEN, MenuItemConstants.WOMEN_BOTTOMS);
            productsPage.verifyPageTitle(MenuItemConstants.WOMEN_BOTTOMS);
        });

        step("Go to 'Women-Tops' category and click through all the sub-categories, and verify " +
                "that all the proper pages are opened", () -> {
            productsPage.selectMenuItem(MenuItemConstants.WOMEN, MenuItemConstants.WOMEN_JACKETS);
            productsPage.verifyPageTitle(MenuItemConstants.WOMEN_JACKETS);
            productsPage.selectMenuItem(MenuItemConstants.WOMEN, MenuItemConstants.WOMEN_HOODIES_AND_SWEATSHIRTS);
            productsPage.verifyPageTitle(MenuItemConstants.WOMEN_HOODIES_AND_SWEATSHIRTS);
            productsPage.selectMenuItem(MenuItemConstants.WOMEN, MenuItemConstants.WOMEN_TEES);
            productsPage.verifyPageTitle(MenuItemConstants.WOMEN_TEES);
            productsPage.selectMenuItem(MenuItemConstants.WOMEN, MenuItemConstants.WOMEN_BRAS_AND_TANKS);
            productsPage.verifyPageTitle(MenuItemConstants.WOMEN_BRAS_AND_TANKS);
        });

        step("Go to 'Women-Bottoms' category and click through all the sub-categories, and verify that all the proper" +
                " pages are opened.", () -> {
            productsPage.selectMenuItem(MenuItemConstants.WOMEN, MenuItemConstants.WOMEN_PANTS);
            productsPage.verifyPageTitle(MenuItemConstants.WOMEN_PANTS);
            productsPage.selectMenuItem(MenuItemConstants.WOMEN, MenuItemConstants.WOMEN_SHORTS);
            productsPage.verifyPageTitle(MenuItemConstants.WOMEN_SHORTS);
        });

        step("Select 'Men' category, and verify that 'Men' page is opened", () -> {
            productsPage.selectMenuItem(MenuItemConstants.MEN);
            productsPage.verifyPageTitle(MenuItemConstants.MEN);
        });

        step("Select 'Men-Tops' category, and verify that 'Men Tops' page is opened", () -> {
            productsPage.selectMenuItem(MenuItemConstants.MEN, MenuItemConstants.MEN_TOPS);
            productsPage.verifyPageTitle(MenuItemConstants.MEN_TOPS);
        });

        step("Select 'Men-Bottoms' category, and verify that 'Men Bottoms' page is opened", () -> {
            productsPage.selectMenuItem(MenuItemConstants.MEN, MenuItemConstants.MEN_BOTTOMS);
            productsPage.verifyPageTitle(MenuItemConstants.MEN_BOTTOMS);
        });

        step("Go to 'Men-Tops' category and click through all the sub-categories, and verify that all the proper " +
                "pages are opened", () -> {
            productsPage.selectMenuItem(MenuItemConstants.MEN, MenuItemConstants.MEN_JACKETS);
            productsPage.verifyPageTitle(MenuItemConstants.MEN_JACKETS);
            productsPage.selectMenuItem(MenuItemConstants.MEN, MenuItemConstants.MEN_HOODIES_AND_SWEATSHIRTS);
            productsPage.verifyPageTitle(MenuItemConstants.MEN_HOODIES_AND_SWEATSHIRTS);
            productsPage.selectMenuItem(MenuItemConstants.MEN, MenuItemConstants.MEN_TEES);
            productsPage.verifyPageTitle(MenuItemConstants.MEN_TEES);
            productsPage.selectMenuItem(MenuItemConstants.MEN, MenuItemConstants.MEN_TANKS);
            productsPage.verifyPageTitle(MenuItemConstants.MEN_TANKS);
        });

        step("Go to 'Men-Bottoms' category and click through all the sub-categories, and verify that all the proper " +
                "pages are opened", () -> {
            productsPage.selectMenuItem(MenuItemConstants.MEN, MenuItemConstants.MEN_PANTS);
            productsPage.verifyPageTitle(MenuItemConstants.MEN_PANTS);
            productsPage.selectMenuItem(MenuItemConstants.MEN, MenuItemConstants.MEN_SHORTS);
            productsPage.verifyPageTitle(MenuItemConstants.MEN_SHORTS);
        });

        step("Select 'Gear' category, and verify that 'Gear' page is opened", () -> {
            productsPage.selectMenuItem(MenuItemConstants.GEAR);
            productsPage.verifyPageTitle(MenuItemConstants.GEAR);
        });

        step("Go to 'Gear' category and click through all the sub-categories, and verify that all the proper pages " +
                "are opened", () -> {
            productsPage.selectMenuItem(MenuItemConstants.GEAR, MenuItemConstants.GEAR_BAGS);
            productsPage.verifyPageTitle(MenuItemConstants.GEAR_BAGS);
            productsPage.selectMenuItem(MenuItemConstants.GEAR, MenuItemConstants.GEAR_FITNESS_EQUIPMENT);
            productsPage.verifyPageTitle(MenuItemConstants.GEAR_FITNESS_EQUIPMENT);
            productsPage.selectMenuItem(MenuItemConstants.GEAR, MenuItemConstants.GEAR_WATCHES);
            productsPage.verifyPageTitle(MenuItemConstants.GEAR_WATCHES);
        });

        step("Select 'Training' category, and verify that 'Training' page is opened", () -> {
            productsPage.selectMenuItem(MenuItemConstants.TRAINING);
            productsPage.verifyPageTitle(MenuItemConstants.TRAINING);
        });

        step("Go to 'Training' category and select its sub-category, verify that 'Training Video' page is opened",
                () -> {
            productsPage.selectMenuItem(MenuItemConstants.TRAINING, MenuItemConstants.TRAINING_VIDEO);
            productsPage.verifyPageTitle(MenuItemConstants.TRAINING_VIDEO);
        });

        step("Select 'Sale' category, and verify that 'Sale' page is opened", () -> {
            productsPage.selectMenuItem(MenuItemConstants.SALE);
            productsPage.verifyPageTitle(MenuItemConstants.SALE);
        });
    }
}
