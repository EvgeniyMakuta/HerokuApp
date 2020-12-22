package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class DropdownPage extends BasePage {
    final String ENDPOINT = "/dropdown";
    public static final By DROPDOWN_LIST = By.id("dropdown");

    public DropdownPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(DROPDOWN_LIST));
        } catch (TimeoutException e) {
            Assert.fail("Dropdown page is not opened");
        }
    }

    @Override
    public void openPage() {
        driver.get(URL + ENDPOINT);
    }

    public boolean elementIsSelected(int number) {
        Select select = new Select(driver.findElement(DROPDOWN_LIST));
        return select.getOptions().get(number).isSelected();
    }

    public void selectElement(int number) {
        Select select = new Select(driver.findElement(DROPDOWN_LIST));
        select.selectByIndex(number);
    }

    public int getSizeOfElements() {
        Select select = new Select(driver.findElement(DROPDOWN_LIST));
        return select.getOptions().size();
    }
}
