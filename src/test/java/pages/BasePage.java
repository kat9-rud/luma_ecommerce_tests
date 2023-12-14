package pages;

import pages.components.Header;
import pages.components.MenuNavigation;

public class BasePage {
    protected final Header header;
    protected final MenuNavigation menu;

    public BasePage() {
        this.header = new Header();
        this.menu = new MenuNavigation();
    }

    public void clickSignOut() {
        header.clickSignOut();
    }

    public void selectMenuItem(String category) {
        menu.selectMenuItem(category, "");
    }

    public void selectMenuItem(String category, String subCategory) {
        menu.selectMenuItem(category, subCategory);
    }

    public void search(String searchInput) {
        header.search(searchInput);
    }
}
