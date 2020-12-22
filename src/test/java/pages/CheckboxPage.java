package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

public class CheckboxPage extends BasePage {
    public final static By CHECKBOXES = By.cssSelector("*[type=checkbox]");
    final String ENDPOINT = "/checkboxes";

    public CheckboxPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(CHECKBOXES));
        } catch (TimeoutException e) {
            Assert.fail("Checkbox page is not opened");
        }
    }

    @Override
    public void openPage() {
        driver.get(URL + ENDPOINT);
    }

    public void clickOnCheckbox(int number) {
        List<WebElement> checkboxes = driver.findElements(By.tagName("input"));
        checkboxes.get(number - 1).click();
    }

    public boolean boxIsSelected(int number) {
        List<WebElement> checkboxes = driver.findElements(By.tagName("input"));
        return checkboxes.get(number - 1).isSelected();
    }
}
