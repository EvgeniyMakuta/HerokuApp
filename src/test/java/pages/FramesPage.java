package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.testng.Assert.fail;

public class FramesPage extends BasePage{
    public static final String ENDPOINT_FRAMES = "/frames";
    public static final By IFRAME_LINK_LOCATOR = By.xpath("//*[contains(text(), 'iFrame')]");
    public static final By IFRAME = By.id("mce_0_ifr");
    public static final By INPUT_FIELD_IFRAME = By.id("tinymce");

    public FramesPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(IFRAME_LINK_LOCATOR));
        } catch (TimeoutException e) {
            fail("Frames page is not opened. Locator is not found: " + IFRAME_LINK_LOCATOR);
        }
    }

    @Override
    public void openPage() {
        driver.get(URL + ENDPOINT_FRAMES);
    }

    public void openIFrame() {
        driver.findElement(IFRAME_LINK_LOCATOR).click();
    }

    public String getTextInIFrame() {
        return driver.findElement(INPUT_FIELD_IFRAME).getText();
    }

    public void waitForIFrameAvailableAndSwitchToIt() {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(IFRAME));
    }

}
