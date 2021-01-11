package tests;

import org.testng.annotations.Test;

public class TablesTest extends BaseTest{

    @Test(description = "Find cell and check its value")
    public void getCell() {
        tablesPage.openPage();
        tablesPage.isPageOpened();
    }
}
