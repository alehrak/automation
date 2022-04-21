package pages.locators;

public class HistogramLocators {
    public static final String XPATH_HISTOGRAM_PAGE =
            "//div[@class='app-title'][text()='Histogram']";
    public static final String XPATH_SELECTION_BUTTON_ATTRIBUTE = "//div[@class='app-title'][text()='Attribute']" +
            "/following-sibling::deltix-ng-autocomplete[@class='ng-untouched ng-pristine ng-valid']";
    public static final String XPATH_SELECTION_ATTRIBUTE =
            "//a[@href='#'][text()='%s']";
    public static final String XPATH_SELECTION_BUTTON_INTERVAL = "//div[@class='app-title'][text()='Interval']" +
            "/following-sibling::app-intervals-count-autocomplete-control[@class='ng-untouched ng-pristine ng-valid']";
    public static final String XPATH_SELECTION_INTERVAL =
            "//a[@href='#'][text()='%s']";

    private HistogramLocators() {
    }
}
