package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import java.util.List;
import java.util.stream.Collectors;

public class MobileCatalogPage{
    public static final String XPATH_OPEN_MENU = "//a[@class='header-style__underlay']";
    private static final String XPATH_OPEN_CATALOG_ONLINER ="//li[@class='header-style__item']//a[@href='https://catalog.onliner.by']";
    private static final String CSS_SELECTOR_SEARCH_FOR_CATALOG_ITEMS =
            ".catalog-navigation-classifier__item-title-wrapper";

    public MobileCatalogPage() {
    }

    public void openMenu(){
        Selenide.open("https://www.onliner.by");
        Selenide.$x(XPATH_OPEN_MENU).click();
    }

    public void openPage() {
        openMenu();
        Selenide.$x(XPATH_OPEN_CATALOG_ONLINER).click();
    }

    public List<String> getSectionsCatalog() {
        ElementsCollection catalogSections = Selenide.$$(CSS_SELECTOR_SEARCH_FOR_CATALOG_ITEMS);
        return catalogSections.stream()
                .map(SelenideElement::getText)
                .collect(Collectors.toList());
    }
}
