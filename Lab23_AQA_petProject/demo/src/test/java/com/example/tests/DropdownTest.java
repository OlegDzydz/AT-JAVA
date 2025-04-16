package com.example.tests;

import com.example.pages.DropdownPage;
import org.testng.annotations.*;

@Listeners({ com.example.listeners.CustomListener.class, com.example.listeners.AllureAttachmentListener.class })
public class DropdownTest extends BaseTest {
    private DropdownPage page;

    @BeforeMethod
    public void initPage() {
        page = new DropdownPage(driver);
    }

    @Test
    public void testDropdownSelections() {
        page.open();
        page.dropdown.selectByValue("4");
        page.dropdown.selectByIndex(5);
        page.dropdown.selectByVisibleText("Black");
    }
}
