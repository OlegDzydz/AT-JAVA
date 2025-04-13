import com.example.HomePage;
import com.example.AboutUsModalPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class AboutUsTest {

    private WebDriver driver;
    private HomePage homePage;
    private AboutUsModalPage aboutUsModal;

    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver()
                .browserVersion("135.0.7049.85")
                .setup();

    }

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        aboutUsModal = new AboutUsModalPage(driver);
    }

    @Test
    public void testAboutUsModalVisibility() throws InterruptedException {
        // 1) Відкриваємо головну сторінку
        homePage.open();

        // 2) Клікаємо “About us”
        homePage.clickAboutUs();
        Thread.sleep(1000); // невелика пауза для відображення модалки

        // 3) Перевіряємо, що модалка видима
        Assert.assertTrue(aboutUsModal.isModalVisible(),
                "About Us modal should be visible");

        // 4) Закриваємо модалку
        aboutUsModal.closeModal();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
