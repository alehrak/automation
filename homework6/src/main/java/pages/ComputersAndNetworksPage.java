package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import java.util.List;
import java.util.stream.Collectors;

public class ComputersAndNetworksPage extends BasePage {
    private static final String OPEN_CATALOG_ONLINER =
            "//span[@class='b-main-navigation__text'][text()='Каталог']";
    private static final String OPEN_PAGE_COMPUTER_AND_NETWORKS =
            "//li[@class='catalog-navigation-classifier__item ']//span[contains(text(),'Компьютеры и\u00A0сети')]";
    private static final String PATH_CHECK_EXISTENCE_VERTICAL_LIST =
            "(//div[@class='catalog-navigation-list__wrapper']//div[@class='catalog-navigation-list__aside-list'])[2]";
    private static final String PATH_GETTING_SECTIONS_VERTICAL_LIST =
            "//div[@class='catalog-navigation-list__category' and (@data-id='2')]//div[@class='catalog-navigation-list__aside-title']";

    public ComputersAndNetworksPage() {
    }

    public void openCatalog() {
        super.openMainPageOnliner();
        Selenide.$x(OPEN_CATALOG_ONLINER).click();
    }

    @Override
    public void openPage() {
        openCatalog();
        Selenide.$x(OPEN_PAGE_COMPUTER_AND_NETWORKS).click();
    }

    public boolean checkListItemForExistence() {
        return Selenide.$x(PATH_CHECK_EXISTENCE_VERTICAL_LIST).hover().exists();
    }

    public List<String> getSectionComputersAndNetworks() {
        ElementsCollection elements = Selenide.$$x(PATH_GETTING_SECTIONS_VERTICAL_LIST);
        return elements.stream()
                .map(SelenideElement::getText)
                .collect(Collectors.toList());
    }
}
