package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ContextMenuTest extends BaseTest{

    @Test(description = "Correct alert text should be displayed when right-clicking on the box element")
    public void alertShouldBeDisplayedWhenBoxIsRightClicked() {
        contextMenuPage.openPage();
        contextMenuPage.isPageOpened();
        contextMenuPage.rightClickOnBoxElement();
        contextMenuPage.waitForAlertDisplayed();
        String alertTextActual = contextMenuPage.getAlertText();
        contextMenuPage.pressOkInAlert();

        assertEquals(alertTextActual, "You selected a context menu", "Alert has incorrect text: " + alertTextActual);
        assertFalse(contextMenuPage.isAlertDisplayed(), "Alert is still displayed");
    }
}
