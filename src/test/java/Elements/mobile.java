package Elements;

import org.testng.annotations.*;

public class mobile {
    web mainPage = new web();

    @BeforeClass
    public static void setUpAll() {

    }

    @BeforeMethod
    public void setUp() {

    }

    @Test
    public void search() {
        web.searchButton.click();
    }

    @Test
    public void toolsMenu() {

    }

    public void navigationToAllTools() {

    }
}
