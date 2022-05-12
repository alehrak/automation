package steps;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import pages.LoginPage;
import pages.MainPage;

import java.util.List;

import static constants.AuthorizationData.VALID_USER_NAME;
import static constants.AuthorizationData.VALID_USER_PASSWORD;

public class MainPageStepDefinition {
    private static LoginPage loginPage = new LoginPage();
    private MainPage mainPage = new MainPage();

    @BeforeAll
    public static void openMainPage() {
        loginPage.authentication(VALID_USER_NAME, VALID_USER_PASSWORD);
    }

    @AfterAll
    public static void logout() {
        loginPage.logout();
    }

    @Then("the user sees the settings button")
    public void theUserSeesTheSettingsButton() {
        Assertions.assertTrue(mainPage.checkSettingButton());
    }

    @Then("the user sees Benchmark Selector control")
    public void theUserSeesBenchmarkSelectorControl() {
        Assertions.assertTrue(mainPage.checkBenchmarkSelector());
    }

    @Then("the user sees Application Toolbar with items")
    public void theUserSeesApplicationToolbarWithItems(List<String> items) {
        for (String item : items) {
            Assertions.assertTrue(mainPage.componentApplicationToolbar(item));
        }
    }
}
