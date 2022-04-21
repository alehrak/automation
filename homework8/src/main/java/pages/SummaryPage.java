package pages;

import com.codeborne.selenide.Selenide;
import enums.TablesSummaryPage;

public class SummaryPage {
    private static final String XPATH_OPENINGS_TABLE = "//div[@class='app-title flex-1 widget__header']" +
            "[text()='%s']/following-sibling::div[@title='Expand']";

    private final LoginPage loginPage = new LoginPage();

    public void openTable(TablesSummaryPage nameTable){
        loginPage.authentication();
        Selenide.$x(String.format(XPATH_OPENINGS_TABLE, nameTable.getValue())).click();
    }
}
