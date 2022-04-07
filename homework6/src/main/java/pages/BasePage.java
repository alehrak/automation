package pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;

public abstract class BasePage {
    public void openMainPageOnliner() {
        //Configuration.headless = true;
        Selenide.open("https://www.onliner.by");
    }

    public abstract void openPage();
}
