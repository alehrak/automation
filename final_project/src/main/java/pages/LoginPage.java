package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.apache.log4j.Logger;

import static com.codeborne.selenide.Selenide.open;

public class LoginPage {
    private static Logger logger = Logger.getLogger(LoginPage.class);
    private static final String BASE_URL = "http://app.tca.deltixuat.com";
    private static final String XPATH_USERNAME = "//input[@formcontrolname='username']";
    private static final String XPATH_PASSWORD = "//input[@formcontrolname='password']";
    private static final String XPATH_BUTTON = "//button[@type='submit']";
    private static final String XPATH_AUTHENTICATION_ERROR_MASSAGE = "//span[text()='Bad credentials']";
    private static final String XPATH_ELEMENT_ON_MAIN_PAGE = "//div[@class='align-items-center d-flex w-100']";
    private static final String XPATH_LOGOUT = "//a[@title='Sign Out']";

    public void openBasePage() {
        // Configuration.timeout = 10000;
        open(BASE_URL);
    }

    public void authentication(String userName, String password) {
        openBasePage();
        logger.info("username - " + userName);
        logger.info("password - " + password);
        Selenide.$x(XPATH_USERNAME).setValue(userName);
        Selenide.$x(XPATH_PASSWORD).setValue(password);
        Selenide.$x(XPATH_BUTTON).click();
    }

    public boolean checkValidAuthorization(String userName, String password) {
        authentication(userName, password);
        return Selenide.$x(XPATH_ELEMENT_ON_MAIN_PAGE)
                .shouldBe(Condition.visible)
                .isDisplayed();
    }

    public boolean checkNotValidAuthorization(String userName, String password) {
        authentication(userName, password);
        return Selenide.$x(XPATH_AUTHENTICATION_ERROR_MASSAGE)
                .shouldBe(Condition.visible)
                .isDisplayed();
    }

    public void logout() {
        Selenide.$x(XPATH_LOGOUT).click();
    }
}