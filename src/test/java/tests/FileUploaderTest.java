package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FileUploaderTest extends BaseTest{

    @Test
    public void fileShouldBeUploaded() {
        fileUploaderPage.openPage();
        fileUploaderPage.isPageOpened();
        fileUploaderPage.chooseFileToUpload();
        fileUploaderPage.uploadFile();
        fileUploaderPage.waitForTextIsDisplayed();
        String uploadedFileTextActual = fileUploaderPage.getUploadedFileText();

        assertEquals(uploadedFileTextActual, "lessson10.png", "Incorrect file was uploaded: " + uploadedFileTextActual);
    }
}
