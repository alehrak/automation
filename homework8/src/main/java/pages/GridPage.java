package pages;

import enums.GridPageBoxes;

import static com.codeborne.selenide.Selenide.$x;
import static pages.locators.GridPageLocators.*;

public class GridPage {
    private final LoginPage loginPage = new LoginPage();

    public void openGridPage() {
        loginPage.authentication();
        $x(XPATH_GRID_PAGE).click();
    }

    public void openBox(GridPageBoxes nameBox) {
        openGridPage();
        $x(String.format(XPATH_CELL_SELECTION, nameBox.getValue())).click();
    }

    public void openLinesInChart(Integer numberLine) {
        openGridPage();
        $x(String.format(XPATH_LINE_CHART, numberLine)).click();
    }
}