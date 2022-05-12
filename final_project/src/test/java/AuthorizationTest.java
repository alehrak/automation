import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.LoginPage;

import static constants.AuthorizationData.*;

public class AuthorizationTest {
    private LoginPage loginPage = new LoginPage();

    @Test
    public void testValidAuthorization() {
        Assertions.assertTrue(loginPage.checkValidAuthorization(VALID_USER_NAME, VALID_USER_PASSWORD));
        loginPage.logout();
    }

    @Test
    public void testNegativeAuthorization() {
        Assertions.assertAll(
                () -> Assertions.assertTrue(loginPage.checkNotValidAuthorization(VALID_USER_NAME, NOT_VALID_USER_PASSWORD)),
                () -> Assertions.assertTrue(loginPage.checkNotValidAuthorization(NOT_VALID_USER_NAME, VALID_USER_PASSWORD)),
                () -> Assertions.assertTrue(loginPage.checkNotValidAuthorization(NOT_VALID_USER_NAME, NOT_VALID_USER_PASSWORD))
        );
    }
}
