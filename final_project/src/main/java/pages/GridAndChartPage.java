package pages;

import com.codeborne.selenide.Condition;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class GridAndChartPage {
    private static Logger logger = Logger.getLogger(GridAndChartPage.class);
    private static final String XPATH_OPEN_FILTER_CONFIGURATION = "//span[@class='ml-1' and text()='Filters']";
    private static final String XPATH_CLICK_IN_FILTER_CONFIGURATION_ID = "(//span[@title='Id']/preceding-sibling::span)[2]";
    private static final String XPATH_COLUMN_ID = "//div[@class='ag-header-cell ag-header-cell-sortable']//span[text()='Id']";
    private static final String XPATH_OPEN_TOOL_PANEL = "//div[@class='ag-side-button']";
    private static final String XPATH_CLICK_IN_TOOL_PANEL_TYPE = "//span[@title='Type']/preceding-sibling::span";
    private static final String XPATH_COLUMN_TYPE = "//div[@class='ag-header-cell ag-header-cell-sortable']//span[text()='Type']";
    private static final String XPATH_FILTER_COLUMN = "//div[@col-id='orderInstrument']//span[@ref='eMenu']";
    private static final String XPATH_THIRD_TAB = "//span[@class='ag-icon ag-icon-columns']";
    private static final String XPATH_CLICK_IN_FILTER_COLUMN_SIDE = "//div[@class='ag-menu-column-select-wrapper']//span[@title='Side']/preceding-sibling::span";
    private static final String XPATH_COLUMN_SIDE = "//div[@class='ag-header-cell ag-header-cell-sortable']//span[text()='Side']";
    private static final String XPATH_CLICK_SORT_COLUMN = "//div[@class='ag-header-cell-label']//span[text()='%s']";
    private static final String XPATH_MARK_SORT = "//div[@class='ag-column-drop-cell ag-column-sort ag-theme-balham']";
    private static final String XPATH_TENDENCY_SORT = "//div[@class='ag-column-drop-cell ag-column-sort ag-theme-balham']//span[@unselectable='on']";
    private static final String XPATH_EXEC_PRICE_INTERACTIVE_LEGEND = "(//div[@class='legend-container__item-value'])[1]";
    private static final String XPATH_EXEC_PRICE_INFO_STRING = "g[class='dc-y-axis-label-container dc-y-axis-label-container-ARRIVAL_PRICE_MID']";
    private static final String XPATH_EXEC_PRICE_TABLE = "(//div[@row-id='%s'])[2]//div[@col-id='averageFillPrice']";
    private static final String XPATH_MID_PRICE_INTERACTIVE_LEGEND = "//div[@class='d-flex align-items-center']/span[text()='Mid price']/following-sibling::div[@class='legend-container__item-value']";
    private static final String CSS_MID_PRICE_TOOLTIP = "g[class='dc-y-axis-label-container dc-y-axis-label-container-MID_PRICE']";
    private static final String XPATH_GRID_PAGE = "//div[@class='app-title'][text()='Grid & chart']";
    private static final String XPATH_SELECT_LINE = "(//div[@tabindex='-1'])[%s]";
    private static final String XPATH_CLICK_LINE_SETTINGS = "//span[@class='chart-settings__title chart-mobile-title']";
    private static final String XPATH_SWITCH_AVF_FILL_PRICE = "//label[@class='switch']/following-sibling::span[text()='Avg fill price']";
    private static final String XPATH_SWITCH_MID_PRICE = "//label[@class='switch']/following-sibling::span[text()='Mid price']";
    private static final String XPATH_TOOLTIP = "//div[@class='chart-view__info mb-2 hidden-text']";


    public void openGridPage() {
        $x(XPATH_GRID_PAGE).click();
    }

    public void selectLine(Integer numberElement) {
        $x(String.format(XPATH_SELECT_LINE, numberElement)).click();
    }

    public void clickPlusLines(Integer numberElement) {
        selectLine(numberElement);
        $x(XPATH_CLICK_LINE_SETTINGS).click();
    }

    public void switchVisibilityAvgAndMidPrice(Integer numberElement) {
        clickPlusLines(numberElement);
        $x(XPATH_SWITCH_AVF_FILL_PRICE).click();
        $x(XPATH_SWITCH_MID_PRICE).click();
    }

    public void selectLineWithExecutions(Integer numberStartLine) {
        switchVisibilityAvgAndMidPrice(numberStartLine);
        String textTooltip = $x(XPATH_TOOLTIP).innerText();
        int startPositionSubstringExecutions = textTooltip.indexOf("Num of executions:  ") + 20;
        int finishPositionSubstringExecutions = textTooltip.indexOf(",  Improvement");
        String countExecutions = textTooltip.substring(startPositionSubstringExecutions, finishPositionSubstringExecutions);
        if (!countExecutions.equals("0")) {
            logger.info("order with executions in quantity - " + countExecutions);
        } else {
            logger.info("order without executions");
            selectLineWithExecutions(numberStartLine++);
        }
    }

    public Map<String, String> gettingDataForChecking(Integer startNumberElement) {
        selectLineWithExecutions(startNumberElement);
        Map<String, String> data = new HashMap<>();
        String textTooltip = $x(XPATH_TOOLTIP).innerText();
        int startPositionSubstringExecPrice = textTooltip.indexOf("price:") + 8;
        int finishPositionSubstringExecPrice = textTooltip.indexOf(",  Exec size");
        String execPrice = textTooltip.substring(startPositionSubstringExecPrice, finishPositionSubstringExecPrice);
        int startPositionSubstringId = textTooltip.indexOf("ID:  ") + 5;
        int finishPositionSubstringId = textTooltip.indexOf(",");
        String id = textTooltip.substring(startPositionSubstringId, finishPositionSubstringId);
        data.put("id", id);
        data.put("execPrice", execPrice);
        logger.info("data for check: id = " + id + ", exec price = " + execPrice);
        return data;
    }

    public String getExecPriceInteractiveLegend() {
        String execPriceWithSpace = $x(XPATH_EXEC_PRICE_INTERACTIVE_LEGEND).getText();
        String execPrice = execPriceWithSpace.trim();
        logger.info("exec price interactive legend = " + execPrice);
        return execPrice;
    }

    public String getExecPriceInfoString() {
        String execPrice = $(XPATH_EXEC_PRICE_INFO_STRING).getText();
        logger.info("exec price info string = " + execPrice);
        return execPrice;
    }

    public String getExecPriceGrid(String id) {
        String execPrice = $x(String.format(XPATH_EXEC_PRICE_TABLE, id)).getText();
        logger.info("exec price in grid = " + execPrice);
        return execPrice;
    }

    public String[] getMidPrices() {
        selectLine(1);
        selectLine(1);
        $x(XPATH_CLICK_LINE_SETTINGS).click();
        $x(XPATH_SWITCH_MID_PRICE).shouldBe(Condition.visible).click();
        String midPriceLegend = $x(XPATH_MID_PRICE_INTERACTIVE_LEGEND).getText();
        String midPriceTooltipWithText = $(CSS_MID_PRICE_TOOLTIP).getText();
        String[] midPriceSplit = midPriceTooltipWithText.split("\n");
        String midPriceTooltip = midPriceSplit[1];
        logger.info("mid price legend = " + midPriceLegend);
        logger.info("mid price tooltip = " + midPriceTooltip);
        return new String[]{midPriceLegend, midPriceTooltip};
    }

    public void openAndClickFilterConfiguration() {
        $x(XPATH_OPEN_FILTER_CONFIGURATION).click();
        $x(XPATH_CLICK_IN_FILTER_CONFIGURATION_ID).click();
    }

    public boolean checkExistTableColumnId() {
        return $x(XPATH_COLUMN_ID).isDisplayed();
    }

    public void openAndClickToolPanel() {
        $x(XPATH_OPEN_TOOL_PANEL).click();
        $x(XPATH_CLICK_IN_TOOL_PANEL_TYPE).click();
    }

    public boolean checkExistInTableColumnType() {
        return $x(XPATH_COLUMN_TYPE).isDisplayed();
    }

    public void openAndClickFilterColumn() {
        $x(XPATH_FILTER_COLUMN).click();
        $x(XPATH_THIRD_TAB).click();
        $x(XPATH_CLICK_IN_FILTER_COLUMN_SIDE).click();
    }

    public boolean checkExistInTableColumnSide() {
        return $x(XPATH_COLUMN_SIDE).isDisplayed();
    }

    public String checkSorted(String nameColumn) {
        $x(String.format(XPATH_CLICK_SORT_COLUMN, nameColumn))
                .scrollIntoView(true)
                .click();
        if ($x(XPATH_MARK_SORT).isDisplayed()) {
            return $x(XPATH_TENDENCY_SORT)
                    .shouldBe(Condition.visible)
                    .getAttribute("class");
        } else {
            return "not sorted";
        }
    }
}
