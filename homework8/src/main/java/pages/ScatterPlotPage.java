package pages;

import com.codeborne.selenide.Selenide;
import enums.AttributeSettingsHistogramAndScatterPlot;
import enums.HistogramPageAndScatterPlotIntervals;

import static pages.locators.ScatterPlotLocators.*;

public class ScatterPlotPage {
    private final LoginPage loginPage = new LoginPage();

    public void openScatterPlotPage() {
        loginPage.authentication();
        Selenide.$x(XPATH_SCATTER_PLOT_PAGE).click();
    }

    public void selectXAttribute(AttributeSettingsHistogramAndScatterPlot attribute) {
        openScatterPlotPage();
        Selenide.$x(XPATH_SELECTION_BUTTON_ATTRIBUTE_BY_AXIS_X).click();
        Selenide.$x(String.format(XPATH_SELECTION_ATTRIBUTE_BY_AXIS_X, attribute.getValue())).click();
    }

    public void selectYAttribute(AttributeSettingsHistogramAndScatterPlot attribute) {
        openScatterPlotPage();
        Selenide.$x(XPATH_SELECTION_BUTTON_ATTRIBUTE_BY_AXIS_Y).click();
        Selenide.$x(String.format(XPATH_SELECTION_ATTRIBUTE_BY_AXIS_Y, attribute.getValue())).click();
    }

    public void selectIntervals(HistogramPageAndScatterPlotIntervals interval) {
        openScatterPlotPage();
        Selenide.$x(XPATH_SELECTION_BUTTON_INTERVAL).click();
        Selenide.$x(String.format(XPATH_SELECTION_INTERVAL, interval.getValue())).click();
    }
}
