package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

public class DynamicControlsPage extends BasePage{
    public static final String ENDPOINT_DYNAMIC_CONTROLS = "/dynamic_controls";
    public static final By ENABLE_BTN_LOCATOR = By.xpath("//button[contains(text(), 'Enable')]");
    public static final By CHECKBOX_LOCATOR = By.xpath("//*[@type='checkbox']");
    public static final By REMOVE_BTN_LOCATOR = By.xpath("//button[contains(text(), 'Remove')]");
    public static final By ADD_BTN_LOCATOR = By.xpath("//button[contains(text(), 'Add')]");
    public static final By MESSAGE_LOCATOR = By.id("message");
    public static final By INPUT_FIELD_LOCATOR = By.xpath("//input[@type='text']");


    public DynamicControlsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(ENABLE_BTN_LOCATOR));
        } catch (TimeoutException e) {
            fail("Dynamic Controls page is not opened. Locator is not found: " + ENABLE_BTN_LOCATOR);
        }
    }

    @Override
    public void openPage() {
        driver.get(URL + ENDPOINT_DYNAMIC_CONTROLS);
    }

    public void clickOnCheckbox() {
        driver.findElement(CHECKBOX_LOCATOR).click();
    }

    public void clickRemoveCheckboxBtn() {
        driver.findElement(REMOVE_BTN_LOCATOR).click();
    }

    public void clickAddCheckboxBtn() {
        driver.findElement(ADD_BTN_LOCATOR).click();
    }

    public String getMessage() {
       return driver.findElement(MESSAGE_LOCATOR).getText();
    }

    public boolean isCheckboxDisplayed() {
       return driver.findElements(CHECKBOX_LOCATOR).isEmpty();
    }

    public void waitForMessageDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(MESSAGE_LOCATOR));
        } catch (TimeoutException e) {
            fail("Message is not displayed");
        }
    }

    public boolean isInputEnabled() {
       return driver.findElement(INPUT_FIELD_LOCATOR).isEnabled();
    }

    public void clickOnEnabledBtn() {
        driver.findElement(ENABLE_BTN_LOCATOR).click();
    }

}
