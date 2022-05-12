import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import pages.HistogramPage;
import pages.LoginPage;

import java.util.List;

import static constants.AuthorizationData.VALID_USER_NAME;
import static constants.AuthorizationData.VALID_USER_PASSWORD;

public class HistogramPageTest {
    private static LoginPage loginPage = new LoginPage();
    private static HistogramPage page = new HistogramPage();

    @BeforeAll
    public static void authorization() {
        loginPage.authentication(VALID_USER_NAME, VALID_USER_PASSWORD);
        page.openHistogramPage();
    }
    @AfterAll
    public static void logout() {
        loginPage.logout();
    }

    public static List<SelenideElement> getCountHistogramBars() {
        return page.getHistogramElements();
    }

    @MethodSource("getCountHistogramBars")
    @ParameterizedTest
    public void testExistenceVisibleComponents(SelenideElement bar) {
        String[] elementsBar = page.checkVisibilityBordersAndCountOrders(bar);
        Assertions.assertAll(
                () -> Assertions.assertEquals(2, elementsBar.length)
        );
    }
}
