package com.example.tests;

import com.example.pages.AboutUsPage;
import com.example.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.*;

@Listeners({
        io.qameta.allure.testng.AllureTestNg.class,
        com.example.listeners.CustomListener.class,
        com.example.listeners.AllureAttachmentListener.class
})
public class AboutUsTest extends BaseTest {

    private HomePage home;
    private AboutUsPage about;

    @BeforeMethod
    public void initPages() {
        home = new HomePage(driver);
        about = new AboutUsPage(driver);
    }

    @Test(description = "Відкриваємо About Us та перевіряємо заголовок модалки")
    public void testAboutUsModal() {
        home.open();
        home.goToAboutUs();

        about.waitForModal();
        String title = about.getTitle();
        Assert.assertTrue(title.contains("About us"), "Unexpected modal title: " + title);

        about.close();
    }
}
