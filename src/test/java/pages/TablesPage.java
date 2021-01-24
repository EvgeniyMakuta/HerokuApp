package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class TablesPage extends BasePage {
    final String ENDPOINT = "/tables";
    public static final By TABLE1 = By.id("table1");
    private String cell = "";

    public TablesPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(TABLE1));
        } catch (TimeoutException e) {
            Assert.fail("Tables page is not opened");
        }
    }

    @Override
    public void openPage() {
        driver.get(URL + ENDPOINT);
    }
}