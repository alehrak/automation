import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;

public class CarMarketPage extends BasePage {
    private static final String OPEN_CAR_MARKET_MENU =
            "//span[@class='b-main-navigation__text' and text()='Автобарахолка']";
    private static final String XPATH_CHECK_EXISTING_DROP_DOWN_MENU =
            "//div[@class='b-main-navigation__dropdown-column b-main-navigation__dropdown-column_75']";
    private static final String XPATH_GETTING_ITEMS_CAR_MARKET_MENU =
            "//ul[@class='b-main-navigation__dropdown-advert-list']";

    @Override
    public void openPage() {
        Selenide.$x(OPEN_CAR_MARKET_MENU).hover();
    }

    public boolean checkExistingDropDownMenu() {
        openPage();
        return Selenide.$x(XPATH_CHECK_EXISTING_DROP_DOWN_MENU)
                .shouldBe(Condition.visible)
                .isDisplayed();
    }

    public ElementsCollection getElementsDropDownMenu() {
        openPage();
        return Selenide.$$x(XPATH_CHECK_EXISTING_DROP_DOWN_MENU + XPATH_GETTING_ITEMS_CAR_MARKET_MENU);
    }
}
