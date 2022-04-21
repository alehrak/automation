package pages.locators;

public class GridPageLocators {
    public static final String XPATH_GRID_PAGE =
            "//div[@class='app-title'][text()='Grid & chart']";
    public static final String XPATH_CELL_SELECTION = "//div[@class='ag-header-cell ag-header-cell-sortable']" +
            "//span[@class='ag-header-cell-text'][text()='%s']";
    public static final String XPATH_LINE_CHART =
            "//div[@class='ag-center-cols-container']//div[@role='row' and (@row-index='%s')]";

    private GridPageLocators() {
    }
}
