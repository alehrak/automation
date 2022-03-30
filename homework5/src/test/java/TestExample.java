import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class TestExample {
    private WebDriver driver;

    @BeforeEach
    public void init() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void test() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("https://onliner.by");
        driver.findElement(By.xpath("//span[text()='Ноутбуки']")).click();
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 250)");
        driver.findElement(By.xpath("//input[@value='lenovo']/following-sibling::span")).click();
        Thread.sleep(3000);
        List<WebElement> elements = driver.findElements(By.xpath("//div[@id='schema-products']//div[@class='schema-product__group']"));
        elements.stream().forEach(webElement -> Assertions.assertTrue(webElement.findElement(By.xpath("//span[contains(text(),'Lenovo')]")).isDisplayed()));
        elements.stream().forEach(webElement -> Assertions.assertTrue(webElement.findElement(By.xpath("//a[contains(@href,'lenovo')]")).isDisplayed()));
    }

    @AfterEach
    public void deInit() {
        driver.quit();
    }
}
