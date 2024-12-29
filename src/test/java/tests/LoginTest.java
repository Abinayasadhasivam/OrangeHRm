package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.LoginPage;
import utils.ExcelReader;

public class LoginTest {
    WebDriver driver;
    LoginPage loginPage;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\\\chromedriver-win64\\\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/");
        loginPage = new LoginPage(driver);
    }

    @DataProvider(name = "loginData")
    public Object[][] getLoginData() {
        return ExcelReader.readExcel("C:\\Test\\loginData.xlsx", "Sheet1");
    }

    @Test(dataProvider = "loginData")
    public void testLogin(String username, String password, boolean isValid) {
        loginPage.login(username, password);
        if (isValid) {
            Assert.assertTrue(loginPage.isLoginSuccessful());
        } else {
            Assert.assertFalse(loginPage.isLoginSuccessful());
        }
        loginPage.logout();
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }
}
