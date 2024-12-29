package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.AdminPage;
import pages.LoginPage;

public class AdminTest {
    WebDriver driver;
    LoginPage loginPage;
    AdminPage adminPage;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\\\\\\\chromedriver-win64\\\\\\\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/");
        loginPage = new LoginPage(driver);
        adminPage = new AdminPage(driver);
        loginPage.login("Admin", "admin123");
    }

    @Test
    public void testSearchByUsername() {
        adminPage.searchByUsername("Admin");
        Assert.assertTrue(adminPage.getSearchResultsCount() > 0);
    }

    @Test
    public void testSearchByRole() {
        adminPage.searchByRole("Admin");
        Assert.assertTrue(adminPage.getSearchResultsCount() > 0);
    }

    @Test
    public void testSearchByStatus() {
        adminPage.searchByStatus("Enabled");
        Assert.assertTrue(adminPage.getSearchResultsCount() > 0);
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }
}
