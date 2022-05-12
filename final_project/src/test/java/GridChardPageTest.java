import enums.GridAndChartDataForSort;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import pages.GridAndChartPage;
import pages.LoginPage;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static constants.AuthorizationData.VALID_USER_NAME;
import static constants.AuthorizationData.VALID_USER_PASSWORD;

public class GridChardPageTest {
    private static Logger logger = Logger.getLogger(GridChardPageTest.class);
    private static LoginPage loginPage = new LoginPage();
    private static GridAndChartPage chartPage = new GridAndChartPage();

    @BeforeAll
    public static void openPage() {
        loginPage.authentication(VALID_USER_NAME, VALID_USER_PASSWORD);
        chartPage.openGridPage();
    }

    @AfterAll
    public static void logout() {
        loginPage.logout();
    }

    @Test
    public void testExecPriceOnPage() {
        Map<String, String> dataForChecking = chartPage.gettingDataForChecking(1);
        String valueExecPrice = dataForChecking.get("execPrice");
        logger.info("value exec price: "+ valueExecPrice);
        Assertions.assertAll(
                () -> Assertions.assertEquals(valueExecPrice, chartPage.getExecPriceInteractiveLegend()),
                () -> Assertions.assertEquals(valueExecPrice, chartPage.getExecPriceInfoString()),
                () -> Assertions.assertEquals(valueExecPrice, chartPage.getExecPriceGrid(dataForChecking.get("id")))
        );
    }

    @Test
    public void testMidPrices() {
        String[] midPrices = chartPage.getMidPrices();
        Assertions.assertEquals(midPrices[1], midPrices[0]);
    }

    @Test
    public void testFilterConfiguration() {
        boolean existTableBeforeSwitch = chartPage.checkExistTableColumnId();
        chartPage.openAndClickFilterConfiguration();
        boolean existTableAfterSwitch = chartPage.checkExistTableColumnId();
        Assertions.assertAll(
                () -> Assertions.assertTrue(existTableBeforeSwitch),
                () -> Assertions.assertFalse(existTableAfterSwitch)
        );
    }

    @Test
    public void testToolPanel() {
        boolean existColumnTypeBeforeShift = chartPage.checkExistInTableColumnType();
        chartPage.openAndClickToolPanel();
        boolean existColumnTypeAfterShift = chartPage.checkExistInTableColumnType();
        Assertions.assertAll(
                () -> Assertions.assertTrue(existColumnTypeBeforeShift),
                () -> Assertions.assertFalse(existColumnTypeAfterShift)
        );
    }

    @Test
    public void testFilterColumn() {
        boolean existColumnInstrumentBeforeClick = chartPage.checkExistInTableColumnSide();
        chartPage.openAndClickFilterColumn();
        boolean existColumnInstrumentAfterClick = chartPage.checkExistInTableColumnSide();
        Assertions.assertAll(
                () -> Assertions.assertTrue(existColumnInstrumentBeforeClick),
                () -> Assertions.assertFalse(existColumnInstrumentAfterClick)
        );
    }

    public static List<String> parameterColumnForCheck() {
        return Arrays.stream(GridAndChartDataForSort.values())
                .map(GridAndChartDataForSort::getValue)
                .collect(Collectors.toList());
    }

    @MethodSource("parameterColumnForCheck")
    @ParameterizedTest
    public void testSortedColumn(String nameColumn) {
        String sortedAsc = chartPage.checkSorted(nameColumn);
        String sortedDsc = chartPage.checkSorted(nameColumn);
        String nonSorted = chartPage.checkSorted(nameColumn);
        Assertions.assertAll(
                () -> Assertions.assertTrue(sortedAsc.contains("ag-icon ag-icon-asc")),
                () -> Assertions.assertTrue(sortedDsc.contains("ag-icon ag-icon-desc")),
                () -> Assertions.assertTrue(nonSorted.contains("not sorted"))
        );
    }
}
