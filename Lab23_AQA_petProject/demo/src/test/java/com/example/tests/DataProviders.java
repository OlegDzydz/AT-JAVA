package com.example.tests;

import org.testng.annotations.DataProvider;

public class DataProviders {
    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        return new Object[][] {
                { "user1", "pass1" }, { "user2", "pass2" }
        };
    }

    @DataProvider(name = "searchTerms")
    public Object[][] searchTerms() {
        return new Object[][] {
                { "Selenium" }, { "TestNG" }
        };
    }
}
