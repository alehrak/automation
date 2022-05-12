import enums.AttributeScatterPlot;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import pages.LoginPage;
import pages.ScatterPlotPage;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static constants.AuthorizationData.VALID_USER_NAME;
import static constants.AuthorizationData.VALID_USER_PASSWORD;

public class ScatterPlotPageTest {
    private static Logger logger = Logger.getLogger(ScatterPlotPageTest.class);
    private static LoginPage loginPage = new LoginPage();
    private static ScatterPlotPage page = new ScatterPlotPage();

    @BeforeAll
    public static void openPage() {
        loginPage.authentication(VALID_USER_NAME, VALID_USER_PASSWORD);
        page.openScatterPlotPage();
    }

    public static List<String> attributesForCheck() {
        return Arrays.stream(AttributeScatterPlot.values())
                .map(AttributeScatterPlot::getValue)
                .collect(Collectors.toList());
    }

    @MethodSource("attributesForCheck")
    @ParameterizedTest
    public void testAxisX(String attribute) {
        logger.info("check attribute axis x: " + attribute);
        List<String> strings = page.selectXAttribute(attribute);
        Assertions.assertAll(
                () -> Assertions.assertNotEquals(strings.get(1), strings.get(0)),
                () -> Assertions.assertEquals(attribute, strings.get(2))
        );
    }

    @MethodSource("attributesForCheck")
    @ParameterizedTest
    public void testAxisY(String attribute) {
        logger.info("check attribute axis y: " + attribute);
        List<String> strings = page.selectYAttribute(attribute);
        Assertions.assertAll(
                () -> Assertions.assertNotEquals(strings.get(1), strings.get(0)),
                () -> Assertions.assertEquals(attribute, strings.get(2))
        );
    }

    @AfterAll
    public static void logout() {
        loginPage.logout();
    }
}
