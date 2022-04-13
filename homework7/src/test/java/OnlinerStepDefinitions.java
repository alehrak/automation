import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.junit.Assert;

public class OnlinerStepDefinitions {
    private CarMarketPage carMarketPage = new CarMarketPage();
    private HouseAndFlatPage houseAndFlatPage = new HouseAndFlatPage();

    @Дано("открыта главная страница сайта онлайнер")
    public void openMainPageOnliner() {
        carMarketPage.openMainPageOnliner();
    }

    @Когда("пользователь наводит курсор на пункт \"Автобарахолка\"")
    public void openCarMarketMenu() {
        carMarketPage.openPage();
    }

    @Тогда("появляется выпадающее меню пункта \"Автобарахолка\"")
    public void checkExistingDropDownMenuCarMarketPage() {
        Assert.assertTrue(carMarketPage.checkExistingDropDownMenu());
    }

    @Тогда("появляется выпадающее меню с категориями - деление по ценам, по городам и марки, содержит {int} категории")
    public void getElementsDropDownMenuCarMarketPage(int countElement) {
        Assert.assertEquals(countElement, carMarketPage.getElementsDropDownMenu().size());
    }

    @Когда("пользователь наводит курсор на пункт \"Дома и квартиры\"")
    public void openHouseAndFlatPage() {
        houseAndFlatPage.openPage();
    }

    @Тогда("появляется выпадающее меню пункта \"Дома и квартиры\"")
    public void checkExistingDropDownMenuHouseAndFlatPage() {
        Assert.assertTrue(houseAndFlatPage.checkExistingDropDownMenu());
    }

    @Тогда("появляется выпадающее меню с категориями - города, количестов комнат, ценовой диапазон, содержит {int} категории")
    public void getElementsDropDownMenuHouseAndFlatPage(int countElement) {
        Assert.assertEquals(countElement, houseAndFlatPage.getElementsDropDownMenu().size());
    }
}
