package pages;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class AdminPage {
    WebDriver driver;

    @FindBy(id = "menu_admin_UserManagement")
    WebElement userManagementMenu;

    @FindBy(id = "searchSystemUser_userName")
    WebElement usernameSearchField;

    @FindBy(id = "searchSystemUser_userType")
    WebElement userRoleDropdown;

    @FindBy(id = "searchSystemUser_status")
    WebElement userStatusDropdown;

    @FindBy(id = "searchBtn")
    WebElement searchButton;

    @FindBy(xpath = "//table[@id='resultTable']/tbody/tr")
    List<WebElement> searchResults;

    public AdminPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void searchByUsername(String username) {
        usernameSearchField.clear();
        usernameSearchField.sendKeys(username);
        searchButton.click();
    }

    public void searchByRole(String role) {
        userRoleDropdown.sendKeys(role);
        searchButton.click();
    }

    public void searchByStatus(String status) {
        userStatusDropdown.sendKeys(status);
        searchButton.click();
    }

    public int getSearchResultsCount() {
        return searchResults.size();
    }
}
