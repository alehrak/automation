package pages;

import static com.codeborne.selenide.Selenide.open;

public abstract class BasePage {
    public void openMainPageOnliner() {
        open("https://www.onliner.by");
    }

    public abstract void openPage();
}
