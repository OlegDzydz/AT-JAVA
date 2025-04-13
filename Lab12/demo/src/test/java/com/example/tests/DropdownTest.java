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
        // Завантажуємо ChromeDriver, сумісний із встановленим Chrome
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        page = new DropdownPage(driver);
    }

    @Test
    public void testSelectDropdownMethods() throws InterruptedException {
        page.open();
        Thread.sleep(1000);

        // 1) selectByValue
        page.dayDropdown.selectByValue("Wednesday");
        Thread.sleep(500);

        // 2) selectByIndex
        page.dayDropdown.selectByIndex(5); // 0=Please select, 1=Sunday... 5=Thursday
        Thread.sleep(500);

        // 3) selectByVisibleText
        page.dayDropdown.selectByVisibleText("Friday");
        Thread.sleep(500);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
