import enums.ComputerAndNetworksItems;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import pages.ComputersAndNetworksPage;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ComputersAndNetworksPageTest {
    private static ComputersAndNetworksPage page = new ComputersAndNetworksPage();

    @BeforeAll
    public static void openComputersAndNetworksPage() {
        page.openPage();
    }

    @Test
    public void getListItemComputersAndNetworks() {
        Assertions.assertTrue(page.checkListItemForExistence());
    }

    public static List<String> itemsForTestOnExist() {
        return Arrays.stream(ComputerAndNetworksItems.values())
                .map(ComputerAndNetworksItems::getValue)
                .collect(Collectors.toList());
    }

    @MethodSource("itemsForTestOnExist")
    @ParameterizedTest
    public void testExistItemsInComputersAndNetworksSection(String item) {
        Assertions.assertTrue(page.getSectionComputersAndNetworks().contains(item));
    }
}