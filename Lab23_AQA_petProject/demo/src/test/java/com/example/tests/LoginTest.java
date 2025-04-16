package com.example.tests;

import com.example.pages.HomePage;
import com.example.pages.LoginPage;
import org.testng.annotations.*;

@Listeners({
        io.qameta.allure.testng.AllureTestNg.class,
        com.example.listeners.CustomListener.class,
        com.example.listeners.AllureAttachmentListener.class
})
public class LoginTest extends BaseTest {

    private HomePage home;
    private LoginPage login;

    @BeforeMethod
    public void initPages() {
        home = new HomePage(driver);
        login = new LoginPage(driver);
    }

    @Test(dataProvider = "loginData", dataProviderClass = DataProviders.class)
    public void testLogin(String user, String pass) {
        home.open();
        home.goToLogin();
        login.login(user, pass);

    }
}
