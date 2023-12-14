package tests;

import data.MenuItemConstants;
import org.junit.jupiter.api.Test;

public class NavigationTests extends TestBase {

    @Test
    public void userCanSuccessfullyNavigateThroughCategories() {
        homePage.openPage()
                .selectMenuItem(MenuItemConstants.WHATS_NEW);

        productsPage.verifyPageTitle(MenuItemConstants.WHATS_NEW);

        productsPage.selectMenuItem(MenuItemConstants.WOMEN);
        productsPage.verifyPageTitle(MenuItemConstants.WOMEN);

        productsPage.selectMenuItem(MenuItemConstants.WOMEN, MenuItemConstants.WOMEN_TOPS);
        productsPage.verifyPageTitle(MenuItemConstants.WOMEN_TOPS);

        productsPage.selectMenuItem(MenuItemConstants.WOMEN, MenuItemConstants.WOMEN_BOTTOMS);
        productsPage.verifyPageTitle(MenuItemConstants.WOMEN_BOTTOMS);

        productsPage.selectMenuItem(MenuItemConstants.WOMEN, MenuItemConstants.WOMEN_JACKETS);
        productsPage.verifyPageTitle(MenuItemConstants.WOMEN_JACKETS);
        productsPage.selectMenuItem(MenuItemConstants.WOMEN, MenuItemConstants.WOMEN_HOODIES_AND_SWEATSHIRTS);
        productsPage.verifyPageTitle(MenuItemConstants.WOMEN_HOODIES_AND_SWEATSHIRTS);
        productsPage.selectMenuItem(MenuItemConstants.WOMEN, MenuItemConstants.WOMEN_TEES);
        productsPage.verifyPageTitle(MenuItemConstants.WOMEN_TEES);
        productsPage.selectMenuItem(MenuItemConstants.WOMEN, MenuItemConstants.WOMEN_BRAS_AND_TANKS);
        productsPage.verifyPageTitle(MenuItemConstants.WOMEN_BRAS_AND_TANKS);
        productsPage.selectMenuItem(MenuItemConstants.WOMEN, MenuItemConstants.WOMEN_PANTS);
        productsPage.verifyPageTitle(MenuItemConstants.WOMEN_PANTS);
        productsPage.selectMenuItem(MenuItemConstants.WOMEN, MenuItemConstants.WOMEN_SHORTS);
        productsPage.verifyPageTitle(MenuItemConstants.WOMEN_SHORTS);

        productsPage.selectMenuItem(MenuItemConstants.MEN);
        productsPage.verifyPageTitle(MenuItemConstants.MEN);

        productsPage.selectMenuItem(MenuItemConstants.MEN, MenuItemConstants.MEN_TOPS);
        productsPage.verifyPageTitle(MenuItemConstants.MEN_TOPS);

        productsPage.selectMenuItem(MenuItemConstants.MEN, MenuItemConstants.MEN_BOTTOMS);
        productsPage.verifyPageTitle(MenuItemConstants.MEN_BOTTOMS);

        productsPage.selectMenuItem(MenuItemConstants.MEN, MenuItemConstants.MEN_JACKETS);
        productsPage.verifyPageTitle(MenuItemConstants.MEN_JACKETS);
        productsPage.selectMenuItem(MenuItemConstants.MEN, MenuItemConstants.MEN_HOODIES_AND_SWEATSHIRTS);
        productsPage.verifyPageTitle(MenuItemConstants.MEN_HOODIES_AND_SWEATSHIRTS);
        productsPage.selectMenuItem(MenuItemConstants.MEN, MenuItemConstants.MEN_TEES);
        productsPage.verifyPageTitle(MenuItemConstants.MEN_TEES);
        productsPage.selectMenuItem(MenuItemConstants.MEN, MenuItemConstants.MEN_TANKS);
        productsPage.verifyPageTitle(MenuItemConstants.MEN_TANKS);
        productsPage.selectMenuItem(MenuItemConstants.MEN, MenuItemConstants.MEN_PANTS);
        productsPage.verifyPageTitle(MenuItemConstants.MEN_PANTS);
        productsPage.selectMenuItem(MenuItemConstants.MEN, MenuItemConstants.MEN_SHORTS);
        productsPage.verifyPageTitle(MenuItemConstants.MEN_SHORTS);

        productsPage.selectMenuItem(MenuItemConstants.GEAR);
        productsPage.verifyPageTitle(MenuItemConstants.GEAR);

        productsPage.selectMenuItem(MenuItemConstants.GEAR, MenuItemConstants.GEAR_BAGS);
        productsPage.verifyPageTitle(MenuItemConstants.GEAR_BAGS);
        productsPage.selectMenuItem(MenuItemConstants.GEAR, MenuItemConstants.GEAR_FITNESS_EQUIPMENT);
        productsPage.verifyPageTitle(MenuItemConstants.GEAR_FITNESS_EQUIPMENT);
        productsPage.selectMenuItem(MenuItemConstants.GEAR, MenuItemConstants.GEAR_WATCHES);
        productsPage.verifyPageTitle(MenuItemConstants.GEAR_WATCHES);

        productsPage.selectMenuItem(MenuItemConstants.TRAINING);
        productsPage.verifyPageTitle(MenuItemConstants.TRAINING);

        productsPage.selectMenuItem(MenuItemConstants.TRAINING, MenuItemConstants.TRAINING_VIDEO);
        productsPage.verifyPageTitle(MenuItemConstants.TRAINING_VIDEO);

        productsPage.selectMenuItem(MenuItemConstants.SALE);
        productsPage.verifyPageTitle(MenuItemConstants.SALE);
    }
}
