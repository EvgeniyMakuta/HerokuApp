package tests;

import org.testng.annotations.Test;
import static org.openqa.selenium.Keys.ARROW_DOWN;
import static org.openqa.selenium.Keys.ARROW_UP;
import static org.testng.Assert.assertEquals;

public class InputTest extends BaseTest {
    @Test(description = "Entering different data-sets to the input field", dataProvider = "data-provider")
    public void inputDifferentValues(String text, String expectedText) {
        inputPage.openPage();
        inputPage.isPageOpened();
        inputPage.input(text);
        assertEquals(inputPage.getActualResult(), expectedText);

        inputPage.input(ARROW_UP);
        assertEquals(inputPage.getActualResult(), inputPage.getNumberAsString(expectedText, 1));

        inputPage.input(ARROW_UP);
        assertEquals(inputPage.getActualResult(), inputPage.getNumberAsString(expectedText, 2));

        inputPage.input(ARROW_DOWN);
        assertEquals(inputPage.getActualResult(), inputPage.getNumberAsString(expectedText, 1));

        inputPage.input(ARROW_DOWN);
        assertEquals(inputPage.getActualResult(), inputPage.getNumberAsString(expectedText, 0));

        inputPage.input(ARROW_DOWN);
        assertEquals(inputPage.getActualResult(), inputPage.getNumberAsString(expectedText, -1));
    }
}
