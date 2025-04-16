package com.example.tests;

import com.example.pages.DropdownPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class DropdownTest {

    private WebDriver driver;
    private DropdownPage page;

    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        page = new DropdownPage(driver);
    }

    @Test
    public void testDropdownSelections() {
        page.open();

        // Тепер вибираємо три способи на DemoQA
        page.demoQaDropdown.selectByValue("4"); // value="4" відповідає "Purple"
        page.demoQaDropdown.selectByIndex(5); // index 5 => "Magenta"
        page.demoQaDropdown.selectByVisibleText("Black");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
