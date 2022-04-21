package pages.locators;

public class ScatterPlotLocators {
    public static final String XPATH_SCATTER_PLOT =
            "//div[@class='scatter-plot-container']";
    public static final String XPATH_SCATTER_PLOT_PAGE =
            "//div[@class='app-title'][text()='Scatter-plot']";
    public static final String XPATH_SELECTION_BUTTON_ATTRIBUTE_BY_AXIS_X = "//div[text()='X Attribute']" +
            "/following-sibling::deltix-ng-autocomplete[@class='ng-untouched ng-pristine ng-valid']";
    public static final String XPATH_SELECTION_ATTRIBUTE_BY_AXIS_X =
            "//a[@href='#'][text()='%s']";
    public static final String XPATH_SELECTION_BUTTON_ATTRIBUTE_BY_AXIS_Y = "//div[text()='Y Attribute']" +
            "/following-sibling::deltix-ng-autocomplete[@class='ng-untouched ng-pristine ng-valid']";
    public static final String XPATH_SELECTION_ATTRIBUTE_BY_AXIS_Y =
            "//a[@href='#'][text()='%s']";
    public static final String XPATH_SELECTION_BUTTON_INTERVAL = "//div[text()='Intervals']" +
            "/following-sibling::app-intervals-count-autocomplete-control[@class='ng-untouched ng-pristine ng-valid']";
    public static final String XPATH_SELECTION_INTERVAL =
            "//a[@href='#'][text()='%s']";

    private ScatterPlotLocators() {
    }
}
