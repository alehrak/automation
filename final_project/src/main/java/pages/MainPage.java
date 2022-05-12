package pages;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage {
    private static final String XPATH_SETTING_BUTTON = "//a[@class='header__link header__link_font mr-3' and @title='Settings']";
    private static final String XPATH_BENCHMARK_SELECTOR = "//div[@class='mr-2']";
    private static final String XPATH_APPLICATION_TOOLBAR = "//div[@class='app-title' and text()='%s']";

    public boolean checkSettingButton() {
        return $x(XPATH_SETTING_BUTTON)
                .isEnabled();
    }

    public boolean checkBenchmarkSelector() {
        return $x(XPATH_BENCHMARK_SELECTOR)
                .isEnabled();
    }

    public boolean componentApplicationToolbar(String component) {
        return $x(String.format(XPATH_APPLICATION_TOOLBAR, component))
                .isDisplayed();
    }
}
