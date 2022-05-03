import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import pages.AccessoriesPage;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class AccessoriesTest {
    private static AccessoriesPage page = new AccessoriesPage();
    private static Logger logger = Logger.getLogger(AccessoriesTest.class);

    @BeforeAll
    public static void openCatalogPage() {
        page.openPage();
        logger.info("Accessories page open successfully");
    }

    public static List<String> getVisibleComponentsOfElement() {
        ElementsCollection selenideElements = page.getListAccessories();
        List<String> collectComponents = selenideElements.stream()
                .map(SelenideElement::getText)
                .collect(Collectors.toList());
        logger.info("collect checked components - " + collectComponents.toString());
        return collectComponents;
    }

    @MethodSource("getVisibleComponentsOfElement")
    @ParameterizedTest
    public void testExistenceVisibleComponents(String element) {
        String[] elements = element.split("\n");
        assertAll(
                () -> assertEquals(3, elements.length),
                () -> assertFalse(elements[0].isEmpty()),
                () -> assertFalse(elements[1].isEmpty()),
                () -> assertFalse(elements[2].isEmpty())
        );
        logger.info(String.format("the element - %s contains the number of products and the minimum price", element));
    }
}
