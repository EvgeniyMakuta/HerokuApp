package tests;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class AddRemoveElementsTest extends BaseTest {

    @Test(description = "Check correct amount of elements after deleting")
    public void addRemoveElements() {
        addRemoveElementsPage.openPage();
        addRemoveElementsPage.isPageOpened();
        addRemoveElementsPage.clickOnAddButton();
        addRemoveElementsPage.clickOnAddButton();
        addRemoveElementsPage.clickOnDeleteButton();
        assertEquals(addRemoveElementsPage.getAmountOfAddButtonElements(), 1, "Incorrect amount of elements is displayed: " + addRemoveElementsPage.getAmountOfAddButtonElements());
    }
}
