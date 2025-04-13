
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AboutUsTest {

    @Test
    public void testAboutUsModal() throws InterruptedException {
        // Налаштування ChromeDriver за допомогою WebDriverManager
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        try {
            driver.manage().window().maximize();
            // Перехід на головну сторінку Demoblaze
            driver.get("https://www.demoblaze.com/");
            Thread.sleep(2000); // Час для завантаження сторінки

            // Знаходимо посилання "About us" за текстом посилання
            WebElement aboutUsLink = driver.findElement(By.linkText("About us"));
            Assert.assertTrue(aboutUsLink.isDisplayed(), "Посилання 'About us' має бути видно");

            // Клікаємо на посилання "About us"
            aboutUsLink.click();
            Thread.sleep(2000); // Чекаємо, поки з’явиться модальне вікно

            // Припускаємо, що модальне вікно "About us" містить елемент із id
            // "videoModalLabel"
            WebElement aboutUsModal = driver.findElement(By.id("videoModalLabel"));
            Assert.assertTrue(aboutUsModal.isDisplayed(), "Модальне вікно 'About us' має бути видно");

        } finally {
            driver.quit();
        }
    }
}
