package pages;

import com.codeborne.selenide.Selenide;

public class LoginPage {
    private static final String USER_NAME = "selenium_chrome";
    private static final String USER_PASSWORD = "Axa@Demo";
    private static final String BASE_URL = "http://app.tca.deltixuat.com";
    private static final String XPATH_USERNAME = "//input[@formcontrolname='username']";
    private static final String XPATH_PASSWORD = "//input[@formcontrolname='password']";
    private static final String XPATH_BUTTON = "//button[@type='submit']";
   // private static final String XPATH_AUTHENTICATION_ERROR_MASSAGE = "//span[text()='Bad credentials']";

    public void openBasePage() {
        Selenide.open(BASE_URL);
    }

    public void authentication() {
        openBasePage();
        Selenide.$x(XPATH_USERNAME).setValue(USER_NAME);
        Selenide.$x(XPATH_PASSWORD).setValue(USER_PASSWORD);
        Selenide.$x(XPATH_BUTTON).click();
    }
}
