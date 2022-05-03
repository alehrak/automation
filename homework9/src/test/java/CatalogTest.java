import enums.CatalogMenuItems;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import pages.CatalogPage;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CatalogTest {
    private static CatalogPage catalogPage = new CatalogPage();
    private static Logger logger = Logger.getLogger(CatalogTest.class);

    @BeforeAll
    public static void openCatalogPage() {
        catalogPage.openPage();
        logger.info("Catalog page open successfully");
    }

    public static List<String> itemsForTestOnExist() {
        List<String> items = Arrays.stream(CatalogMenuItems.values())
                .map(CatalogMenuItems::getValue)
                .collect(Collectors.toList());
        logger.info("collect necessary items - " + items.toString());
        return items;
    }

    @MethodSource("itemsForTestOnExist")
    @ParameterizedTest
    public void testExistItemsInCatalogMenu(String item) {
        assertTrue(catalogPage.getSectionsCatalog().contains(item));
        logger.info(String.format("the item - %s exists in the catalog", item));
    }
}