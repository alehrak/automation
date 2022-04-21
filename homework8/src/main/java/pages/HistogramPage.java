package pages;

import com.codeborne.selenide.Selenide;
import enums.AttributeSettingsHistogramAndScatterPlot;
import enums.HistogramPageAndScatterPlotIntervals;

import static pages.locators.HistogramLocators.*;

public class HistogramPage {
    private final LoginPage loginPage = new LoginPage();

    public void openHistogramPage() {
        loginPage.authentication();
        Selenide.$x(XPATH_HISTOGRAM_PAGE).click();
    }

    public void selectionAttribute(AttributeSettingsHistogramAndScatterPlot attributeForSelected) {
        openHistogramPage();
        Selenide.$x(XPATH_SELECTION_BUTTON_ATTRIBUTE).click();
        Selenide.$x(String.format(XPATH_SELECTION_ATTRIBUTE, attributeForSelected.getValue())).click();
    }

    public void selectionIntervals(HistogramPageAndScatterPlotIntervals interval) {
        openHistogramPage();
        Selenide.$x(XPATH_SELECTION_BUTTON_INTERVAL).click();
        Selenide.$x(String.format(XPATH_SELECTION_INTERVAL, interval.getValue())).click();
    }
}
