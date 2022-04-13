import com.codeborne.selenide.Selenide;

public abstract class BasePage {
    public void openMainPageOnliner() {
        Selenide.open("https://www.onliner.by");
    }
    public abstract void openPage();
}
