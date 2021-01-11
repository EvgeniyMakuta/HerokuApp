package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import javax.swing.*;

import static org.testng.Assert.fail;

public class ContextMenuPage extends BasePage{
    public static final String ENDPOINT_CONTEXT_MENU = "/context_menu";
    public static final By BOX_LOCATOR = By.id("hot-spot");

    Actions actions;
    Alert alert;

    public ContextMenuPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(BOX_LOCATOR));
        } catch (TimeoutException e) {
            fail("Context Menu page is not opened. Locator is not found: " + BOX_LOCATOR);
        }
    }

    @Override
    public void openPage() {
            driver.get(URL + ENDPOINT_CONTEXT_MENU);
    }

    public void rightClickOnBoxElement() {
        actions = new Actions(driver);
        WebElement boxElement = driver.findElement(BOX_LOCATOR);
        actions.contextClick(boxElement).click().perform();
    }

    public void waitForAlertDisplayed() {
        alert = wait.until(ExpectedConditions.alertIsPresent());
    }

    public boolean isAlertDisplayed() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    public String getAlertText() {
        String alertText = alert.getText();
        return alertText;
    }

    public void pressOkInAlert() {
        alert.accept();
    }
}
