import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import pages.AccessoriesPage;

import java.util.List;
import java.util.stream.Collectors;

public class AccessoriesTest {
    private static AccessoriesPage page = new AccessoriesPage();

    @BeforeAll
    public static void openCatalogPage() {
        page.openPage();
    }

    public static List<String> getVisibleComponentsOfElement() {
        ElementsCollection selenideElements = page.getListAccessories();
        return selenideElements.stream()
                .map(SelenideElement::getText)
                .collect(Collectors.toList());
    }

    @MethodSource("getVisibleComponentsOfElement")
    @ParameterizedTest
    public void testExistenceVisibleComponents(String element) {
        String[] elements = element.split("\n");
        Assertions.assertAll(
                () -> Assertions.assertEquals(3, elements.length),
                () -> Assertions.assertFalse(elements[0].isEmpty()),
                () -> Assertions.assertFalse(elements[1].isEmpty()),
                () -> Assertions.assertFalse(elements[2].isEmpty())
        );
    }
}
