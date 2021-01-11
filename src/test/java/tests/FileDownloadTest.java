package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class FileDownloadTest extends BaseTest{

    @Test
    public void fileShouldBeDownloaded() throws InterruptedException {
        fileDownloadPage.openPage();
        fileDownloadPage.isPageOpened();
        fileDownloadPage.downloadFile();
        boolean isFileFoundActual = fileDownloadPage.checkFileInFolder();
        assertTrue(isFileFoundActual, "Downloaded document is not found");
        fileDownloadPage.deleteFile();
    }
}
