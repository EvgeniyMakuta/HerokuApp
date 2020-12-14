package tests;

import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import pages.*;
import utils.CapabilitiesGenerator;

import java.util.concurrent.TimeUnit;
@Log4j2

public class BaseTest {
    WebDriver driver;
    InputPage inputPage;
    AddRemoveElementsPage addRemoveElementsPage;
    CheckboxPage checkboxPage;
    DropdownPage dropdownPage;
    TyposPage typosPage;
    private Logger log;

    @BeforeMethod (description = "Setting up before test")
    public void setUp() {
        try {
            driver = new ChromeDriver(CapabilitiesGenerator.getChromeOptions());
        } catch (SessionNotCreatedException e) {
            Assert.fail("Browser is not opened. Check if correct version is in use");
            log.fatal(e.getLocalizedMessage());
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        createInstances();
    }

    @AfterMethod (alwaysRun = true, description = "Closing the browser")
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public void createInstances() {
        inputPage = new InputPage(driver);
        addRemoveElementsPage = new AddRemoveElementsPage(driver);
        checkboxPage = new CheckboxPage(driver);
        dropdownPage = new DropdownPage(driver);
        typosPage = new TyposPage(driver);
    }

    @DataProvider(name = "data-provider")
    public static Object[][] dataProvider() {
        return new Object[][]{
                {"0", "0"},
                {"1", "1"},
                {"0001", "0001"},
                {"-1", "-1"},
                {"-02", "-02"},
                {"100500", "100500"},
                {"-100500", "-100500"},
                {"50 10", "5010"},
                {"    31", "31"},
                {"-17    ", "-17"},
                {"   0 2   5   ", "025"},
                {"1.5", "1.5"},
                {"0.0001", "0.0001"},
                {"-0.1", "-0.1"},
                {"1000.023", "1000.023"},
                {"-50.3343", "-50.3343"},
                {"0......1", "0.1"},
                {"-0..245", "-0.245"},
                {"5......", ""},
                {"0,1", "0.1"},
                {"5555,,,3", "5555.3"},
                {"-2,4", "-2.4"},
                {"adgfhdfjdkfkdgdlgl", ""},
                {"ABC", ""},
                {" fgHvFFb ", ""},
                {"ab  c", ""},
                {"1ab  4c4 35", "14435"},
                {"   4Русский4 текст1", "441"},
                {"描摹 临摹 复写 复制", ""},
                {"0描摹临摹5复写 复制1", "051"},
                {"!@#$%^&*()_+-={}[]\\\"'|,.<>/?~", ""},
                {"1!@#$%^&*()_+2- ={}[]\\\"'|,.<>/?~3", ""},
        };
    }
}
