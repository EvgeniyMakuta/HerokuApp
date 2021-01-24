package pages;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;

import static org.testng.Assert.fail;

public class FileUploaderPage extends BasePage{
    public static final String ENDPOINT_FILE_UPLOADER = "/upload";
    public static final By UPLOAD_BTN_LOCATOR = By.id("file-submit");
    public static final By UPLOADED_FILE_NAME_LOCATOR = By.id("uploaded-files");
    public static final By CHOOSE_FILE_BTN_LOCATOR = By.id("file-upload");

    File file;

    public FileUploaderPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(UPLOAD_BTN_LOCATOR));
        } catch (TimeoutException e) {
            fail("File Uploader page is not opened. Locator is not found: " + UPLOAD_BTN_LOCATOR);
        }
    }

    @Override
    public void openPage() {
        driver.get(URL + ENDPOINT_FILE_UPLOADER);
    }

    public String getUploadedFileText() {
      return driver.findElement(UPLOADED_FILE_NAME_LOCATOR).getText();
    }

    public void waitForTextIsDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(UPLOADED_FILE_NAME_LOCATOR));
    }

    public void chooseFileToUpload() {
       file = new File("src/test/resources/lessson10.png");
        driver.findElement(CHOOSE_FILE_BTN_LOCATOR).sendKeys(file.getAbsolutePath());
    }

    public void uploadFile() {
        driver.findElement(UPLOAD_BTN_LOCATOR).click();
    }
}
