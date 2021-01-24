package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;
import java.util.List;

import static org.testng.Assert.fail;

public class FileDownloadPage extends BasePage {
    public static final String ENDPOINT_FILE_DOWNLOAD = "/download";
    public static final By FILE_DOWNLOADER_HEADER_LOCATOR = By.xpath("//*[contains(text(), 'File Downloader')]");
    public static final By DOWNLOAD_LIST_LOCATOR = By.xpath("//*[@class='example']/a");

    File f;
    boolean found;
    String fileNameDownloaded;

    public FileDownloadPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(FILE_DOWNLOADER_HEADER_LOCATOR));
        } catch (TimeoutException e) {
            fail("File Download page is not opened. Locator is not found: " + FILE_DOWNLOADER_HEADER_LOCATOR);
        }
    }

    @Override
    public void openPage() {
        driver.get(URL + ENDPOINT_FILE_DOWNLOAD);
    }

    public void downloadFile() throws InterruptedException {
        List<WebElement> list = driver.findElements(DOWNLOAD_LIST_LOCATOR);
        fileNameDownloaded = list.get(list.size() - 1).getText();
        WebElement el = list.get(list.size() - 1);
        System.out.println("Downloading..." + fileNameDownloaded);
        el.click();
        Thread.sleep(5000);
    }

    public boolean checkFileInFolder() {
        File folder = new File(System.getProperty("user.dir"));
        File[] listOfFiles = folder.listFiles();
        found = false;
        f = null;
        for (File listOfFile : listOfFiles) {
            if (listOfFile.isFile()) {
                String fileName = listOfFile.getName();
                System.out.println("File " + listOfFile.getName());
                if (fileName.matches(fileNameDownloaded)) {
                    f = new File(fileName);
                    found = true;
                }
            }
        }
        return found;
    }

    public void deleteFile() {
        f.deleteOnExit();
    }
}
