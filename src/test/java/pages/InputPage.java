package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class InputPage extends BasePage {
    WebElement inputField;

    private String actualResult;
    public static final By INPUT_FIELD = By.cssSelector("input[type='number']");
    private String endpoint = "/inputs";

    public InputPage(WebDriver driver) {
        super(driver);
    }

    public String getActualResult() {
        return actualResult = inputField.getAttribute("value");
    }

    @Override
    public void isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(INPUT_FIELD));
        } catch (TimeoutException e) {
            Assert.fail("Input page is not opened");
        }
    }

    @Override
    public void openPage() {
        driver.get(URL + endpoint);
    }

    public void input(String text) {
        inputField = driver.findElement(INPUT_FIELD);
        inputField.sendKeys(text);
    }

    public void input(Keys keys) {
        inputField = driver.findElement(INPUT_FIELD);
        inputField.sendKeys(keys);
    }

    public String getNumberAsString(String text, int number) {
        if (text.equals("")) {
            return String.valueOf(number);
        }
        double parsedNumber = Double.parseDouble(text);
        if (parsedNumber < 0) {
            return String.valueOf((int) Math.floor(parsedNumber) + number);
        }
        return String.valueOf((int) parsedNumber + number);
    }
}
