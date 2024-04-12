package com.example.hybridtestframework;

import org.testng.annotations.*;
import static org.testng.Assert.*;

public class MainPageTest {
    MainPage mainPage = new MainPage();

    @BeforeClass
    public static void setUpAll() {

    }

    @BeforeMethod
    public void setUp() {

    }

    @Test
    public void search() {
        MainPage.searchButton.click();
    }

    @Test
    public void toolsMenu() {

    }

    public void navigationToAllTools() {

    }
}
