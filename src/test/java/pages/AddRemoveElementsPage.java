package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

public class AddRemoveElementsPage extends BasePage {
    final String ENDPOINT = "/add_remove_elements/";
    public static final By ADD_ELEMENT_BUTTON = By.xpath("//*[@onclick='addElement()']");
    public static final By DELETE_BUTTON = By.xpath("//*[@onclick='deleteElement()']");

    public AddRemoveElementsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(ADD_ELEMENT_BUTTON));
        } catch (TimeoutException e) {
            Assert.fail("Add/Remove Elements page is not opened");
        }
    }

    @Override
    public void openPage() {
        driver.get(URL + ENDPOINT);
    }

    public void addElement() {
        driver.findElement(ADD_ELEMENT_BUTTON).click();
    }

    public void deleteElement() {
        driver.findElement(DELETE_BUTTON).click();
    }

    public int getAmountOfElements() {
        List<WebElement> actualResult = driver.findElements(By.id("elements"));
        return actualResult.size();
    }
}
