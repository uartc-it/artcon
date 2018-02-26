package net.artc_it.tests;

import net.artc_it.pages.PageSite;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestSite {

    public static WebDriver driver;
    public static PageSite page;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "c:\\chromedriver.exe");
        driver = new ChromeDriver();
        page = new PageSite(driver);
    }

    @Test
    public void testSendEmptyName() throws InterruptedException {
        page.sendMessageForm("", "999", "gh@fg.com", "qwerty");
        Assert.assertTrue(page.getResultMessage().isDisplayed());
//        Assert.assertNotNull(ExpectedConditions.visibilityOf(page.getResultMessage()));
    }

    @Test
    public void testSendMessage() {
        page.sendMessageForm("tyty", "678", "gh@fg.com", "qwerty");
        Assert.assertEquals(page.getExpectedResultMessage(), page.getTextResultMessage());
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}


