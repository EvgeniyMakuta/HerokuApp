package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

abstract class BasePage {
    WebDriver driver;
    WebDriverWait wait;
    public static final String URL = "http://the-internet.herokuapp.com";

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 20);
    }

    public abstract void isPageOpened();

    public abstract void openPage();
}
