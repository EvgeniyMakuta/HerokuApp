package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TyposTest extends BaseTest {

    @Test(description = "Checking text after refreshing the page")
    public void checkTextAfterRefresh() {
        typosPage.openPage();
        typosPage.isPageOpened();
        
        assertEquals(typosPage.getContentText(),typosPage.CORRECT_TEXT);
    }
}
