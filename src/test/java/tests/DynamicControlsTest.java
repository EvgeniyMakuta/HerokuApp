package tests;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

public class DynamicControlsTest extends BaseTest{

    @Test(description = "Checkbox should be deleted when tapping Remove button")
    public void checkboxShouldBeRemoved() {
        dynamicControlsPage.openPage();
        dynamicControlsPage.isPageOpened();
        dynamicControlsPage.clickOnCheckbox();
        dynamicControlsPage.clickRemoveCheckboxBtn();
        dynamicControlsPage.waitForMessageDisplayed();
        String messageActual = dynamicControlsPage.getMessage();

        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        assertTrue(dynamicControlsPage.isCheckboxDisplayed(), "Checkbox was not deleted");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        assertEquals(messageActual, "It's gone!");
    }

    @Test(description = "Input should be disabled")
    public void inputShouldBeDisabled() {
        dynamicControlsPage.openPage();
        dynamicControlsPage.isPageOpened();
        boolean inputFieldEnabled = dynamicControlsPage.isInputEnabled();
        dynamicControlsPage.clickOnEnabledBtn();

        assertFalse(inputFieldEnabled, "Input field is enabled");
    }

    @Test(description = "Input should become enabled after tapping enable button")
    public void inputFieldShouldBecomeEnabled() {
        dynamicControlsPage.openPage();
        dynamicControlsPage.isPageOpened();
        dynamicControlsPage.clickOnEnabledBtn();
        dynamicControlsPage.waitForMessageDisplayed();
        String messageActual = dynamicControlsPage.getMessage();
        boolean inputFieldEnabled = dynamicControlsPage.isInputEnabled();

        assertTrue(inputFieldEnabled, "Input field is disabled");
        assertEquals(messageActual, "It's enabled!");
    }
}
