package pages.components;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import data.MenuItemConstants;

import java.util.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$$;

public class MenuNavigation {
    class MenuItem {
        private final String name;
        private final List<MenuItem> subCategories;

        public MenuItem(String name) {
            this.name = name;
            this.subCategories = new ArrayList<>();
        }

        public String getName() {
            return name;
        }

        public List<MenuItem> getSubCategories() {
            return subCategories;
        }

        public void addSubCategory(MenuItem subCategory) {
            subCategories.add(subCategory);
        }
    }

    class Menu {
        private final List<MenuItem> topCategories;

        public Menu() {
            this.topCategories = new ArrayList<>();
            initializeMenu();
        }

        private void initializeMenu() {
            MenuItem whatsNew = new MenuItem(MenuItemConstants.WHATS_NEW);
            MenuItem women = new MenuItem(MenuItemConstants.WOMEN);
            MenuItem men = new MenuItem(MenuItemConstants.MEN);
            MenuItem gear = new MenuItem(MenuItemConstants.GEAR);
            MenuItem training = new MenuItem(MenuItemConstants.TRAINING);
            MenuItem sale = new MenuItem(MenuItemConstants.SALE);

            MenuItem womenTops = new MenuItem(MenuItemConstants.WOMEN_TOPS);
            MenuItem womenBottoms = new MenuItem(MenuItemConstants.WOMEN_BOTTOMS);
            women.addSubCategory(womenTops);
            women.addSubCategory(womenBottoms);

            MenuItem menTops = new MenuItem(MenuItemConstants.MEN_TOPS);
            MenuItem menBottoms = new MenuItem(MenuItemConstants.MEN_BOTTOMS);
            men.addSubCategory(menTops);
            men.addSubCategory(menBottoms);

            MenuItem womenJackets = new MenuItem(MenuItemConstants.WOMEN_JACKETS);
            MenuItem womenHoodiesAndSweatshirts = new MenuItem(MenuItemConstants.WOMEN_HOODIES_AND_SWEATSHIRTS);
            MenuItem womenTees = new MenuItem(MenuItemConstants.WOMEN_TEES);
            MenuItem womenBrasAndTanks = new MenuItem(MenuItemConstants.WOMEN_BRAS_AND_TANKS);

            womenTops.addSubCategory(womenJackets);
            womenTops.addSubCategory(womenHoodiesAndSweatshirts);
            womenTops.addSubCategory(womenTees);
            womenTops.addSubCategory(womenBrasAndTanks);

            MenuItem womenPants = new MenuItem(MenuItemConstants.WOMEN_PANTS);
            MenuItem womenShorts = new MenuItem(MenuItemConstants.WOMEN_SHORTS);

            womenBottoms.addSubCategory(womenPants);
            womenBottoms.addSubCategory(womenShorts);

            MenuItem menJackets = new MenuItem(MenuItemConstants.MEN_JACKETS);
            MenuItem menHoodiesAndSweatshirts = new MenuItem(MenuItemConstants.MEN_HOODIES_AND_SWEATSHIRTS);
            MenuItem menTees = new MenuItem(MenuItemConstants.MEN_TEES);
            MenuItem menTanks = new MenuItem(MenuItemConstants.MEN_TANKS);

            menTops.addSubCategory(menJackets);
            menTops.addSubCategory(menHoodiesAndSweatshirts);
            menTops.addSubCategory(menTees);
            menTops.addSubCategory(menTanks);

            MenuItem menPants = new MenuItem(MenuItemConstants.MEN_PANTS);
            MenuItem menShorts = new MenuItem(MenuItemConstants.MEN_SHORTS);

            menBottoms.addSubCategory(menPants);
            menBottoms.addSubCategory(menShorts);

            MenuItem bags = new MenuItem(MenuItemConstants.GEAR_BAGS);
            MenuItem fitnessEquipment = new MenuItem(MenuItemConstants.GEAR_FITNESS_EQUIPMENT);
            MenuItem watches = new MenuItem(MenuItemConstants.GEAR_WATCHES);

            gear.addSubCategory(bags);
            gear.addSubCategory(fitnessEquipment);
            gear.addSubCategory(watches);

            MenuItem video = new MenuItem(MenuItemConstants.TRAINING_VIDEO);
            training.addSubCategory(video);

            topCategories.add(whatsNew);
            topCategories.add(women);
            topCategories.add(men);
            topCategories.add(gear);
            topCategories.add(training);
            topCategories.add(sale);
        }

        public List<MenuItem> getTopCategories() {
            return topCategories;
        }

        public MenuItem getTopCategoryByName(String categoryName) {
            return topCategories.stream().filter(category -> category.getName().equalsIgnoreCase(categoryName)).findFirst().orElse(null);
        }

        public Map<String, MenuItem> getSubSubCategoryWithParentByName(MenuItem topCategory, String subSubCategoryName) {
            Map<String, MenuItem> result = new HashMap<>();

            // Search within the top category
            Optional<MenuItem> subSubCategory = topCategory.getSubCategories().stream().filter(subCategory -> subCategory.getName().equalsIgnoreCase(subSubCategoryName)).findFirst();

            subSubCategory.ifPresent(subCategory -> result.put(topCategory.getName(), subCategory));

            // If not found, recursively search within sub-categories
            if (subSubCategory.isEmpty()) {
                topCategory.getSubCategories().forEach(subCategory -> {
                    Map<String, MenuItem> subSubCategories = getSubSubCategoryWithParentByName(subCategory, subSubCategoryName);
                    result.putAll(subSubCategories);
                });
            }

            return result;
        }
    }

        private final ElementsCollection topCategoryMenuItems = $$(".navigation > ul > li");

        public void selectMenuItem(String category, String subCategory) {
            Menu menu = new Menu();
            Map<String, MenuItem> result;

            MenuItem topCategory = menu.getTopCategoryByName(category);
            SelenideElement topElement = topCategoryMenuItems.findBy(textCaseSensitive(topCategory.getName()));

            if (subCategory.isEmpty()) {
                topElement.click();
            } else {
                result = menu.getSubSubCategoryWithParentByName(topCategory, subCategory);

                topElement.hover();

                for (Map.Entry<String, MenuItem> entry : result.entrySet()) {
                    String parentSubCategory = entry.getKey();
                    MenuItem subSubCategory = entry.getValue();

                    if (!topCategory.getName().equals(parentSubCategory)) {
                        topElement.$(byText(parentSubCategory)).hover();
                    }

                    //(topElement.find(byText(subSubCategory.getName()))).hover();
                    topElement.find(byText(subSubCategory.getName())).click();
                    //topElement.$(byTitle(subSubCategory.getName())).click();

                    break;
                }
            }
        }
    }
