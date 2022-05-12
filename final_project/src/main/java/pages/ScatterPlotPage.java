package pages;

import com.codeborne.selenide.Condition;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ScatterPlotPage {
    private static final String XPATH_SCATTER_PLOT_PAGE = "//div[@class='app-title'][text()='Scatter-plot']";
    private static final String XPATH_SELECTION_BUTTON_ATTRIBUTE_BY_AXIS_X = "(//button[@class='autocomplete-caret-btn'])[1]";
    private static final String XPATH_SELECTION_ATTRIBUTE_BY_AXIS_X = "//a[@href='#'][text()='%s']";
    private static final String XPATH_SELECTION_BUTTON_ATTRIBUTE_BY_AXIS_Y = "(//button[@class='autocomplete-caret-btn'])[2]";
    private static final String XPATH_SELECTION_ATTRIBUTE_BY_AXIS_Y = "//a[@href='#'][text()='%s']";
    private static final String CSS_VALUES_AXIS_X = ".x.axis";
    private static final String CSS_NAME_AXIS_X = ".scatter-plot-x-label:nth-child(2)";
    private static final String CSS_VALUE_AXIS_Y = ".y.axis:nth-child(6)";
    private static final String CSS_NAME_AXIS_Y = ".scatter-plot-y-label:nth-child(1)";

    public void openScatterPlotPage() {
        $x(XPATH_SCATTER_PLOT_PAGE).click();
    }

    public List<String> selectXAttribute(String attribute) {
        List<String> attributes = new ArrayList<>();
        String initialValue = $(CSS_VALUES_AXIS_X).getText();
        attributes.add(initialValue);
        $x(XPATH_SELECTION_BUTTON_ATTRIBUTE_BY_AXIS_X).click();
        $x(String.format(XPATH_SELECTION_ATTRIBUTE_BY_AXIS_X, attribute)).click();
        String updatedValue = $(CSS_VALUES_AXIS_X)
                .shouldBe(Condition.not(Condition.text(initialValue)))
                .getText();
        attributes.add(updatedValue);
        String nameAxis = $(CSS_NAME_AXIS_X).getText();
        attributes.add(nameAxis);
        return attributes;
    }

    public List<String> selectYAttribute(String attribute) {
        List<String> attributes = new ArrayList<>();
        String initialValue = $(CSS_VALUE_AXIS_Y).getText();
        attributes.add(initialValue);
        $x(XPATH_SELECTION_BUTTON_ATTRIBUTE_BY_AXIS_Y).click();
        $x(String.format(XPATH_SELECTION_ATTRIBUTE_BY_AXIS_Y, attribute)).click();
        String updatedValue = $(CSS_VALUE_AXIS_Y)
                .shouldBe(Condition.not(Condition.text(initialValue)))
                .getText();
        attributes.add(updatedValue);
        String nameAxis = $(CSS_NAME_AXIS_Y).getText();
        attributes.add(nameAxis);
        return attributes;
    }
}
