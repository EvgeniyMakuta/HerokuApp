package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TyposTest extends BaseTest {

    @Test(description = "Checking text after refreshing the page")
    public void checkTextAfterRefresh() {
        typosPage.openPage();
        typosPage.isPageOpened();

        while (typosPage.getText().equals(typosPage.wrongText)) {
            System.out.println("Wrong text is displayed");
            typosPage.refreshPage();
        }
        assertEquals(typosPage.getText(),typosPage.correctText);
    }
}
