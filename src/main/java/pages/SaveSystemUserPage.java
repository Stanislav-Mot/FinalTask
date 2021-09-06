package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import logs.Log;

import static com.codeborne.selenide.Selenide.$x;

public class SaveSystemUserPage {
    private final SelenideElement userRole = $x("//select[@id='systemUser_userType']");
    private final SelenideElement employeeName = $x("//input[@id='systemUser_employeeName_empName']");
    private final SelenideElement userName = $x("//input[@id='systemUser_userName']");
    private final SelenideElement status = $x("//select[@id='systemUser_status']");
    private final SelenideElement password = $x("//input[@id='systemUser_password']");
    private final SelenideElement confirmPassword = $x("//input[@id='systemUser_confirmPassword']");
    private final SelenideElement saveButton = $x("//input[@id='btnSave']");

    public SelenideElement getErrorForEmployeeName() {
        return errorForEmployeeName;
    }

    private final SelenideElement errorForEmployeeName = $x("//span[@for='systemUser_employeeName_empName']");

    public SelenideElement getErrorForUserName() {
        return errorForUserName;
    }

    private final SelenideElement errorForUserName = $x("//span[@for='systemUser_userName']");

    public SelenideElement getErrorForPassword() {
        return errorForPassword;
    }

    private final SelenideElement errorForPassword = $x("//span[@for='systemUser_password']");

    public SelenideElement getErrorForConfirmPassword() {
        return errorForConfirmPassword;
    }

    private final SelenideElement errorForConfirmPassword = $x("//span[@for='systemUser_confirmPassword']");

    @Step("Enter data user's")
    public SaveSystemUserPage enterUserData(String userRolePar, String employeeNamePar, String userNamePar,
                                            String statusPar, String passwordPar, String passwordConf) {
        Log.info("Enter user's data");
        userRole.selectOption(userRolePar);
        employeeName.sendKeys(employeeNamePar);
        userName.sendKeys(userNamePar);
        status.selectOption(statusPar);
        password.sendKeys(passwordPar);
        confirmPassword.sendKeys(passwordConf);
        return new SaveSystemUserPage();
    }

    @Step("Enter data user's")
    public SaveSystemUserPage enterUserData(String incorrectUser) {
        Log.info("Enter user's data");
        employeeName.sendKeys(incorrectUser);
        userName.sendKeys(incorrectUser);
        password.sendKeys(incorrectUser);
        confirmPassword.sendKeys(incorrectUser);
        return new SaveSystemUserPage();
    }

    @Step("Checking user role field")
    public boolean checkingUserRole() {
        Log.info("Checking user roe field");
        return userRole.exists();
    }

    @Step("Checking employee name field")
    public boolean checkingEmployeeName() {
        Log.info("Checking employee name field");
        return employeeName.exists();
    }

    @Step("Checking user name field")
    public boolean checkingUserName() {
        Log.info("Checking user name field");
        return userName.exists();
    }

    @Step("Checking status field")
    public boolean checkingStatus() {
        Log.info("Checking status field");
        return status.exists();
    }

    @Step("Checking password field")
    public boolean checkingPassword() {
        Log.info("Checking password field");
        return password.exists();
    }

    @Step("Checking confirm password field")
    public boolean checkingConfirmPassword() {
        Log.info("Checking confirm password field");
        return confirmPassword.exists();
    }

    @Step("Click save button")
    public ViewSystemUsersPage clickSave() {
        Log.info("Click save button");
        saveButton.click();
        return new ViewSystemUsersPage();
    }
}
