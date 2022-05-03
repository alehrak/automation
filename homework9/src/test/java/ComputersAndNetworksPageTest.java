import enums.ComputerAndNetworksItems;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import pages.ComputersAndNetworksPage;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ComputersAndNetworksPageTest {
    private static Logger logger = Logger.getLogger(ComputersAndNetworksPageTest.class);
    private static ComputersAndNetworksPage page = new ComputersAndNetworksPage();

    @BeforeAll
    public static void openComputersAndNetworksPage() {
        page.openPage();
        logger.info("Computers and networks page open successfully");
    }

    @Test
    public void getListItemComputersAndNetworks() {
        assertTrue(page.checkListItemForExistence());
        logger.info("a drop-down menu appeared on the screen");
    }

    public static List<String> itemsForTestOnExist() {
        List<String> items = Arrays.stream(ComputerAndNetworksItems.values())
                .map(ComputerAndNetworksItems::getValue)
                .collect(Collectors.toList());
        logger.info("collect necessary items - " + items.toString());
        return items;
    }

    @MethodSource("itemsForTestOnExist")
    @ParameterizedTest
    public void testExistItemsInComputersAndNetworksSection(String item) {
        assertTrue(page.getSectionComputersAndNetworks().contains(item));
        logger.info(String.format("the item - %s exists in the page computer and networks", item));

    }
}