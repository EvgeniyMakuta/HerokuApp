package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FramesTest extends BaseTest{

    @Test(description = "Correct text is displayed in the input field in iFrame")
    public void correctTextShouldBeDisplayedInIFrameInputField() {
        framesPage.openPage();
        framesPage.isPageOpened();
        framesPage.openIFrame();
        framesPage.waitForIFrameAvailableAndSwitchToIt();
        String textInInputFieldInIFrameActual = framesPage.getTextInIFrame();

        assertEquals(textInInputFieldInIFrameActual, "Your content goes here.", "Incorrect text is displayed in the input field in iFrame: " + textInInputFieldInIFrameActual);
    }
}
