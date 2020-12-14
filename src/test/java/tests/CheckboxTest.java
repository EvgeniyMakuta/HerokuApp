package tests;

import org.testng.annotations.Test;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class CheckboxTest extends BaseTest{

    @Test(description = "Checking if checkboxes is selected")
    public void checkBoxesIsSelected() {
        checkboxPage.openPage();
        checkboxPage.isPageOpened();
        assertFalse(checkboxPage.boxIsSelected(1));
        checkboxPage.checkBox(1);
        assertTrue(checkboxPage.boxIsSelected(1));
        assertTrue(checkboxPage.boxIsSelected(2));
        checkboxPage.checkBox(2);
        assertFalse(checkboxPage.boxIsSelected(2));
    }
}
