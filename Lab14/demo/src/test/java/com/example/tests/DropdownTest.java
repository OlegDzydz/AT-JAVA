package com.example.tests;

import com.example.pages.DropdownPage;
import com.example.listeners.CustomListener;
import com.example.listeners.AllureAttachmentListener;
import io.qameta.allure.testng.AllureTestNg;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.annotations.Listeners;

/**
 * E2E тест для DropdownPage з інтеграцією Allure та кастомних
 * TestNG‑листенерів.
 */
@Listeners({
        AllureTestNg.class,
        CustomListener.class,
        AllureAttachmentListener.class
})
public class DropdownTest extends BaseTest {

    private DropdownPage page;

    @BeforeClass
    public void beforeClass() {
        // Підтягнути відповідний chromedriver під вашу версію Chrome
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUp() {
        // Ініціалізуємо драйвер (з BaseTest можна прибрати, якщо ініціалізація в
        // BaseTest)
        driver = new ChromeDriver();
        page = new DropdownPage(driver);
    }

    @Test(description = "Вибір елементів у дропдауні різними способами")
    public void testDropdownSelections() {
        page.open();
        page.demoQaDropdown.selectByValue("4"); // value="4" => Purple
        page.demoQaDropdown.selectByIndex(5); // index 5 => Magenta
        page.demoQaDropdown.selectByVisibleText("Black");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
