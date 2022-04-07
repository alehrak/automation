package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;

public class AccessoriesPage extends BasePage {
    private static final String XPATH_OPEN_SECTION_ACCESSORIES =
            "//div[@class='catalog-navigation-list__aside-title' and text()=' Комплектующие ']";
    private static final String XPATH_GETTING_ACCESSORIES =
            "//div[@class='catalog-navigation-list__aside-item catalog-navigation-list__aside-item_active']" +
                    "//a[@class='catalog-navigation-list__dropdown-item']";
    private final ComputersAndNetworksPage computersAndNetworksPage = new ComputersAndNetworksPage();

    public AccessoriesPage() {
    }

    @Override
    public void openPage() {
        computersAndNetworksPage.openPage();
        Selenide.$x(XPATH_OPEN_SECTION_ACCESSORIES).hover();
    }

    public ElementsCollection getListAccessories() {
        return Selenide.$$x(XPATH_GETTING_ACCESSORIES);
    }
}

