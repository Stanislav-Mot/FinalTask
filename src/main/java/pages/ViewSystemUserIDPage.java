package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import utils.DataTest;

import java.util.Objects;

import static com.codeborne.selenide.Selenide.$x;

public class ViewSystemUserIDPage extends ViewSystemUsersPage {

    private final SelenideElement userRole = $x("//select[@id='systemUser_userType']");
    private final SelenideElement employeeName = $x("//input[@id='systemUser_employeeName_empName']");
    private final SelenideElement userName = $x("//input[@id='systemUser_userName']");
    private final SelenideElement status = $x("//select[@id='systemUser_status']");

    @Step("Get condition user role field")
    public boolean getConditionUserRole() {
        return !userRole.getText().isEmpty();

    }

    @Step("Get text from created user role")
    public String getUserRoleCreated() {
        return userRole.getText();

    }

    @Step("Get condition employee name")
    public boolean getConditionEmployeeName() {
        return !Objects.requireNonNull(employeeName.getAttribute(DataTest.VALUE)).isEmpty();
    }

    @Step("Get value created employee name")
    public String getEmployeeNameCreated() {
        return employeeName.getAttribute(DataTest.VALUE);
    }

    @Step("Get condition user name")
    public boolean getConditionUserName() {
        return !Objects.requireNonNull(userName.getAttribute(DataTest.VALUE)).isEmpty();
    }

    @Step("Get value created user name")
    public String getUserNameCreated() {
        return userName.getAttribute(DataTest.VALUE);
    }

    @Step("Get condition status")
    public boolean getConditionStatus() {
        return !status.getText().isEmpty();
    }

    @Step("Get text created status")
    public String getStatusCreated() {
        return status.getText();
    }
}
