import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;

public class HouseAndFlatPage extends BasePage {

    private static final String XPATH_OPEN_MENU_HOUSE_AND_FLAT =
            "//span[@class='b-main-navigation__text'and text()='Дома и квартиры']";
    private static final String XPATH_CHECK_EXISTING_DROP_DOWN_MENU =
            "//div[@class='b-main-navigation__dropdown-column b-main-navigation__dropdown-column_50'][1]";
    private static final String XPATH_GETTING_ITEMS_CAR_MARKET_MENU =
            "//div[@class='b-main-navigation__dropdown-column']";

    @Override
    public void openPage() {
        Selenide.$x(XPATH_OPEN_MENU_HOUSE_AND_FLAT).hover();
    }

    public boolean checkExistingDropDownMenu() {
        openPage();
        return Selenide.$x(XPATH_CHECK_EXISTING_DROP_DOWN_MENU)
                .shouldBe(Condition.visible).isDisplayed();
    }

    public ElementsCollection getElementsDropDownMenu() {
        openPage();
        return Selenide.$$x(XPATH_CHECK_EXISTING_DROP_DOWN_MENU + XPATH_GETTING_ITEMS_CAR_MARKET_MENU);
    }
}