package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class TyposPage extends BasePage {
    public static final By CONTENT = By.id("content");
    final String ENDPOINT = "/typos";
    public final String CORRECT_TEXT = "Typos\n" + "This example demonstrates a typo being introduced. It does it randomly on each page load.\n" + "Sometimes you'll see a typo, other times you won't.";

    public TyposPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(CONTENT));
        } catch (TimeoutException e) {
            Assert.fail("Typos page is not opened");
        }
    }

    @Override
    public void openPage() {
        driver.get(URL + ENDPOINT);
    }

    public void refreshPage() {
        driver.navigate().refresh();
    }

    public String getContentText() {
        WebElement content = driver.findElement(By.id("content"));
        return content.getText();
    }
}
