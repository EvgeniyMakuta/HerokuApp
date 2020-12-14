package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DropdownTest extends BaseTest{

    @Test (description = "Checking if selected elements is marked")
    public void selectElementsAndCheckIfSelected() {
        dropdownPage.openPage();
        dropdownPage.isPageOpened();
        assertEquals(dropdownPage.getSizeOfElements(), 3);
        dropdownPage.selectElement(1);
        dropdownPage.elementIsSelected(1);
        assertTrue(dropdownPage.elementIsSelected(1));
        dropdownPage.selectElement(2);
        assertTrue(dropdownPage.elementIsSelected(2));
    }
}
