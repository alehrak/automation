import enums.CatalogMenuItems;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import pages.CatalogPage;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CatalogTest {
    private static CatalogPage catalogPage = new CatalogPage();

    @BeforeAll
    public static void openCatalogPage() {
        catalogPage.openPage();
    }

    public static List<String> itemsForTestOnExist() {
        return Arrays.stream(CatalogMenuItems.values())
                .map(CatalogMenuItems::getValue)
                .collect(Collectors.toList());
    }

    @MethodSource("itemsForTestOnExist")
    @ParameterizedTest
    public void testExistItemsInCatalogMenu(String item) {
        Assertions.assertTrue(catalogPage.getSectionsCatalog().contains(item));
    }
}