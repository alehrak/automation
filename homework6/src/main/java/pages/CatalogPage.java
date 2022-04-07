package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import java.util.List;
import java.util.stream.Collectors;

public class CatalogPage extends BasePage {
    private static final String XPATH_OPEN_CATALOG_ONLINER =
            "//span[@class='b-main-navigation__text'][text()='Каталог']";
    private static final String CSS_SELECTOR_SEARCH_FOR_CATALOG_ITEMS =
            ".catalog-navigation-classifier__item-title-wrapper";

    public CatalogPage() {
    }

    @Override
    public void openPage() {
        super.openMainPageOnliner();
        Selenide.$x(XPATH_OPEN_CATALOG_ONLINER).click();
    }

    public List<String> getSectionsCatalog() {
        ElementsCollection catalogSections = Selenide.$$(CSS_SELECTOR_SEARCH_FOR_CATALOG_ITEMS);
        return catalogSections.stream()
                .map(SelenideElement::getText)
                .collect(Collectors.toList());
    }
}
