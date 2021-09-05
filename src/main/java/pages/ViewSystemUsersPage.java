package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import logs.Log;
import properties.PropertyUser;

import static com.codeborne.selenide.Selenide.$x;

public class ViewSystemUsersPage {

    private final SelenideElement searchUser = $x("//input[@id='searchSystemUser_userName']");
    private final SelenideElement searchButton = $x("//input[@id='searchBtn']");
    private final String userName = "//a[contains(text(), '%s')]";
    private final SelenideElement addUser = $x("//input[@id='btnAdd']");
    private final SelenideElement deleteUser = $x("//input[@type='checkbox'][1]");
    private final SelenideElement deleteButton = $x("//input[@id='btnDelete']");
    private final SelenideElement acceptButton = $x("//input[@type='button'][@id='dialogDeleteBtn']");

    public SelenideElement getSearchResult() {
        return searchResult;
    }

    private final SelenideElement searchResult = $x("//*[contains(text(), 'No Records Found')]");

    @Step("Enter name user's for search")
    public ViewSystemUsersPage enterNameOfUserForSearch(String name) {
        try {
            Log.info("Search the user");
            searchUser.sendKeys(PropertyUser.getPropertyValue(name));
        } catch (Exception e) {
            Log.error(e);
        }
        return new ViewSystemUsersPage();
    }

    @Step("Enter created name user's for search")
    public ViewSystemUsersPage enterNameOfUserForSearchCreated(String name) {
        Log.info("Search the created user");
        searchUser.sendKeys(name);
        return new ViewSystemUsersPage();
    }

    @Step("Click search button")
    public ViewSystemUsersPage clickSearchButton() {
        Log.info("Click the search button");
        searchButton.click();
        return new ViewSystemUsersPage();
    }

    @Step("Click user")
    public void clickUser(String name) {
        try{
            Log.info("Select the user");
            $x(String.format(userName, PropertyUser.getPropertyValue(name))).click();
        } catch (Exception e){
            Log.error(e);
        }
    }

    @Step("Click created user")
    public void clickUserCreated(String name) {
        Log.info("Select the created user");
        $x(String.format(userName, name)).click();
    }

    @Step("Click adding user")
    public SaveSystemUserPage clickAddUser() {
        Log.info("Click adding user");
        addUser.click();
        return new SaveSystemUserPage();
    }

    @Step("Click deleting user")
    public ViewSystemUsersPage clickDeleteUser() {
        Log.info("click delete user");
        deleteUser.click();
        deleteButton.click();
        acceptButton.click();
        return new ViewSystemUsersPage();
    }
}
